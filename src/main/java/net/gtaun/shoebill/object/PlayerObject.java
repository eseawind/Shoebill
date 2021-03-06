/**
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

import net.gtaun.shoebill.SampObjectPool;
import net.gtaun.shoebill.Shoebill;
import net.gtaun.shoebill.data.Location;
import net.gtaun.shoebill.data.LocationRotational;
import net.gtaun.shoebill.samp.SampNativeFunction;

/**
 * @author MK124
 *
 */

public class PlayerObject implements IPlayerObject
{
	public static Collection<IPlayerObject> get( IPlayer player )
	{
		return Shoebill.getInstance().getManagedObjectPool().getPlayerObjects( player );
	}
	
	public static <T extends IPlayerObject> Collection<T> get( IPlayer player, Class<T> cls )
	{
		return Shoebill.getInstance().getManagedObjectPool().getPlayerObjects( player, cls );
	}
	

	void processPlayerObjectMoved()
	{
		speed = 0;
	}
	
	private int id = -1;
	private Player player;
	
	private int modelId;
	private LocationRotational position;
	private float speed = 0;
	private IPlayer attachedPlayer;
	private float drawDistance = 0;
	
	
	@Override public Player getPlayer()								{ return player; }

	@Override public int getId()									{ return id; }
	@Override public int getModelId()								{ return modelId; }
	@Override public float getSpeed()								{ return speed; }
	@Override public float getDrawDistance()						{ return drawDistance; }
	@Override public IPlayer getAttachedPlayer()					{ return attachedPlayer; }
	@Override public IObject getAttachedObject()					{ return null; }
	@Override public IVehicle getAttachedVehicle()					{ return null; }
	
	
	public PlayerObject( Player player, int modelId, float x, float y, float z, float rx, float ry, float rz )
	{
		this.player = player;
		this.modelId = modelId;
		this.position = new LocationRotational( x, y, z, rx, ry, rz );
		
		init();
	}
	
	public PlayerObject( Player player, int modelId, float x, float y, float z, float rx, float ry, float rz, float drawDistance )
	{
		this.player = player;
		this.modelId = modelId;
		this.position = new LocationRotational( x, y, z, rx, ry, rz );
		this.drawDistance = drawDistance;
		
		init();
	}
	
	public PlayerObject( Player player, int modelId, Location location, float rx, float ry, float rz )
	{
		this.player = player;
		this.modelId = modelId;
		this.position = new LocationRotational( location, rx, ry, rz );
		
		init();
	}
	
	public PlayerObject( Player player, int modelId, Location location, float rx, float ry, float rz, float drawDistance )
	{
		this.player = player;
		this.modelId = modelId;
		this.position = new LocationRotational( location, rx, ry, rz );
		this.drawDistance = drawDistance;
		
		init();
	}
	
	public PlayerObject( Player player, int modelId, LocationRotational location )
	{
		this.player = player;
		this.modelId = modelId;
		this.position = location.clone();
		
		init();
	}
	
	public PlayerObject( Player player, int modelId, LocationRotational location, float drawDistance )
	{
		this.player = player;
		this.modelId = modelId;
		this.position = location.clone();
		this.drawDistance = drawDistance;
		
		init();
	}
	
	private void init()
	{
		id = SampNativeFunction.createPlayerObject( player.getId(), modelId, position.x, position.y, position.z, position.rx, position.ry, position.rz, drawDistance );
		
		SampObjectPool pool = (SampObjectPool) Shoebill.getInstance().getManagedObjectPool();
		pool.setPlayerObject( player, id, this );
	}
	

	@Override
	public void destroy()
	{
		SampNativeFunction.destroyObject( id );

		SampObjectPool pool = (SampObjectPool) Shoebill.getInstance().getManagedObjectPool();
		pool.setPlayerObject( player, id, null );
		
		id = -1;
	}

	@Override
	public boolean isDestroyed()
	{
		return id == -1;
	}
	
	@Override
	public LocationRotational getLocation()
	{	
		SampNativeFunction.getPlayerObjectPos( player.getId(), id, position );
		SampNativeFunction.getPlayerObjectRot( player.getId(), id, position );
		return position.clone();
	}
	
	@Override
	public void setLocation( Location location )
	{
		this.position.set( location );
		SampNativeFunction.setPlayerObjectPos( player.getId(), id, location.x, location.y, location.z );
	}
	
	@Override
	public void setLocation( LocationRotational location )
	{
		this.position = location.clone();
		SampNativeFunction.setPlayerObjectPos( player.getId(), id, location.x, location.y, location.z );
		SampNativeFunction.setPlayerObjectRot( player.getId(), id, location.rx, location.ry, location.rz );
	}
	
	@Override
	public void setRotate( float rx, float ry, float rz )
	{
		position.rx = rx;
		position.ry = ry;
		position.rz = rz;
		
		SampNativeFunction.setPlayerObjectRot( player.getId(), id, rx, ry, rz );
	}
	
	@Override
	public boolean isMoving()
	{
		return SampNativeFunction.isPlayerObjectMoving(player.getId(), id );
	}
	
	@Override
	public int move( float x, float y, float z, float speed )
	{
		SampNativeFunction.movePlayerObject( player.getId(), id, x, y, z, speed );
		if(attachedPlayer == null) this.speed = speed;
		return 0;
	}
	
	@Override
	public void stop()
	{
		speed = 0;
		SampNativeFunction.stopPlayerObject( player.getId(), id );
	}
	
	@Override
	public void attach( IPlayer player, float x, float y, float z, float rx, float ry, float rz )
	{
		SampNativeFunction.attachPlayerObjectToPlayer( this.player.getId(), id, player.getId(), x, y, z, rx, ry, rz );
		this.attachedPlayer = player;
		speed = 0;
	}
	
	@Override
	public void attach( IObject object, float x, float y, float z, float rx, float ry, float rz, boolean syncRotation )
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void attach( IVehicle vehicle, float x, float y, float z, float rx, float ry, float rz )
	{
		throw new UnsupportedOperationException();
	}
}
