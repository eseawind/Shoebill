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

package net.gtaun.samp.event;

import net.gtaun.event.Event;
import net.gtaun.samp.DialogBase;
import net.gtaun.samp.PlayerBase;

/**
 * @author MK124
 *
 */

public class DialogResponseEvent extends Event
{
	public DialogBase dialog;
	public PlayerBase player;
	public int response, listitem;
	public String inputtext;
	
	
	public DialogResponseEvent( DialogBase dialog, PlayerBase player, int response, int listitem, String inputtext )
	{
		this.dialog = dialog;
		this.player = player;
		this.response = response;
		this.listitem = listitem;
		this.inputtext = inputtext;
	}
}