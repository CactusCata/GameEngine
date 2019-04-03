package com.gmail.cactuscata.item;

import java.util.ArrayList;

public abstract class Item {

	public abstract void setName(String name);

	public abstract void setAmount(int number);

	public abstract void createLore(ArrayList<String> lore);

	public abstract void setLore(int lineLore, String lore);

	public abstract void addLore(String lore);

	public abstract void removeLore(int lineLore);

	public abstract String getName();

	public abstract int getAmount();

	public abstract ArrayList<String> getLore();

	public abstract String getLineLore(int lineLore);

	public abstract Material getMaterial();

}
