/**
 *	This file is part of multi-device portal extension for Liferay.
 *	
 * Multi-device portal extension for Liferay is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 * 
 * Multi-device portal extension for Liferay is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with multi-device portal extension for Liferay.  If not, see <http://www.gnu.org/licenses/lgpl.html>.
 */

package com.commsen.liferay.multidevice.command;


/**
 * @author Milen Dyankov
 *
 */
public class ThemeRulesListCommand {
	
	private long companyId;
	
	private long groupId;

	private long layoutId;

	
	public ThemeRulesListCommand(long companyId, long groupId, long layoutId) {
	    this.companyId = companyId;
	    this.groupId = groupId;
	    this.layoutId = layoutId;
    }

	public long getCompanyId() {
    	return companyId;
    }

	public long getGroupId() {
    	return groupId;
    }

	public long getLayoutId() {
    	return layoutId;
    }
}
