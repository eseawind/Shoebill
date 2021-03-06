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

package net.gtaun.shoebill.util.event;

/**
 * @author MK124
 *
 */

public interface IEventManager
{
	<T extends Event> void addListener( Class<T> type, IEventListener listener, EventListenerPriority priority );
	<T extends Event> void addListener( Class<T> type, IEventListener listener, short priority );
	<T extends Event> void addListener( Class<T> type, Class<?> clz, IEventListener listener, EventListenerPriority priority );
	<T extends Event> void addListener( Class<T> type, Class<?> clz, IEventListener listener, short priority );
	<T extends Event> void addListener( Class<T> type, Object object, IEventListener listener, EventListenerPriority priority );
	<T extends Event> void addListener( Class<T> type, Object object, IEventListener listener, short priority );

	<T extends Event> void removeListener( Class<T> type, IEventListener listener );
	<T extends Event> void removeListener( Class<T> type, Class<?> clz, IEventListener listener );
	<T extends Event> void removeListener( Class<T> type, Object object, IEventListener listener );

	<T extends Event> boolean hasListener( Class<T> type, Class<?> clz );
	<T extends Event> boolean hasListener( Class<T> type, Class<?> clz, IEventListener listener );
	<T extends Event> boolean hasListener( Class<T> type, Object object );
	<T extends Event> boolean hasListener( Class<T> type, Object object, IEventListener listener );
	
	<T extends Event> void dispatchEvent( T event, Object ...objects );
}
