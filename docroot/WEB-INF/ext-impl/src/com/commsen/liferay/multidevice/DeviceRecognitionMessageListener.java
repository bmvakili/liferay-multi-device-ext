/**
 * Copyright (c) COMMSEN International. All rights reserved.
 *	
 * This library is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library.  If not, see http://www.gnu.org/licenses/lgpl.html.
 */
package com.commsen.liferay.multidevice;

import com.commsen.liferay.multidevice.command.DeviceFromRequestCommand;
import com.commsen.liferay.multidevice.command.KnownDevicesCommand;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.MessageListener;

/**
 * 
 * @author Milen Dyankov
 *
 */
public class DeviceRecognitionMessageListener implements MessageListener {

	private DeviceRecognitionProvider deviceRecognitionProvider;
	
	@Override
	public void receive(Message message) {
		Object payload = message.getPayload();
		
		if (payload instanceof KnownDevicesCommand) {
			Message response = MessageBusUtil.createResponseMessage(message);
			Object knownDevices = deviceRecognitionProvider.getKnownDevices();
			response.setPayload(knownDevices);
			MessageBusUtil.sendMessage(message.getResponseDestinationName(), response);
			return;
		}

		if (payload instanceof DeviceFromRequestCommand) {
			DeviceFromRequestCommand deviceFromRequestCommand = (DeviceFromRequestCommand)payload;
			Message response = MessageBusUtil.createResponseMessage(message);
			Object device = deviceRecognitionProvider.getDeviceFromRequest(deviceFromRequestCommand.getRequest());
			response.setPayload(device);
			MessageBusUtil.sendMessage(message.getResponseDestinationName(), response);
			return;
		}
	}

	public void setDeviceRecognitionProvider(DeviceRecognitionProvider deviceRecognitionProvider) {
    	this.deviceRecognitionProvider = deviceRecognitionProvider;
    }

}
