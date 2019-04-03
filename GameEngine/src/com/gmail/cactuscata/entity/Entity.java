package com.gmail.cactuscata.entity;

import com.gmail.cactuscata.Inventory;
import com.gmail.cactuscata.item.Item;

public abstract class Entity {

	public abstract int getHealth();
	
	public abstract int getMaxHealth();

	public abstract int getAttack();

	public abstract int getDefense();

	public abstract String getName();
	
	public abstract Item getItemInHand();
	
	public abstract void setItemInHand(Item item);

	public abstract int getExperienceDroped();

	public abstract void setHealth(int health);
	
	public abstract void setMaxHealth(int health);

	public abstract void setAttack(int attack);

	public abstract void setDefense(int defense);

	public abstract void setName(String name);

	public abstract boolean isDead();

	public abstract EntityType getEntityType();

	public abstract Inventory getInventory();

}
