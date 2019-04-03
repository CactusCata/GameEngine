package com.gmail.cactuscata.item.list;

import java.util.ArrayList;

import com.gmail.cactuscata.entity.Entity;
import com.gmail.cactuscata.item.Item;
import com.gmail.cactuscata.item.Material;
import com.gmail.cactuscata.utils.Say;

public class Potion extends Item {

	private String displayName;
	private int amount;
	private ArrayList<String> lore;
	private boolean used;
	private final int level;
	private final Material material;

	public Potion(int level) {
		this.material = Material.POTION;
		this.displayName = this.material.toString();
		this.amount = 1;
		this.lore = new ArrayList<String>();
		this.used = true;
		this.level = level;
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

	public boolean isUsed() {
		return this.used;
	}

	public void used() {
		this.used = false;
	}

	public int getLevel() {
		return this.level;
	}

	public void healh(Entity entity) {
		if (entity.getMaxHealth() < entity.getHealth() + this.level) {
			entity.setHealth(entity.getMaxHealth());
		} else {
			entity.setHealth(entity.getHealth() + this.level);
		}
		Say.sendMessage("Vous avez gagné " + this.level + " points de vie, vous avez maintenant " + entity.getHealth()
				+ " points de vie !");
	}

	@Override
	public Material getMaterial() {
		return this.material;
	}

}
