package com.gmail.cactuscata.item;

import com.gmail.cactuscata.item.list.Axe;
import com.gmail.cactuscata.item.list.Bow;
import com.gmail.cactuscata.item.list.Pickaxe;
import com.gmail.cactuscata.item.list.Potion;
import com.gmail.cactuscata.item.list.Sword;

public enum Material {

	AIR("Air", null),
	SWORD("Epée", Sword.class),
	BOW("Arc", Bow.class),
	PICKAXE("Pioche", Pickaxe.class),
	AXE("Hache", Axe.class),

	POTION("Potion", Potion.class);

	private final String materialName;
	private final Class<? extends Item> item;

	private Material(final String materialName, final Class<? extends Item> item) {
		this.materialName = materialName;
		this.item = item;
	}

	@Override
	public String toString() {
		return materialName;
	}

	public Class<? extends Item> getItem() {
		return this.item;
	}

}
