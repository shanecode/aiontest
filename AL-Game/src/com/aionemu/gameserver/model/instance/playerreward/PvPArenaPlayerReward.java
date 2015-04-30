/*
 * This file is part of aion-lightning <aion-lightning.org>
 *
 * aion-lightning is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * aion-lightning is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with aion-lightning. If not, see <http://www.gnu.org/licenses/>.
 */
package com.aionemu.gameserver.model.instance.playerreward;

import com.aionemu.gameserver.model.gameobjects.player.Player;

/**
 *
 * @author xTz
 */
public class PvPArenaPlayerReward extends InstancePlayerReward {

	private int position;
	private int timeBonus;
	private int abyssPoints;
	private int crucibleInsignia;
	private int courageInsignia;
	private long logoutTime;
	private boolean isRewarded = false;

	public PvPArenaPlayerReward(Player player, int timeBonus) {
		super(player);
		super.addPoints(13000);
		this.timeBonus = timeBonus;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getTimeBonus() {
		return timeBonus > 0 ? timeBonus : 0;
	}

	public void updateBonusTime(long startTime) {
		int offlineTime = (int) (System.currentTimeMillis() - (logoutTime != 0
				? logoutTime : (System.currentTimeMillis() - startTime)));
		timeBonus -= offlineTime * timeBonus / 540;
		logoutTime = startTime != 0 ? System.currentTimeMillis() : 0;
	}

	public boolean isRewarded() {
		return isRewarded;
	}

	public void setRewarded() {
		isRewarded = true;
	}

	public int getAbyssPoints() {
		return abyssPoints;
	}

	public void setAbyssPoints(int abyssPoints) {
		this.abyssPoints = abyssPoints;
	}

	public int getCrucibleInsignia() {
		return crucibleInsignia;
	}

	public void setCrucibleInsignia(int crucibleInsignia) {
		this.crucibleInsignia = crucibleInsignia;
	}

	public int getCourageInsignia() {
		return courageInsignia;
	}

	public void setCourageInsignia(int courageInsignia) {
		this.courageInsignia = courageInsignia;
	}
}