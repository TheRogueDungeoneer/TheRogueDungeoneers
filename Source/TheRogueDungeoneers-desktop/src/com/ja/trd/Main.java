package com.ja.trd;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "TheRogueDungeoneers";
		cfg.useGL20 = true;
		cfg.width = 500;
		cfg.height = 600;
		
		new LwjglApplication(new TheRogueDungeoneers(), cfg);
	}
}