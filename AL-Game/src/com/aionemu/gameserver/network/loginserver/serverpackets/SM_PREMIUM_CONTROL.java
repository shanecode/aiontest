package com.aionemu.gameserver.network.loginserver.serverpackets;

import com.aionemu.gameserver.configs.network.NetworkConfig;
import com.aionemu.gameserver.model.ingameshop.IGRequest;
import com.aionemu.gameserver.network.loginserver.LoginServerConnection;
import com.aionemu.gameserver.network.loginserver.LsServerPacket;

/**
 * @author KID
 */
public class SM_PREMIUM_CONTROL extends LsServerPacket {
	private IGRequest request;
	private int cost;
	public SM_PREMIUM_CONTROL(IGRequest request, int cost) {
		super(11);
		this.request = request;
		this.cost = cost;
	}

	@Override
	protected void writeImpl(LoginServerConnection con) {
		writeD(request.accountId);
		writeD(request.requestId);
		writeD(cost);
		writeC(NetworkConfig.GAMESERVER_ID);
	}
}
