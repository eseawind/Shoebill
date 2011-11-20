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

package net.gtaun.shoebill.event.dialog;

import net.gtaun.shoebill.object.Dialog;
import net.gtaun.shoebill.object.Player;

/**
 * @author MK124
 *
 */

public class DialogResponseEvent extends DialogEvent
{
	int response, listitem;
	String inputText;
	
	public int getResponse()				{ return response; }
	public int getListitem()				{ return listitem; }
	public String getInputText()			{ return inputText;}
	
	
	public DialogResponseEvent( Dialog dialog, Player player, int response, int listitem, String inputtext )
	{
		super( dialog, player );
		this.response = response;
		this.listitem = listitem;
		this.inputText = inputtext;
	}
}