package com.ja.trd.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.ja.trd.TheRogueDungeoneers;
import com.ja.trd.Common.Constants;
import com.ja.trd.Game.Characters.Hero;
import com.ja.trd.Game.Mapping.Dungeon;
import com.ja.trd.Game.Mapping.Floor;
import com.ja.trd.Game.Mapping.MapTile;

public class GameScreen implements Screen
{
	private TheRogueDungeoneers game;
	private Stage stage;
	
	// Groups
	private Group characterGroup;
	private Group mapGroup;
	private Group itemGroup;
	
	// Dungeon
	private Dungeon dungeon;
	private Hero localHero;
	private Floor currentFloor;
	
	public GameScreen(final TheRogueDungeoneers game)
	{
		// Get game instance
		this.game = game;
	}
	
	@Override
	public void render(float delta)
	{
		update(delta);
		draw();
	}
	
	private void update(float delta)
	{
		
	}
	
	private void draw()
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
		stage.addListener(new InputListener()
		{
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
			{
				return handleTouchDown(event, x, y, pointer, button);
			}
			
			public void touchUp(InputEvent event, float x, float y, int pointer, int button)
			{
				handleTouchUp(event, x, y, pointer, button);
			}
		});
		
		this.addActors();
	}
	
	protected boolean handleTouchDown(InputEvent event, float x, float y, int pointer, int button)
	{
		// Handle touch on hero
		if(isPointInArea(x, y, new Rectangle(localHero.image.getX(), localHero.image.getY(), localHero.image.getWidth(), localHero.image.getHeight())))
		{
		}
		
		// Handle touch on other square
		
		
		return false;
	}
	
	protected void handleTouchUp(InputEvent event, float x, float y, int pointer, int button)
	{
	}
	
	private boolean isPointInArea(float px, float py, Rectangle rect)
	{
		boolean x = (px >= rect.x) && (px <= rect.x + rect.width);
		boolean y = (py >= rect.y) && (py <= rect.y + rect.height);
		return (x && y);
	}
	
	@Override
	public void show()
	{
		dungeon = new Dungeon();
		localHero = dungeon.getLocalHero();
	}
	
	public void addActors()
	{
		characterGroup = new Group();
		mapGroup = new Group();
		itemGroup = new Group();
		
		for (int i = 0; i < dungeon.heroes.size(); i++)
		{
			characterGroup.addActor(dungeon.heroes.get(i).image);
		}
		
		int floor = localHero.currentFloor;
		for(int i = 0; i < dungeon.floors.size(); i++)
		{
			if(dungeon.floors.get(i).level == floor)
			{
				currentFloor = dungeon.floors.get(i);
			}
		}
		
		for (int i = 0; i < currentFloor.mapTiles.size(); i++)
		{
			mapGroup.addActor(currentFloor.mapTiles.get(i).image);
		}
		
		stage.addActor(mapGroup);
		stage.addActor(itemGroup);
		stage.addActor(characterGroup);
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
	}
	
}
