package com.gmail.cactuscata;

import com.gmail.cactuscata.entity.Entity;
import com.gmail.cactuscata.entity.list.Player;
import com.gmail.cactuscata.item.Item;
import com.gmail.cactuscata.item.Material;
import com.gmail.cactuscata.item.list.Potion;
import com.gmail.cactuscata.utils.Say;

public class FightManager {

	public static final void attack(Entity entitySendDamage, Entity entityRecevDamage) {

		if (entityRecevDamage.isDead() || entitySendDamage.isDead())
			return;

		int attack = entitySendDamage.getAttack();
		int defense = entityRecevDamage.getDefense();
		int damage = attack - defense;

		if (damage <= 0) {
			Say.sendMessage(
					"L'entit� " + entityRecevDamage.getName() + " n'a re�u aucun d�gats, son armure est trop haute !");
			return;
		}
		entityRecevDamage.setHealth(entityRecevDamage.getHealth() - damage);
		if (entityRecevDamage instanceof Player) {
			Say.sendMessage("Vous avez re�u " + damage + " d�gats du monstre " + entitySendDamage.getName()
					+ ", il vous reste " + entityRecevDamage.getHealth());

			Inventory inventory = entityRecevDamage.getInventory();
			Potion potion = null;
			for (int i = 0, j = inventory.getItems().size(); i < j; i++) {
				if (inventory.getItem(i).getMaterial() == Material.POTION) {
					potion = (Potion) inventory.getItem(i);
					break;
				}
			}

			if (potion != null) {

				String rep = Say.inputMessage("Voulez-vous utiliser votre potion ?");
				if (rep.equalsIgnoreCase("oui")) {
					inventory.removeItem(potion);
					potion.healh(entityRecevDamage);
				}

			}
		} else {
			Say.sendMessage("Vous avez inflig� " + damage + " d�gats au monstre " + entityRecevDamage.getName()
					+ ",il lui reste " + entityRecevDamage.getHealth());
		}
		isDead(entitySendDamage, entityRecevDamage);

	}

	private static final void isDead(Entity entitySendDamage, Entity entityRecevDamage) {

		if (entityRecevDamage.isDead()) {

			if (entityRecevDamage instanceof Player) {
				Say.sendMessage("Vous avez �t� tu� par un " + entitySendDamage.getName() + " !");
				Main.setEnable(true);
				Main.setEntityDeath(true);
				return;
			}

			Say.sendMessage("L'entit� " + entityRecevDamage.getName() + " a �t� tu� !");
			Say.sendMessage("Vous gagnez " + entityRecevDamage.getExperienceDroped() + "xp !");
			Player player = (Player) entitySendDamage;
			player.setExperience(entityRecevDamage.getExperienceDroped() + player.getExperience());
			for (Item item : entityRecevDamage.getInventory().getItems()) {
				Inventory.getInventory(entitySendDamage).addItem(item);
				Say.sendMessage("En tuant " + entityRecevDamage.getName() + " vous avez gagn� " + item.getName());
			}

			// int random = new Random().nextInt(100);
			// if (random > 70)
			Say.sendMessage("Vous avez gagn� une potion !");
			Inventory.getInventory(entitySendDamage).addItem(new Potion(1));
			Main.setEntityDeath(true);

		}

	}

}
