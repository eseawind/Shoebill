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

import net.gtaun.shoebill.data.Location;
import net.gtaun.shoebill.data.SpawnInfo;
import net.gtaun.shoebill.data.type.PlayerMarkerMode;
import net.gtaun.shoebill.samp.SampNativeFunction;

/**
 * @author MK124
 *
 */

public class World implements IWorld
{
	private float nameTagDrawDistance = 70;
	private float chatRadius = -1;
	private float playerMarkerRadius = -1;
	
	
	public World()
	{
		
	}
	
	
	@Override
	public void setTeamCount( int count )
	{
		SampNativeFunction.setTeamCount( count );
	}

	@Override
	public int addPlayerClass( int modelId, float x, float y, float z, float angle, int weapon1, int ammo1, int weapon2, int ammo2, int weapon3, int ammo3 )
	{
		return SampNativeFunction.addPlayerClass( modelId, x, y, z, angle, weapon1, ammo1, weapon2, ammo2, weapon3, ammo3 );
	}

	@Override
	public int addPlayerClass( int modelId, SpawnInfo spawnInfo )
	{
		return SampNativeFunction.addPlayerClass( modelId, 
			spawnInfo.location.x, spawnInfo.location.y, spawnInfo.location.z, spawnInfo.location.angle,
			spawnInfo.weapon1.type.getId(), spawnInfo.weapon1.ammo, spawnInfo.weapon2.type.getId(), spawnInfo.weapon2.ammo,
			spawnInfo.weapon3.type.getId(), spawnInfo.weapon3.ammo );
	}
	
	@Override
	public int addPlayerClassEx( int teamId, int modelId, SpawnInfo spawnInfo )
	{
		return SampNativeFunction.addPlayerClassEx( teamId, modelId, 
			spawnInfo.location.x, spawnInfo.location.y, spawnInfo.location.z, spawnInfo.location.angle,
			spawnInfo.weapon1.type.getId(), spawnInfo.weapon1.ammo, spawnInfo.weapon2.type.getId(), spawnInfo.weapon2.ammo,
			spawnInfo.weapon3.type.getId(), spawnInfo.weapon3.ammo );
	}

	@Override
	public float getChatRadius()
	{
		return chatRadius;
	}
	
	@Override
	public void setChatRadius( float radius )
	{
		SampNativeFunction.limitGlobalChatRadius( radius );
	}

	@Override
	public float getPlayerMarkerRadius()
	{
		return playerMarkerRadius;
	}
	
	@Override
	public void setPlayerMarkerRadius( float radius )
	{
		SampNativeFunction.limitPlayerMarkerRadius( radius );
	}
	
	@Override public int getWeatherId()
	{
		return SampNativeFunction.getServerVarAsInt("weather");
	}

	@Override
	public void setWeatherId( int weatherid )
	{
		SampNativeFunction.setWeather( weatherid );
	}
	
	@Override public float getGravity()
	{
		return Float.parseFloat(SampNativeFunction.getServerVarAsString("gravity"));
	}
	
	@Override
	public void setGravity( float gravity )
	{
		SampNativeFunction.setGravity( gravity );
	}
	
	@Override
	public void setWorldTime( int hour )
	{
		SampNativeFunction.setWorldTime( hour );
	}

	@Override
	public float getNameTagDrawDistance()
	{
		return nameTagDrawDistance;
	}

	@Override
	public void setNameTagDrawDistance( float distance )
	{
		nameTagDrawDistance = distance;
		SampNativeFunction.setNameTagDrawDistance( distance );
	}
	
	@Override
	public void showNameTags( boolean enabled )
	{
		SampNativeFunction.showNameTags( enabled );
	}
	
	@Override
	public void showPlayerMarkers( PlayerMarkerMode mode )
	{
		SampNativeFunction.showPlayerMarkers( mode.getData() );
	}
	
	@Override
	public void enableTirePopping( boolean enabled )
	{
		SampNativeFunction.enableTirePopping( enabled );
	}
	
	@Override
	public void allowInteriorWeapons( boolean allow )
	{
		SampNativeFunction.allowInteriorWeapons( allow );
	}
	
	@Override
	public void createExplosion( Location location, int type, float radius )
	{
		SampNativeFunction.createExplosion( location.x, location.y, location.z, type, radius );
	}
	
	@Override
	public void enableZoneNames( boolean enabled )
	{
		SampNativeFunction.enableZoneNames( enabled );
	}
	
	@Override
	public void usePlayerPedAnims()
	{
		SampNativeFunction.usePlayerPedAnims();
	}
	
	@Override
	public void disableInteriorEnterExits()
	{
		SampNativeFunction.disableInteriorEnterExits();
	}
	
	@Override
	public void disableNameTagLOS()
	{
		SampNativeFunction.disableNameTagLOS();
	}
}
