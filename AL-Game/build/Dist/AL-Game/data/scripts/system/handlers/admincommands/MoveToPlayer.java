package admincommands;

import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.services.teleport.TeleportService;
import com.aionemu.gameserver.utils.PacketSendUtility;
import com.aionemu.gameserver.utils.Util;
import com.aionemu.gameserver.utils.chathandlers.ChatCommand;
import com.aionemu.gameserver.world.World;

/**
 * Admin movetoplayer command.
 * 
 * @author Tanelorn
 */
public class MoveToPlayer extends ChatCommand {

	public MoveToPlayer() {
		super("movetoplayer");
	}

	@Override
	public void execute(Player admin, String... params) {
		if (params == null || params.length < 1) {
			PacketSendUtility.sendMessage(admin, "syntax //movetoplayer characterName");
			return;
		}

		Player player = World.getInstance().findPlayer(Util.convertName(params[0]));
		if (player == null) {
			PacketSendUtility.sendMessage(admin, "The specified player is not online.");
			return;
		}

		if (player == admin) {
			PacketSendUtility.sendMessage(admin, "Cannot use this command on yourself.");
			return;
		}

		TeleportService.teleportTo(admin, player.getWorldId(), player.getInstanceId(), player.getX(), player.getY(),
			player.getZ(), player.getHeading(), 3000, true);
		PacketSendUtility.sendMessage(admin, "Teleported to player " + player.getName() + ".");
	}

	@Override
	public void onFail(Player player, String message) {
		PacketSendUtility.sendMessage(player, "syntax //movetoplayer characterName");
	}

}
