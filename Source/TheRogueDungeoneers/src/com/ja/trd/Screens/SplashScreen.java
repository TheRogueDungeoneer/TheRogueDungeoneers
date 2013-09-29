package com.ja.trd.Screens;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.ja.trd.TheRogueDungeoneers;
import com.ja.trd.Common.Constants;
import com.ja.trd.Common.Data;
import com.ja.trd.Tweens.SplashTween;

public class SplashScreen implements Screen
{
	private TheRogueDungeoneers game;
	private TweenManager tweenManager;
	private Texture splashTexture;
	private Sprite splashSprite;
	
	public SplashScreen(final TheRogueDungeoneers game)
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
				
		// Update Tween
		tweenManager.update(delta);
		
		// Draw batch
		game.batch.begin();
		splashSprite.draw(game.batch);
		game.batch.end();
	}
		
	@Override
	public void show()
	{		
		splashTexture = new Texture(Gdx.files.internal(Data.texturepack + "splash.png"));
		splashTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		splashSprite = new Sprite(splashTexture);
		splashSprite.setColor(1, 1, 1, 0);
				
		tweenManager = new TweenManager();
		Tween.registerAccessor(Sprite.class, new SplashTween());
		
		TweenCallback cb = new TweenCallback()
		{
			
			@Override
			public void onEvent(int type, BaseTween<?> source)
			{
				splashTweenFinished();
			}
		};
		
		Tween.to(splashSprite, SplashTween.ALPHA, Constants.SPLASH_DURATION)
				.target(1).ease(TweenEquations.easeInQuad)
				.repeatYoyo(1, Constants.SPLASH_DURATION).setCallback(cb)
				.setCallbackTriggers(TweenCallback.COMPLETE)
				.start(tweenManager);
	}
	
	public void splashTweenFinished()
	{
		game.setScreen(new MainMenuScreen(game));
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
	public void resize(int width, int height)
	{
		
	}
	
	@Override
	public void dispose()
	{
		
	}
	
}
