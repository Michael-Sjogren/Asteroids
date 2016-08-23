package com.michaels.main.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.michaels.main.Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = Game.TITLE;
		config.width = Game.V_WIDTH * Game.SCALE;
		config.height = Game.V_HEIGHT * Game.SCALE;

		config.useGL30 = false;
		config.resizable = false;

		new LwjglApplication(new Game(), config);
	}
}
