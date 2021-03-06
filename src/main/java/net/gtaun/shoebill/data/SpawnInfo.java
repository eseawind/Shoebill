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

package net.gtaun.shoebill.data;

import java.io.Serializable;

import net.gtaun.shoebill.data.type.WeaponType;

/**
 * @author MK124
 *
 */

public class SpawnInfo implements Cloneable, Serializable
{
	private static final long serialVersionUID = -1494282877268559489L;
	
	
	public LocationAngular location;
	public int skinId, teamId;
	public WeaponData weapon1, weapon2, weapon3;
	
	
	public SpawnInfo( float x, float y, float z, int interiorId, int worldId, float angle, int skin, int team, WeaponType weapon1, int ammo1, WeaponType weapon2, int ammo2, WeaponType weapon3, int ammo3 )
	{
		location = new LocationAngular(x, y, z, interiorId, worldId, angle);
		
		this.skinId = skin;
		this.teamId = team;
		
		this.weapon1 = new WeaponData(weapon1, ammo1);
		this.weapon2 = new WeaponData(weapon2, ammo2);
		this.weapon3 = new WeaponData(weapon3, ammo3);
	}
	
	public SpawnInfo( LocationAngular location, int skin, int team, WeaponData weapon1, WeaponData weapon2, WeaponData weapon3 )
	{
		this.location = location.clone();
		this.skinId = skin;
		this.teamId = team;
		this.weapon1 = weapon1.clone();
		this.weapon2 = weapon2.clone();
		this.weapon3 = weapon3.clone();
	}
	

	@Override
	public boolean equals( Object obj )
	{
		if( obj == this )								return true;
		if( !(obj instanceof SpawnInfo) )				return false;
		
		SpawnInfo info = (SpawnInfo) obj;
		if( info.location.equals(location) == false )	return false;
		if( info.skinId != skinId )							return false;
		if( info.teamId != teamId )							return false;
		if( !info.weapon1.equals(weapon1) )				return false;
		if( !info.weapon2.equals(weapon2) )				return false;
		if( !info.weapon3.equals(weapon3) )				return false;
		
		return true;
	}
	
	@Override
	public SpawnInfo clone()
	{
		return new SpawnInfo(location.clone(), skinId, teamId, weapon1.clone(), weapon2.clone(), weapon3.clone());
	}
}
