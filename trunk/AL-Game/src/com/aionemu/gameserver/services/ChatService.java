/*
 * This file is part of aion-unique <aion-unique.org>.
 *
 *  aion-unique is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  aion-unique is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with aion-unique.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aionemu.gameserver.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.network.aion.serverpackets.SM_CHAT_INIT;
import com.aionemu.gameserver.network.chatserver.ChatServer;
import com.aionemu.gameserver.utils.PacketSendUtility;
import com.aionemu.gameserver.world.World;

/** 
 * @author ATracer
 */
public class ChatService {
	private static final Logger log = LoggerFactory.getLogger(ChatService.class);
	
	private static byte[] ip = { 127, 0, 0, 1 };
	private static int port = 10241;

	/**
	 * Disonnect from chat server
	 * 
	 * @param player
	 */
	public static void onPlayerLogout(Player player) {
		ChatServer.getInstance().sendPlayerLogout(player);
	}

	/**
	 * @param playerId
	 * @param token
	 * @param account 
	 * @param nick 
	 */
	public static void playerAuthed(int playerId, byte[] token) {
		Player player = World.getInstance().findPlayer(playerId);
		if (player != null) {
			PacketSendUtility.sendPacket(player, new SM_CHAT_INIT(token));
		}
	}

	/**
	 * @return the ip
	 */
	public static byte[] getIp() {
		return ip;
	}

	/**
	 * @return the port
	 */
	public static int getPort() {
		return port;
	}

	/**
	 * @param ip
	 *          the ip to set
	 */
	public static void setIp(byte[] _ip) {
		ip = _ip;
	}

	/**
	 * @param port
	 *          the port to set
	 */
	public static void setPort(int _port) {
		port = _port;
	}
}
