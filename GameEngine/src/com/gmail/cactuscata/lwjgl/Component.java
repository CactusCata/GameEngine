package com.gmail.cactuscata.lwjgl;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.glu.GLU;

import com.gmail.cactuscata.Main;
import com.gmail.cactuscata.game.Game;

public class Component {

	private final static int scale = 3;
	private static int width = 720 / scale;
	private static int height = 480 / scale;
	//private int time = 0;
	private boolean tick = false;
	private boolean render;
	private DisplayMode mode = new DisplayMode(width * scale, height * scale);
	private Game game;

	public Component(Game game) {
		this.game = game;
		display();
	}

	public void start() {
		Main.setEnable(true);
		loop();
	}

	private void stop() {
		Main.setEnable(false);
	}

	private void exit() {
		Display.destroy();
		System.exit(0);
	}

	private void loop() {

		long timer = System.currentTimeMillis();

		long before = System.nanoTime();
		double elapsed = 0;
		double nanoSeconds = 1000000000.0d / 10.0d;

		int ticks = 0;
		int frames = 0;

		while (Main.isEnable()) {
			if (Display.isCloseRequested()) stop();
			Display.update();
			width = Display.getWidth() / scale;
			height = Display.getHeight() / scale;

			tick = false;
			render = false;

			long now = System.nanoTime();
			elapsed = now - before;

			if (elapsed > nanoSeconds) {
				before += nanoSeconds;
				tick = true;
				ticks++;
			} else {
				render = true;
				frames++;
			}

			if (tick) update();
			if (render) render();
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("ticks: " + ticks + ", fps: " + frames);
				ticks = 0;
				frames = 0;
			}
		}
		exit();
	}

	private void view2D(int width, int height) {
		glViewport(0, 0, width * scale, height * scale);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		GLU.gluOrtho2D(0, width, height, 0);
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();

	}

	private void update() {
		//time++;
		game.update();
	}

	/*
	 * la fonction render permet de créer des points, pour chaque point on peut
	 * lui associer un couleur
	 * 
	 */

	private void render() {
		view2D(width, height);
		glClear(GL_COLOR_BUFFER_BIT); // permet de supprimer les résidus
		glClearColor(0.8f, 0.9f, 1.0f, 0.5f);

		game.render();

	}

	private void display() {
		try {
			Display.setDisplayMode(mode);
			Display.setResizable(true);
			Display.setFullscreen(false);
			Display.setTitle(Main.gameName);
			Display.create();
			view2D(width, height);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}

	public static int getWidth() {
		return width;
	}

	public static int getHeight() {
		return height;
	}

}
