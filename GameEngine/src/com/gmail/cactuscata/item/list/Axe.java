package com.gmail.cactuscata.item.list;

import java.util.ArrayList;

import com.gmail.cactuscata.item.Material;
import com.gmail.cactuscata.item.Weapon;

public class Axe extends Weapon {
	private String displayName;
	private int amount;
	private final double damage;
	private byte durability;
	private ArrayList<String> lore;
	private final Material material;

	public Axe() {
		this.material = Material.AXE;
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
	public void setAmount(int amount) {
		this.amount = amount;

	}

	@Override
	public String getName() {
		return this.displayName;
	}

	@Override
	public int getAmount() {
		return this.amount;
	}

	@Override
	public double getDamage() {
		return this.damage;
	}

	@Override
	public void setDurability(byte durability) {
		this.durability = durability;

	}

	@Override
	public byte getDurability() {
		return this.durability;
	}

	@Override
	public void createLore(ArrayList<String> lore) {
		this.lore = lore;

	}

	@Override
	public void setLore(int lineLore, String lore) {
		this.lore.set(lineLore, lore);
	}

	@Override
	public void addLore(String lore) {
		this.lore.add(lore);

	}

	@Override
	public void removeLore(int lineLore) {
		this.lore.remove(lineLore);

	}

	@Override
	public ArrayList<String> getLore() {
		return this.lore;
	}

	@Override
	public String getLineLore(int lineLore) {
		return this.lore.get(lineLore);
	}

	@Override
	public void decremante() {
		this.durability--;
	}

	@Override
	public Material getMaterial() {
		return this.material;
	}

}
