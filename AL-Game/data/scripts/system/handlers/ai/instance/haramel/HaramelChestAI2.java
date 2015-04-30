/*
 * This file is part of aion-lightning <aion-lightning.com>.
 *
 *  aion-lightning is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  aion-lightning is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with aion-lightning.  If not, see <http://www.gnu.org/licenses/>.
 */
package ai.instance.haramel;

import ai.ChestAI2;
import com.aionemu.gameserver.ai2.AIName;

/**
 * @author xTz
 */
@AIName("haramelchest")
public class HaramelChestAI2 extends ChestAI2 {

	@Override
	protected void handleDespawned() {
		spawn(700852, 224.598f, 331.143f, 141.892f, (byte) 90);
		super.handleDespawned();
	}
}
