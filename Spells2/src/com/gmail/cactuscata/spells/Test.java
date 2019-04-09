package com.gmail.cactuscata.spells;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.cactuscata.spells.list.SpellsList;

public class Test {

	public void activeSpell(Main main, Player player, SpellsList spell) {

		if (spell.getXp() > player.getLevel()) {
			player.sendMessage("Vous n'avez pas l'xp nécéssaire !");
			return;
		}

		if (MapSpell.getMap().contains(player.getName() + spell.getName())) {
			player.sendMessage("Votre sort est en cooldown !");
			return;
		} else {
			System.out.println("n'existe pas dans la arraylist");

		}

		MapSpell.getMap().add(player.getName() + spell.getName());

		player.sendMessage("Vous avez reçu l'effet " + spell.getName());
		player.setLevel(player.getLevel() - spell.getXp());

		spell.action(spell, player);

		// temps du sort

		new BukkitRunnable() {
			public void run() {

				MapSpell.getMap().remove(player.getName() + spell.getName());

			}
		}.runTaskLater(main, spell.getTime());

	}

}
