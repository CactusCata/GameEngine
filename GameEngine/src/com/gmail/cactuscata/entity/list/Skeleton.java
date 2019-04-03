package com.gmail.cactuscata.entity.list;

import java.util.Random;

import com.gmail.cactuscata.Inventory;
import com.gmail.cactuscata.entity.EntityType;
import com.gmail.cactuscata.entity.Monster;
import com.gmail.cactuscata.item.Item;
import com.gmail.cactuscata.item.list.Air;
import com.gmail.cactuscata.item.list.Axe;
import com.gmail.cactuscata.item.list.Sword;

public class Skeleton extends Monster {

	private int health;
	private int maxHealth;
	private int attack;
	private int defense;
	private String name;
	private EntityType entityType;
	private int experienceDroped;
	private Inventory inventory;

	public Skeleton() {
		this.entityType = EntityType.SKELETON;
		this.name = this.entityType.getName();
		Random random = new Random();
		this.health = 15 + random.nextInt(5);
		this.maxHealth = this.health;
		this.defense = random.nextInt(3);
		this.attack = 4 + random.nextInt(3);
		this.experienceDroped = 8;
		this.inventory = new Inventory(this);
		this.inventory.addItem(new Air());
		setRandomItems();
	}

	@Override
	public int getHealth() {
		return this.health;
	}

	@Override
	public int getAttack() {
		return this.attack;
	}

	@Override
	public int getDefense() {
		return this.defense;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public int getExperienceDroped() {
		return this.experienceDroped;
	}

	@Override
	public void setHealth(int health) {
		this.health = health;

	}

	@Override
	public void setAttack(int attack) {
		this.attack = attack;

	}

	@Override
	public void setDefense(int defense) {
		this.defense = defense;

	}

	@Override
	public void setName(String name) {
		this.name = name;

	}

	@Override
	public boolean isDead() {
		return this.health < 1;
	}

	@Override
	public EntityType getEntityType() {
		return this.entityType;
	}

	@Override
	public Inventory getInventory() {
		return this.inventory;
	}

	@Override
	public void setRandomItems() {
		Random random = new Random();
		int percent = random.nextInt(101);
		if (percent < 10)
			return;
		if (percent < 30) {
			this.inventory.addItem(new Sword());
			return;
		}
		this.inventory.addItem(new Axe());

	}

	@Override
	public int getMaxHealth() {
		return this.maxHealth;
	}

	@Override
	public void setMaxHealth(int health) {
		this.maxHealth = health;

	}

	@Override
	public Item getItemInHand() {
		return this.inventory.getItemInHand();
	}

	@Override
	public void setItemInHand(Item item) {
		this.inventory.setItemInHand(item);

	}

}
