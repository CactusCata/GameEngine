package com.gmail.cactuscata;

import com.gmail.cactuscata.entity.Entity;
import com.gmail.cactuscata.entity.EntityType;
import com.gmail.cactuscata.entity.list.Player;
import com.gmail.cactuscata.game.Game;
import com.gmail.cactuscata.lwjgl.Component;
import com.gmail.cactuscata.utils.Say;

public class Main {

	private static boolean isEnable;
	private static boolean entityDeath;
	public static final String gameName = "GameEngine";
	private static Game game;

	public Main() {
		
	}

	public static void main(String[] args) {
		
		game = new Game();
		Component component = new Component(game);
		component.start();

		Player player = new Player();
		player.setName(Say.inputMessage("Bienvenue au jeu !\nVeuillez choisir un nom : "));

		while (isEnable) {

			Entity entityEnnemie = EntityType.getRandomEntity();
			entityDeath = false;

			while (!entityDeath) {

				fight((Entity) player, entityEnnemie);
				fight(entityEnnemie, (Entity) player);
			}
		}
	}

	private static final void fight(Entity entityOne, Entity entityTwo) {

		FightManager.attack(entityOne, entityTwo);

	}

	public static final void setEnable(boolean isEnable) {
		Main.isEnable = isEnable;
	}
	
	public static final boolean isEnable() {
		return isEnable;
	}

	public static final void setEntityDeath(boolean entityDeath) {
		Main.entityDeath = entityDeath;
	}

}
