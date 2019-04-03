package com.gmail.cactuscata.entity;

import java.util.Random;

import com.gmail.cactuscata.entity.list.Goblin;
import com.gmail.cactuscata.entity.list.Player;
import com.gmail.cactuscata.entity.list.Skeleton;
import com.gmail.cactuscata.entity.list.Troll;
import com.gmail.cactuscata.entity.list.Zombie;

public enum EntityType {

	PLAYER("Joueur", Player.class),
	ZOMBIE("Zombie", Zombie.class),
	SKELETON("Skeleton", Skeleton.class),
	TROLL("Troll", Troll.class),
	GOBLIN("Goblin", Goblin.class);

	private final String name;
	private final Class<? extends Entity> classe;

	private EntityType(final String name, final Class<? extends Entity> classe) {
		this.name = name;
		this.classe = classe;
	}

	public String getName() {
		return this.name;
	}

	public Class<? extends Entity> getEntity() {
		return this.classe;
	}

	public static Entity getRandomEntity() {
		int random = new Random().nextInt(values().length - 1);
		switch (random) {
			case 0:
				return new Zombie();
			case 1:
				return new Skeleton();
			case 2:
				return new Troll();
			case 3:
				return new Goblin();
		}

		throw new IllegalAccessError("Depassement du tableau !");
	}

}
