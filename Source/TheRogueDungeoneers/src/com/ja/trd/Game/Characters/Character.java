package com.ja.trd.Game.Characters;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.ja.trd.Common.Constants;

public class Character
{
	// Variables
	
	public Image image;
	public Vector2 position;
	public int currentFloor = 0;
	
	// Constructor
	
	// Methods
	
	public void moveNorth()
	{
		position.y += 1;
		updatePosition();
	}

	public void moveSouth()
	{
		position.y -= 1;
		updatePosition();
	}
	
	public void moveEast()
	{
		position.x += 1;
		updatePosition();
	}
	
	public void moveWest()
	{
		position.x -= 1;
		updatePosition();
	}
	
	protected void updatePosition()
	{
		image.setX(position.x * 32);
		image.setY(position.y * 32);
	}
}
