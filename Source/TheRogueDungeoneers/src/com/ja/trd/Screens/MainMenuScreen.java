package com.ja.trd.Screens;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.ja.trd.TheRogueDungeoneers;
import com.ja.trd.Common.Constants;
import com.ja.trd.Common.Data;
import com.ja.trd.Tweens.SplashTween;

public class MainMenuScreen implements Screen
{
	private TheRogueDungeoneers game;
	private Texture bgTexture;
	private Image bgImage;
	
	private Stage stage;
	
	private Label mainTitle;
	
	public MainMenuScreen(final TheRogueDungeoneers game)
	{
		// Get game instance
		this.game = game;
	}
	
	@Override
	public void render(float delta)
	{
		// Clear the screen
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		stage.act();
		
		// Draw batch
		game.batch.begin();
		stage.draw();
		game.batch.end();
	}
	
	@Override
	public void show()
	{
		bgTexture = new Texture(Gdx.files.internal(Data.texturepack
				+ "menubg.png"), false);
		bgTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	}
	
	@Override
	public void resize(int width, int height)
	{
		stage = new Stage(width, height, true);
		stage.clear();
		
		Gdx.input.setInputProcessor(stage);
		
		bgImage = new Image(bgTexture);
		bgImage.setSize(width, height);
		
		LabelStyle ls = new LabelStyle(game.mainFont, Color.BLACK);
		mainTitle = new Label("The Rogue Dungeoneers!", ls);
		mainTitle.setX(0);
        mainTitle.setY(Gdx.graphics.getHeight() - 100);
		mainTitle.setWidth(width);
		mainTitle.setAlignment(Align.center);
		
		stage.addActor(bgImage);
		stage.addActor(mainTitle);
	}
	
	@Override
	public void hide()
	{
		
	}
	
	@Override
	public void pause()
	{
		
	}
	
	@Override
	public void resume()
	{
		
	}
	
	@Override
	public void dispose()
	{
		stage.dispose();
	}
	
}
