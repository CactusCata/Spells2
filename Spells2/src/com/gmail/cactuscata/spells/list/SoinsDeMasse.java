package com.gmail.cactuscata.spells.list;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SoinsDeMasse {

	public SoinsDeMasse(Player player) {
		
		Location loc = player.getLocation();
		World w = loc.getWorld();
		w.playSound(loc, Sound.ENTITY_SPLASH_POTION_BREAK, 0.3F, 0.1F);
		w.spawnParticle(Particle.HEART, player.getLocation(), 16, 10, 10, 10);// Particle.HEART.display(0, 0, 0, 0, 10, player.getLocation(), 16);
		player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 400, 5));
		
	}

}
