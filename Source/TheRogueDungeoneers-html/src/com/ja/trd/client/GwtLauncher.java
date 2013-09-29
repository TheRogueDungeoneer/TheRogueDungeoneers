package com.ja.trd.client;

import com.ja.trd.TheRogueDungeoneers;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class GwtLauncher extends GwtApplication {
	@Override
	public GwtApplicationConfiguration getConfig () {
		GwtApplicationConfiguration cfg = new GwtApplicationConfiguration(500, 600);
		return cfg;
	}

	@Override
	public ApplicationListener getApplicationListener () {
		return new TheRogueDungeoneers();
	}
}