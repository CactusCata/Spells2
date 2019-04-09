package com.gmail.cactuscata.spells.list;

import org.bukkit.entity.Player;

public enum SpellsList {

	BOUCLIER_ENERGIE("Bouclier d'energie", 10, 30L), 
	SOINS_DE_MASSE("Soins de masse", 20, 80L);

	private final String displayName;
	private final int xp;
	private final long seconde;

	private SpellsList(final String displayName, final int xp, final long seconde) {
		this.displayName = displayName;
		this.seconde = seconde;
		this.xp = xp;
	}

	public String getName() {
		return displayName;
	}

	public int getXp() {
		return xp;
	}

	public long getTime() {
		return seconde;
	}
	
	public void action(SpellsList spell, Player player){
		
		switch (spell) {
		case BOUCLIER_ENERGIE:
			new BouclierEnergie(player);
			break;
		case SOINS_DE_MASSE:
			new SoinsDeMasse(player);

		default:
			break;
		}
		
	}
	
}
