package com.ja.trd.Game.Mapping;

import java.util.ArrayList;
import java.util.List;

public class Floor
{
	// Variables
	
	public int level;
	public final int width;
	public final int height;
	public List<MapTile> mapTiles;
	public List<ItemTile> itemTiles;
	
	// Constructor
	
	public Floor(int level, int width, int height)
	{
		this.level = level;
		this.width = width;
		this.height = height;
	}
	
	public void GenerateFloor()
	{
		mapTiles = new ArrayList<MapTile>();
		itemTiles = new ArrayList<ItemTile>();
		
		// TODO: Create floor using some algorithm
		for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < height; j++)
			{
				mapTiles.add(new MapTile(i, j, 1));
			}
		}
	}
	
	// Methods
}
