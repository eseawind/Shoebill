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

/**
 * @author MK124
 *
 */

@SuppressWarnings("unused")
public class KeyState implements Cloneable, Serializable
{
	private static final long serialVersionUID = 2902208210862136365L;
	
	
	private final int KEY_ACTION				= 1;
	private final int KEY_CROUCH				= 2;
	private final int KEY_FIRE					= 4;
	private final int KEY_SPRINT				= 8;
	private final int KEY_SECONDARY_ATTACK		= 16;
	private final int KEY_JUMP					= 32;
    private final int KEY_LOOK_RIGHT			= 64;
    private final int KEY_HANDBRAKE				= 128;
    private final int KEY_LOOK_LEFT				= 256;
	private final int KEY_SUBMISSION			= 512;
    private final int KEY_LOOK_BEHIND			= 512;
    private final int KEY_WALK					= 1024;
    private final int KEY_ANALOG_UP				= 2048;
    private final int KEY_ANALOG_DOWN			= 4096;
    private final int KEY_ANALOG_LEFT			= 8192;
    private final int KEY_ANALOG_RIGHT			= 16384;
    
    private final int KEY_UP					= -128;
    private final int KEY_DOWN					= 128;
    private final int KEY_LEFT					= -128;
    private final int KEY_RIGHT					= 128;

    
    private int keys, updown, leftright;
    
    
    public KeyState()
    {
    	
    }
    

    public boolean isActionPressed()			{ return (keys&KEY_ACTION) != 0; }
    public boolean isCrouchPressed()			{ return (keys&KEY_CROUCH) != 0; }
    public boolean isFirePressed()				{ return (keys&KEY_FIRE) != 0; }
    public boolean isSprintPressed()			{ return (keys&KEY_SPRINT) != 0; }
    public boolean isSecondAttackPressed()		{ return (keys&KEY_SECONDARY_ATTACK) != 0; }
    public boolean isJumpPressed()				{ return (keys&KEY_JUMP) != 0; }
    public boolean isLookRightPressed()			{ return (keys&KEY_LOOK_RIGHT) != 0; }
    public boolean isHandBreakPressed()			{ return (keys&KEY_HANDBRAKE) != 0; }
    public boolean isLookLeftPressed()			{ return (keys&KEY_LOOK_LEFT) != 0; }
    public boolean isSubMissionPressed()		{ return (keys&KEY_SUBMISSION) != 0; }
    public boolean isLookBehindPressed()		{ return (keys&KEY_LOOK_BEHIND) != 0; }
    public boolean isWalkPressed()				{ return (keys&KEY_WALK) != 0; }
    public boolean isAnalogUpPressed()			{ return (keys&KEY_ANALOG_UP) != 0; }
    public boolean isAnalogDownPressed()		{ return (keys&KEY_ANALOG_DOWN) != 0; }
    public boolean isAnalogLeftPressed()		{ return (keys&KEY_ANALOG_LEFT) != 0; }
    public boolean isAnalogRightPressed()		{ return (keys&KEY_ANALOG_RIGHT) != 0; }
    
	
	@Override
	public boolean equals( Object obj )
	{
		if( obj == this )					return true;
		if( !(obj instanceof KeyState) )	return false;
		
		KeyState state = (KeyState) obj;
		if( state.keys != keys )			return false;
		if( state.updown != updown )		return false;
		if( state.leftright != leftright )	return false;
		
		return true;
	}
	
	@Override
	public KeyState clone()
	{
		KeyState state = new KeyState();
		
		state.keys = keys;
		state.updown = updown;
		state.leftright = leftright;
		
		return state;
	}
}
