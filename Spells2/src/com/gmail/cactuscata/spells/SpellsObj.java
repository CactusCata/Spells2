package com.gmail.cactuscata.spells;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.cactuscata.spells.list.SpellsList;

public class SpellsObj implements Listener {

	private Main main;

	public SpellsObj(Main main) {
		this.main = main;
	}

	@EventHandler
	public void getItem(PlayerInteractEvent event) {

		if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {

			ItemStack itemInHand = event.getPlayer().getInventory().getItemInMainHand();

			if (itemInHand != null && event.getHand() != EquipmentSlot.OFF_HAND) {

				ItemMeta itemInHandM = itemInHand.getItemMeta();

				if (itemInHandM != null && itemInHand.getType() == Material.BOOK) {

					SpellsList spell = check(itemInHandM);

					if (spell == null)
						return;

					Test test = new Test();
					test.activeSpell(main, event.getPlayer(), spell);
					return;

				}
			}

		} else if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {

			ItemStack itemInOffHand = event.getPlayer().getInventory().getItemInOffHand();

			if (itemInOffHand != null) {

				ItemMeta itemInOffHandM = itemInOffHand.getItemMeta();

				if (itemInOffHandM != null && itemInOffHand.getType() == Material.BOOK) {

					SpellsList spell = check(itemInOffHandM);

					if (spell == null)
						return;

					Test test = new Test();
					test.activeSpell(main, event.getPlayer(), spell);
					return;

				}

			}
		}

	}

	private SpellsList check(ItemMeta itemM) {
		if (itemM.getDisplayName() == null)
			return null;

		for (SpellsList spells : SpellsList.values())
			if (spells.getName().equals(itemM.getDisplayName()))
				return spells;

		return null;
	}

}
