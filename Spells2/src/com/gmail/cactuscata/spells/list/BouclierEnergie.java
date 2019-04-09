package com.gmail.cactuscata.spells.list;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BouclierEnergie {

	public BouclierEnergie(Player player) {

		Location loc = player.getLocation();
		World w = loc.getWorld();
		w.playSound(loc, Sound.BLOCK_FIRE_AMBIENT, 0.3F, 0.1F);
		w.spawnParticle(Particle.REDSTONE, 0, 0, 0, 15);
		player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 400, 5));

	}

}
