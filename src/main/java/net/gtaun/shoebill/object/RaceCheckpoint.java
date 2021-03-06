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

import java.util.Collection;
import java.util.Vector;

import net.gtaun.shoebill.data.Location;
import net.gtaun.shoebill.data.Vector3D;
import net.gtaun.shoebill.data.type.RaceCheckpointType;
import net.gtaun.shoebill.samp.SampNativeFunction;

/**
 * @author JoJLlmAn, MK124
 *
 */

public class RaceCheckpoint implements IRaceCheckpoint
{
	private Vector3D location;
	private float size;
	private RaceCheckpointType type;
	private RaceCheckpoint next;

	
	@Override public Vector3D getLocation()							{ return location.clone(); }
	@Override public float getSize()								{ return size; }
	@Override public RaceCheckpointType getType()					{ return type; }
	@Override public RaceCheckpoint getNext()						{ return next; }
	
	
	public RaceCheckpoint( float x, float y, float z, float size, RaceCheckpointType type, RaceCheckpoint next )
	{
		this.location = new Vector3D( x, y, z );
		this.size = size;
		this.type = type;
		this.next = next;
	}

	public RaceCheckpoint( Location location, float size, RaceCheckpointType type, RaceCheckpoint next )
	{
		this.location = location.clone();
		this.size = size;
		this.type = type;
		this.next = next;
	}
	

	@Override
	public void setLocation( Vector3D location )
	{
		this.location = location;
		update();
	}
	
	@Override
	public void set( IPlayer player )
	{
		player.setRaceCheckpoint( this );
	}
	
	@Override
	public void disable( IPlayer player )
	{
		if( player.getRaceCheckpoint() != this ) return;
		player.disableRaceCheckpoint();
	}
	
	@Override
	public boolean isInCheckpoint( IPlayer player )
	{
		if( player.getRaceCheckpoint() != this ) return false;
		
		return SampNativeFunction.isPlayerInRaceCheckpoint( player.getId() );
	}
	
	@Override
	public void update()
	{
		for( IPlayer player : Player.get() )
		{
			if( player == null ) continue;			
			if( player.getRaceCheckpoint() == this ) set( player );
		}
	}
	
	@Override
	public Collection<IPlayer> getUsingPlayers()
	{
		Collection<IPlayer> players = new Vector<IPlayer>();
		for( IPlayer player : Player.get() )
		{
			if( player.getRaceCheckpoint() == this ) players.add( player );
		}
		
		return players;
	}
}
