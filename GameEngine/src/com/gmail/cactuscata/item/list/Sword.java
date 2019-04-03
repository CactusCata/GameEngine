package com.gmail.cactuscata.item.list;

import java.util.ArrayList;

import com.gmail.cactuscata.item.Material;
import com.gmail.cactuscata.item.Weapon;

public class Sword extends Weapon {
	
	private String displayName;
	private int amount;
	private final double damage;
	private byte durability;
	private ArrayList<String> lore;
	private final Material material;

	public Sword() {
		this.material = Material.SWORD;
		this.displayName = this.material.toString();
		this.amount = 1;
		this.damage = 5;
		this.durability = Byte.MAX_VALUE;
		this.lore = new ArrayList<String>();
	}

	@Override
	public final void setName(String name) {
		this.displayName = name;

	}

	@Override
	public final void setAmount(int amount) {
		this.amount = amount;

	}

	@Override
	public final String getName() {
		return this.displayName;
	}

	@Override
	public final int getAmount() {
		return this.amount;
	}

	@Override
	public final double getDamage() {
		return this.damage;
	}

	@Override
	public final void setDurability(byte durability) {
		this.durability = durability;

	}

	@Override
	public final byte getDurability() {
		return this.durability;
	}

	@Override
	public final void createLore(ArrayList<String> lore) {
		this.lore = lore;

	}

	@Override
	public final void setLore(int lineLore, String lore) {
		this.lore.set(lineLore, lore);
	}

	@Override
	public final void addLore(String lore) {
		this.lore.add(lore);

	}

	@Override
	public final void removeLore(int lineLore) {
		this.lore.remove(lineLore);

	}

	@Override
	public final ArrayList<String> getLore() {
		return this.lore;
	}

	@Override
	public final String getLineLore(int lineLore) {
		return this.lore.get(lineLore);
	}

	@Override
	public final void decremante() {
		this.durability--;
	}

	@Override
	public Material getMaterial() {
		return this.material;
	}
}
