package com.ja.trd;

import java.awt.Font;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ja.trd.Common.Data;
import com.ja.trd.Screens.SplashScreen;

public class TheRogueDungeoneers extends Game
{
	public SpriteBatch batch;
	public BitmapFont mainFont;
	
	@Override
	public void create()
	{
		// Create the sprite batch
		this.batch = new SpriteBatch();
		
		mainFont = new BitmapFont(Gdx.files.internal(Data.texturepack + "TRDFont.fnt"));
		
		// Create the splash screen
		this.setScreen(new SplashScreen(this));
	}
	
	@Override
	public void dispose()
	{
		super.dispose();
		this.batch.dispose();
		mainFont.dispose();
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
