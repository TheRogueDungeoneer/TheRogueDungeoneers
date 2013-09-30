package com.ja.trd.Screens;

import java.beans.EventSetDescriptor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.ja.trd.TheRogueDungeoneers;
import com.ja.trd.Common.Data;
import com.sun.org.apache.xml.internal.security.utils.Constants;

public class MainMenuScreen implements Screen
{
	private TheRogueDungeoneers game;
	private Texture bgTexture;
	private Image bgImage;
	
	private Stage stage;
	
	private Label mainTitle;
	
	private Texture playTexture;
	private Texture statsTexture;
	private Texture optionsTexture;
	private Texture aboutTexture;
	
	private Image playImage;
	private Image statsImage;
	private Image optionsImage;
	private Image aboutImage;
	
	private Label playLabel;
	private Label statsLabel;
	private Label optionsLabel;
	private Label aboutLabel;
	
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
				+ "menubg.png"));
		bgTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		playTexture = new Texture(Gdx.files.internal(Data.texturepack
				+ "menuPlay.png"));
		playTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		statsTexture = new Texture(Gdx.files.internal(Data.texturepack
				+ "menuStats.png"));
		statsTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		optionsTexture = new Texture(Gdx.files.internal(Data.texturepack
				+ "menuOptions.png"));
		optionsTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		aboutTexture = new Texture(Gdx.files.internal(Data.texturepack
				+ "menuAbout.png"));
		aboutTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	}
	
	@Override
	public void resize(int width, int height)
	{
		stage = new Stage(width, height, true);
		stage.clear();
		
		Gdx.input.setInputProcessor(stage);
		
		bgImage = new Image(bgTexture);
		bgImage.setSize(width, height);
		
		playImage = new Image(playTexture);
		playImage.setPosition(width / 2 - 48, height / 2 + 50);
		playImage.addListener(new InputListener() {
		    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
		    {
		        Gdx.app.log(com.ja.trd.Common.Constants.LOG_TAG, "Playing");
		        return false;
		    }
		});
		
		statsImage = new Image(statsTexture);
		statsImage.setPosition(width / 2 + 16, height / 2 + 50);
		statsImage.addListener(new InputListener() {
		    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
		    {
		        Gdx.app.log(com.ja.trd.Common.Constants.LOG_TAG, "Stats");
		        return false;
		    }
		});
		
		optionsImage = new Image(optionsTexture);
		optionsImage.setPosition(width / 2 - 48, height / 2 - 50);
		optionsImage.addListener(new InputListener() {
		    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
		    {
		        Gdx.app.log(com.ja.trd.Common.Constants.LOG_TAG, "Options");
		        return false;
		    }
		});
		
		aboutImage = new Image(aboutTexture);
		aboutImage.setPosition(width / 2 + 16, height / 2 - 50);
		aboutImage.addListener(new InputListener() {
		    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
		    {
		        Gdx.app.log(com.ja.trd.Common.Constants.LOG_TAG, "About");
		        return false;
		    }
		});
		
		LabelStyle ls = new LabelStyle(game.mainFont, Color.BLACK);
		mainTitle = new Label("The Rogue Dungeoneers!", ls);
		mainTitle.setX(0);
		mainTitle.setY(Gdx.graphics.getHeight() - 100);
		mainTitle.setWidth(width);
		mainTitle.setAlignment(Align.center);
		
		stage.addActor(bgImage);
		stage.addActor(mainTitle);
		stage.addActor(playImage);
		stage.addActor(statsImage);
		stage.addActor(optionsImage);
		stage.addActor(aboutImage);
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
