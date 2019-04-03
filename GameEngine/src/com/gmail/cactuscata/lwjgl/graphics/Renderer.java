package com.gmail.cactuscata.lwjgl.graphics;

import static org.lwjgl.opengl.GL11.*;

public class Renderer {

	private static void quadData(int x, int y, int width, int height, float[] colors) {

		glColor4f(colors[0], colors[1], colors[2], colors[3]);
		glVertex2f(x, y);
		glVertex2f(x + width, y);
		glVertex2f(x + width, y + height);
		glVertex2f(x, y + width);

	}

	public static void renderQuad(int x, int y, int width, int height, float[] colors) {
		glBegin(GL_QUADS);
		quadData(x, y, width, height, colors);
		glEnd();
	}

}
