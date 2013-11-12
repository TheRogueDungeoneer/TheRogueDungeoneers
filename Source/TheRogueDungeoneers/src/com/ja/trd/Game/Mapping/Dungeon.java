package com.ja.trd.Game.Mapping;

import java.util.List;
import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;
import com.ja.trd.Common.Constants;
import com.ja.trd.Game.Characters.Hero;

public class Dungeon
{
	// Variables
	
	public List<Floor> floors = new ArrayList<Floor>();
	
	// Players
	
	public List<Hero> heroes;
	
	// Constructor
	
	public Dungeon()
	{
		floors = new ArrayList<Floor>();
		heroes = new ArrayList<Hero>();
		
		createHero();
		floors.add(createFloor());
	}
	
	// Methods
	
	private void createHero()
	{
		Hero hero = new Hero();
		hero.currentFloor = 1;
		hero.moveNorth();
		hero.moveEast();
		heroes.add(hero);
	}
	
	public Hero getLocalHero()
	{
		return heroes.get(0);
	}
	
	public Floor createFloor()
	{
		Floor floor = new Floor(1, Constants.FLOOR_WIDTH, Constants.FLOOR_HEIGHT);
		floor.GenerateFloor();
		return floor;
	}
}
