/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aionemu.gameserver.global.weddings;

import com.aionemu.gameserver.ai2.AI2Engine;
import com.aionemu.gameserver.global.GlobalUnreal;
import com.aionemu.gameserver.model.gameobjects.Creature;
import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.model.gameobjects.player.RequestResponseHandler;
import com.aionemu.gameserver.network.aion.serverpackets.SM_QUESTION_WINDOW;
import com.aionemu.gameserver.utils.PacketSendUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Stan
 */
public class GlobalBenediction {
    private static final Logger log = LoggerFactory.getLogger(GlobalBenediction.class);
    Player player;
    public void load()
    {
       
    }
    public void dialogue(Player player)
    {
                String message = "You want Marry With" + player.getName();
	        RequestResponseHandler responseHandler = new RequestResponseHandler(player){

	            public void acceptRequest(Creature requester, Player responder)
	            {
	                load();
	                return;
	            }

	            public void denyRequest(Creature requester, Player responder){ return; }
	        };
	        boolean requested = player.getResponseRequester().putRequest(902247, responseHandler);
	        if(requested){PacketSendUtility.sendPacket(player, new SM_QUESTION_WINDOW(902247, 0, message));return;}
    }
    public void step1(Player player)
    {
       
    }
    public void step2(Player player)
    {
        
    }
}
