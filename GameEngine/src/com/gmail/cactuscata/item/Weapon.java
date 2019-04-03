package com.gmail.cactuscata.item;

public abstract class Weapon extends Item {

	public abstract double getDamage();
	
	public abstract void setDurability(byte durability);
	
	public abstract void decremante();
	
	public abstract byte getDurability();
	
}
