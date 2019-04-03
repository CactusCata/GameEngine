package com.gmail.cactuscata.game;

import com.gmail.cactuscata.lwjgl.Component;
import com.gmail.cactuscata.lwjgl.graphics.Renderer;

public class Game {

	public Game() {

	}

	public void init() {

	}

	public void update() {

	}

	public void render() {
		for (int x = 0; x < Component.getWidth(); x++)
			for (int y = 0; y < Component.getHeight(); y++) {
				Renderer.renderQuad(x, y, 1, 1, new float[] { 1, 0, 1, 1 });
			}

	}

}
