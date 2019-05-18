package com.iapstudio.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.iapstudio.game.PixelPlane;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new PixelPlane(), config);
		config.width= PixelPlane.WIDTH;
		config.height= PixelPlane.HEIGHT;
		config.title= PixelPlane.TITLE;
	}
}
