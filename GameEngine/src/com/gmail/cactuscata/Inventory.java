package com.gmail.cactuscata;

import java.util.ArrayList;
import java.util.HashMap;

import com.gmail.cactuscata.entity.Entity;
import com.gmail.cactuscata.item.Item;
import com.gmail.cactuscata.item.list.Air;

public class Inventory {

	private String inventoryName;
	private int size;
	private ArrayList<Item> items;
	private Item itemInHand;
	private static HashMap<Entity, Inventory> inventoryEntity;

	static {
		inventoryEntity = new HashMap<Entity, Inventory>();
	}

	{
		this.items = new ArrayList<Item>();
		this.itemInHand = new Air();
	}

	public Inventory(Entity entity, String inventoryName, int size) {
		this.inventoryName = inventoryName;
		this.size = size;
		inventoryEntity.put(entity, this);
	}

	public Inventory(Entity entity) {
		this.inventoryName = "Inventaire de " + entity.getName();
		this.size = 9999;
		inventoryEntity.put(entity, this);
	}

	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}

	public String getInventoryName() {
		return this.inventoryName;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getSize() {
		return this.size;
	}

	public void addItem(Item item) {
		this.items.add(item);
	}

	public void setItem(Item item, int slot) {
		this.items.set(slot, item);
	}

	public Item getItem(int slot) {
		return this.items.get(slot);
	}

	public ArrayList<Item> getItems() {
		return this.items;
	}

	public void removeItem(Item item) {
		this.items.remove(item);
	}

	public void removeItem(int slot) {
		this.items.remove(slot);
	}

	public static Inventory getInventory(Entity entity) {
		return inventoryEntity.get(entity);
	}

	public boolean contains(Item item) {
		for (Item items : this.items)
			if (items.getMaterial() == item.getMaterial())
				return true;

		return false;

	}

	public Item getItemInHand() {
		return this.itemInHand;
	}

	public void setItemInHand(Item item) {
		this.itemInHand = item;
	}

}
