/**
 * Copyright (C) 2012 MK124
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

package net.gtaun.shoebill.plugin;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import net.gtaun.shoebill.util.config.YamlConfiguration;

/**
 * @author MK124
 *
 */

public class PluginDescription
{
	private Class<? extends Plugin> clazz;
	private String name;
	private String version;
	private String description;
	private List<String> authors;


	public Class<? extends Plugin> getClazz()		{ return clazz; }
	public String getName()							{ return name; }
	public String getVersion()						{ return version; }
	public List<String> getAuthors()				{ return authors; }
	public String getDescription()					{ return description; }
	

	public PluginDescription( InputStream in, ClassLoader classLoader ) throws ClassNotFoundException
	{
		YamlConfiguration config = new YamlConfiguration();
		config.read( in );
		
		String className = config.getString( "class" );
		clazz = classLoader.loadClass( className ).asSubclass( Plugin.class );
		
		name = config.getString( "name" );
		version = config.getString( "version" );
		
		String author = config.getString( "authors" );
		authors = new ArrayList<String>();
		String[] auth = author.split("[,;]");
		if( auth.length > 0 )
			for( String string : auth ) authors.add( string.trim() );
		else
			authors.add( author.trim() );
			
		description = config.getString( "description" );
	}
}
