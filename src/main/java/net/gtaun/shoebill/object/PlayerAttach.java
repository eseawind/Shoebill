/**
 * Copyright (C) 2011 JoJLlmAn
 * Copyright (C) 2011 MK124
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.gtaun.shoebill.object;

import net.gtaun.shoebill.data.Vector3D;
import net.gtaun.shoebill.data.type.PlayerAttachBone;
import net.gtaun.shoebill.samp.SampNativeFunction;

/**
 * @author JoJLlmAn, MK124
 *
 */


public class PlayerAttach implements IPlayerAttach
{
	public static final int MAX_ATTACHED_OBJECTS = 5;

	
	public class PlayerAttachSlot implements IPlayerAttachSlot
	{
		private int slot;
		
		private PlayerAttachBone bone = PlayerAttachBone.NOT_USABLE;
		private int modelId = 0;
		private Vector3D offset, rotation, scale;
		
		@Override public PlayerAttachBone getBone()			{ return bone; }
		@Override public int getModelId()					{ return modelId; }
		@Override public Vector3D getOffset()				{ return offset; }
		@Override public Vector3D getRotation()				{ return rotation; }
		@Override public Vector3D getScale()				{ return scale; }
		
		
		PlayerAttachSlot( int slot )
		{
			this.slot = slot;
		}

		@Override
		public boolean set( PlayerAttachBone bone, int modelId, Vector3D offset, Vector3D rot, Vector3D scale )
		{
			if( bone == PlayerAttachBone.NOT_USABLE ) return false;
			if( ! SampNativeFunction.setPlayerAttachedObject(playerId, slot, modelId, bone.getData(), offset.x, offset.y, offset.z, rot.x, rot.y, rot.z, scale.x, scale.y, scale.z) )
				return false;
			
			this.bone = bone;
			this.modelId = modelId;
			
			this.offset = offset.clone();
			this.rotation = rotation.clone();
			this.scale = scale.clone();
			
			return true;
		}

		@Override
		public boolean remove()
		{
			if( bone == PlayerAttachBone.NOT_USABLE ) return false;
			if( ! SampNativeFunction.removePlayerAttachedObject(playerId, slot) ) return false;
			
			bone = PlayerAttachBone.NOT_USABLE;
			modelId = 0;
			
			offset = null;
			rotation = null;
			scale = null;
			
			return true;
		}

		@Override
		public boolean isUsed( int slot )
		{
			return bone != PlayerAttachBone.NOT_USABLE;
		}
	}
	
	
	private int playerId;
	
	private PlayerAttachSlot[] slots = new PlayerAttachSlot[MAX_ATTACHED_OBJECTS];

	
	PlayerAttach( int playerId )
	{
		this.playerId = playerId;
		
		for( int i=0; i<MAX_ATTACHED_OBJECTS; i++ )
		{
			slots[i] = new PlayerAttachSlot(i);
		}
	}
	
	@Override
	public IPlayerAttachSlot getSlot( int slot )
	{
		return slots[ slot ];
	}

	@Override
	public IPlayerAttachSlot[] getSlots()
	{
		return slots.clone();
	}
}
