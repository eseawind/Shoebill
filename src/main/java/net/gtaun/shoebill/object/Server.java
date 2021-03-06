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

import net.gtaun.shoebill.samp.SampNativeFunction;

/**
 * @author MK124
 *
 */

public class Server implements IServer
{
	public Server()
	{
		
	}
	
	
	@Override
	public int getServerCodepage()
	{
		return SampNativeFunction.getServerCodepage();
	}

	@Override
	public void setServerCodepage( int codepage )
	{
		SampNativeFunction.setServerCodepage( codepage );
	}

	@Override
	public void sendRconCommand( String command )
	{
		if( command == null ) throw new NullPointerException();
		SampNativeFunction.sendRconCommand( command );
	}
	
	@Override
	public void connectNPC( String name, String script )
	{
		if( name == null || script == null ) throw new NullPointerException();
		SampNativeFunction.connectNPC( name, script );
	}
	
	@Override
	public String getServerVarAsString( String varname )
	{
		if( varname == null ) throw new NullPointerException();
		return SampNativeFunction.getServerVarAsString( varname );
	}
	
	@Override
	public int getServerVarAsInt( String varname )
	{
		if( varname == null ) throw new NullPointerException();
		return SampNativeFunction.getServerVarAsInt( varname );
	}
	
	@Override
	public boolean getServerVarAsBool( String varname )
	{
		if( varname == null ) throw new NullPointerException();
		return SampNativeFunction.getServerVarAsBool( varname );
	}
}
