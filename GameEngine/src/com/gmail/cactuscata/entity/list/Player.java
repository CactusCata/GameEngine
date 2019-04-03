package com.gmail.cactuscata.entity.list;

import java.util.Random;

import com.gmail.cactuscata.Inventory;
import com.gmail.cactuscata.entity.Entity;
import com.gmail.cactuscata.entity.EntityType;
import com.gmail.cactuscata.item.Item;
import com.gmail.cactuscata.utils.Say;

public class Player extends Entity {

	private int health;
	private int maxHealth;
	private int attack;
	private int defense;
	private String name;
	private EntityType entityType;
	private int experience;
	private int level;
	private Inventory inventory;

	{
		this.entityType = EntityType.PLAYER;
	}

	public Player() {
		this.name = this.entityType.getName();
		Random random = new Random();
		this.health = 40 + random.nextInt(5);
		this.maxHealth = this.health;
		this.defense = 3 + random.nextInt(3);
		this.attack = 8 + random.nextInt(3);
		this.inventory = new Inventory(this);
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

	public int getExperience() {
		return this.experience;
	}

	public int getLevel() {
		return this.level;
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
		if(name == null || name.equals(""))
			return;
		this.name = name;

	}

	public void setExperience(int experience) {
		this.experience = experience;
		levelUp();
	}

	private void levelUp() {
		while (this.experience > this.level * 2 + 100) {
			this.experience -= Math.pow(this.level, 3) + 100;
			this.level++;
			Random random = new Random();
			int damage = random.nextInt(2);
			int health = random.nextInt(3);
			int defense = random.nextInt(1);
			Say.sendMessage("Félicitation vous etes monté au level " + this.level + "Vous avez gagné " + damage
					+ " points en dégats !\nVous avez gagné " + health + " points de vie\nVous avez gagné " + defense
					+ " points en défense !");
		}

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
	public int getExperienceDroped() {
		return 0;
	}

	@Override
	public Inventory getInventory() {
		return this.inventory;
	}

	public Item getItemInHand() {
		return this.inventory.getItemInHand();
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
	public void setItemInHand(Item item) {
		this.inventory.setItemInHand(item);
	}

}
