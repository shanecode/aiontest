package admincommands;

import com.aionemu.gameserver.model.Race;
import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.network.aion.serverpackets.SM_PLAYER_SPAWN;
import com.aionemu.gameserver.services.teleport.TeleportService;
import com.aionemu.gameserver.utils.PacketSendUtility;
import com.aionemu.gameserver.utils.chathandlers.ChatCommand;
import com.aionemu.gameserver.world.World;

/**
 * @author Shepper Helped by @alfa24t
 */
public class MoveToMeAll extends ChatCommand {

	public MoveToMeAll() {
		super("movetomeall");
	}

	@Override
	public void execute(Player admin, String... params) {
		if (params == null || params.length < 1) {
			PacketSendUtility.sendMessage(admin, "syntax //movetomeall < all | elyos | asmos >");
			return;
		}

		if (params[0].equals("all")) {
			for (final Player p : World.getInstance().getAllPlayers()) {
				if (!p.equals(admin)) {
					TeleportService.teleportTo(p, admin.getWorldId(), admin.getInstanceId(), admin.getX(), admin.getY(),
						admin.getZ(), admin.getHeading(), 3000, true);
					PacketSendUtility.sendPacket(p, new SM_PLAYER_SPAWN(p));

					PacketSendUtility.sendMessage(admin, "Player " + p.getName() + " teleported.");
					PacketSendUtility.sendMessage(p, "Teleportd by " + admin.getName() + ".");
				}
			}
		}

		if (params[0].equals("elyos")) {
			for (final Player p : World.getInstance().getAllPlayers()) {
				if (!p.equals(admin)) {
					if (p.getRace() == Race.ELYOS) {
						TeleportService.teleportTo(p, admin.getWorldId(), admin.getInstanceId(), admin.getX(), admin.getY(),
							admin.getZ(), admin.getHeading(), 3000, true);
						PacketSendUtility.sendPacket(p, new SM_PLAYER_SPAWN(p));

						PacketSendUtility.sendMessage(admin, "Player " + p.getName() + " teleported.");
						PacketSendUtility.sendMessage(p, "Teleportd by " + admin.getName() + ".");
					}
				}
			}
		}

		if (params[0].equals("asmos")) {
			for (final Player p : World.getInstance().getAllPlayers()) {
				if (!p.equals(admin)) {
					if (p.getRace() == Race.ASMODIANS) {
						TeleportService.teleportTo(p, admin.getWorldId(), admin.getInstanceId(), admin.getX(), admin.getY(),
							admin.getZ(), admin.getHeading(), 3000, true);
						PacketSendUtility.sendPacket(p, new SM_PLAYER_SPAWN(p));

						PacketSendUtility.sendMessage(admin, "Player " + p.getName() + " teleported.");
						PacketSendUtility.sendMessage(p, "Teleportd by " + admin.getName() + ".");
					}
				}
			}
		}
	}

	@Override
	public void onFail(Player player, String message) {
		PacketSendUtility.sendMessage(player, "syntax //movetomeall < all | elyos | asmos >");
	}
}
