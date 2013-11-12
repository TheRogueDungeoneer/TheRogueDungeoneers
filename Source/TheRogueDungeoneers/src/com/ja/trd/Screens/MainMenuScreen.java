package com.ja.trd.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.utils.Scaling;
import com.ja.trd.TheRogueDungeoneers;
import com.ja.trd.Common.Constants;
import com.ja.trd.Common.Data;

public class MainMenuScreen implements Screen
{
	private TheRogueDungeoneers game;
	private Texture bgTexture;
	
	private Stage stage;
	
	private Group bgGroup;
	
	private Label mainTitle;
	
	private Texture playTexture;
	private Texture statsTexture;
	private Texture optionsTexture;
	private Texture aboutTexture;
	
	private Image playImage;
	private Image statsImage;
	private Image optionsImage;
	private Image aboutImage;
	
	private int buttonOffset = 32;
	
	public MainMenuScreen(final TheRogueDungeoneers game)
	{
		// Get game instance
		this.game = game;
	}
	
	@Override
	public void render(float delta)
	{
		// Clear previous frame
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
		bgTexture = new Texture(Gdx.files.internal(Data.texturepack + "Menu\\" + "menubg.png"));
		bgTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		bgTexture.setWrap(TextureWrap.Repeat, TextureWrap.Repeat);
		
		playTexture = new Texture(Gdx.files.internal(Data.texturepack + "Menu\\" + "menuPlay.png"));
		playTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		statsTexture = new Texture(Gdx.files.internal(Data.texturepack + "Menu\\" + "menuStats.png"));
		statsTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		optionsTexture = new Texture(Gdx.files.internal(Data.texturepack + "Menu\\" + "menuOptions.png"));
		optionsTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		aboutTexture = new Texture(Gdx.files.internal(Data.texturepack + "Menu\\" + "menuAbout.png"));
		aboutTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	}
	
	@Override
	public void resize(int width, int height)
	{
		stage = new Stage(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, true);
		stage.clear();
		
		Vector2 size = Scaling.fit.apply(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, width, height);
		int viewportX = (int) (width - size.x) / 2;
		int viewportY = (int) (height - size.y) / 2;
		int viewportWidth = (int) size.x;
		int viewportHeight = (int) size.y;
		Gdx.gl.glViewport(viewportX, viewportY, viewportWidth, viewportHeight);
		stage.setViewport(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, true, viewportX, viewportY, viewportWidth, viewportHeight);
		
		Gdx.input.setInputProcessor(stage);
		
		setupMenuActors(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		addMenuActors();
	}
	
	private void setupMenuActors(int width, int height)
	{
		bgGroup = new Group();
		
		for (int i = 0; i <= (width / bgTexture.getWidth()) + 1; i++)
		{
			for (int j = 0; j <= (height / bgTexture.getHeight()) + 1; j++)
			{
				Image img = new Image(bgTexture);
				img.setPosition(i * bgTexture.getWidth(), j * bgTexture.getHeight());
				bgGroup.addActor(img);
			}
		}
		
		playImage = new Image(playTexture);
		statsImage = new Image(statsTexture);
		optionsImage = new Image(optionsTexture);
		aboutImage = new Image(aboutTexture);
		
		playImage.setPosition((width / 2) - buttonOffset - playTexture.getWidth(), (height / 2) + buttonOffset + statsImage.getHeight());
		statsImage.setPosition((width / 2) + buttonOffset, (height / 2) + buttonOffset + statsImage.getHeight());
		optionsImage.setPosition((width / 2) - buttonOffset - optionsImage.getWidth(), (height / 2));
		aboutImage.setPosition(width / 2 + buttonOffset, (height / 2));
		
		playImage.addListener(new InputListener()
		{
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
			{
				game.setScreen(new GameScreen(game));
				return false;
			}
		});
		
		statsImage.addListener(new InputListener()
		{
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
			{
				Gdx.app.log(com.ja.trd.Common.Constants.LOG_TAG, "Stats");
				return false;
			}
		});
		
		optionsImage.addListener(new InputListener()
		{
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
			{
				Gdx.app.log(com.ja.trd.Common.Constants.LOG_TAG, "Options");
				return false;
			}
		});
		
		aboutImage.addListener(new InputListener()
		{
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
			{
				Gdx.app.log(com.ja.trd.Common.Constants.LOG_TAG, "About");
				return false;
			}
		});
		
		LabelStyle ls = new LabelStyle(game.mainFont, Color.BLACK);
		mainTitle = new Label("The Rogue Dungeoneers!", ls);
		mainTitle.setX(0);
		mainTitle.setY(Constants.SCREEN_HEIGHT * 0.9f);
		mainTitle.setWidth(width);
		mainTitle.setAlignment(Align.center);
	}
	
	private void addMenuActors()
	{
		stage.addActor(bgGroup);
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
