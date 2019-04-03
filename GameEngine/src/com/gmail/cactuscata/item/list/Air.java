package com.gmail.cactuscata.item.list;

import java.util.ArrayList;

import com.gmail.cactuscata.item.Item;
import com.gmail.cactuscata.item.Material;

public class Air extends Item {

	private String displayName;
	private int amount;
	private ArrayList<String> lore;
	private final Material material;

	public Air() {
		this.material = Material.AXE;
		this.displayName = this.material.toString();
		this.amount = 1;
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
	public Material getMaterial() {
		return this.material;
	}
}
