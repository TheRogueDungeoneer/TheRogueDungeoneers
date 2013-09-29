package com.ja.trd;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ja.trd.Screens.SplashScreen;

public class TheRogueDungeoneers extends Game
{
	public SpriteBatch batch;
	
	@Override
	public void create()
	{
		// Create the sprite batch
		this.batch = new SpriteBatch();
		
		// Create the splash screen
		this.setScreen(new SplashScreen(this));
	}
	
	@Override
	public void dispose()
	{
		super.dispose();
		this.batch.dispose();
	}
	
	@Override
	public void render()
	{
		super.render();
	}
	
	@Override
	public void resize(int width, int height)
	{
		super.resize(width, height);
	}
	
	@Override
	public void pause()
	{
		super.pause();
	}
	
	@Override
	public void resume()
	{
		super.resume();
	}
}
