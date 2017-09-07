package fr.inria.stamp.tavern;

import java.util.List;

/**
 * Created by Benjamin DANGLOT
 * benjamin.danglot@inria.fr
 * on 05/09/17
 */
public class Seller {

	protected int gold;

	protected List<Item> items;

	public Seller(int gold, List<Item> itemsToSell) {
		this.gold = gold;
		this.items = itemsToSell;
	}

	public Item sellItem(String name, Player player) {
		Item itemToSell = null;
		for (int i = 0; i < this.items.size(); i++) {
			final Item item = this.items.get(i);
			if (item.name.equals(name)) {
				itemToSell = item;
			}
		}
		if (itemToSell != null) {
			final Integer gold = player.getGold();
			final int comparison = gold.compareTo(itemToSell.price);
			if (comparison >= 0) {
				this.gold = this.gold + itemToSell.price;
				player.giveGold(itemToSell.price);
				return itemToSell;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "Seller{" +
				"gold=" + gold +
				", items=" + items +
				'}';
	}
}
