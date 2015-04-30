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
package com.aionemu.gameserver.services;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.aionemu.gameserver.model.gameobjects.Item;
import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.model.items.storage.Storage;
import com.aionemu.gameserver.model.trade.RepurchaseList;
import com.aionemu.gameserver.services.item.ItemService;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * @author xTz
 */
public class RepurchaseService {

	private Multimap<Integer, Item> repurchaseItems = ArrayListMultimap.create();

	/**
	 * Save items for repurchase for this player
	 */
	public void addRepurchaseItems(Player player, List<Item> items) {
		repurchaseItems.putAll(player.getObjectId(), items);
	}

	/**
	 * Delete all repurchase items for this player
	 */
	public void removeRepurchaseItems(Player player) {
		repurchaseItems.removeAll(player.getObjectId());
	}

	public void removeRepurchaseItem(Player player, Item item) {
		repurchaseItems.get(player.getObjectId()).remove(item);
	}

	public Collection<Item> getRepurchaseItems(int playerObjectId) {
		Collection<Item> items = repurchaseItems.get(playerObjectId);
		return items != null ? items : Collections.<Item> emptyList();
	}

	public Item getRepurchaseItem(Player player, int itemObjectId) {
		Collection<Item> items = getRepurchaseItems(player.getObjectId());
		for (Item item : items) {
			if (item.getObjectId() == itemObjectId) {
				return item;
			}
		}
		return null;
	}

	/**
	 * @param player
	 * @param repurchaseList
	 */
	public void repurchaseFromShop(Player player, RepurchaseList repurchaseList) {
		Storage inventory = player.getInventory();
		for (Item repurchaseItem : repurchaseList.getRepurchaseItems()) {
			ItemService.addItem(player, repurchaseItem);
			removeRepurchaseItem(player, repurchaseItem);
			inventory.decreaseKinah(repurchaseItem.getRepurchasePrice());
		}
	}

	public static RepurchaseService getInstance() {
		return SingletonHolder.INSTANCE;
	}

	private static class SingletonHolder {

		protected static final RepurchaseService INSTANCE = new RepurchaseService();
	}

}
