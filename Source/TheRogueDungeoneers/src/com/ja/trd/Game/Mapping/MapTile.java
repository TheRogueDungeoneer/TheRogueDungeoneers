package com.ja.trd.Game.Mapping;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.ja.trd.Common.Data;

public class MapTile extends Tile
{
	public int mapTileId;
	
	public MapTile(int x, int y, int id)
	{
		this.x = x;
		this.y = y;
		this.mapTileId = id;
		getMapTileImage();
	}

	private void getMapTileImage()
	{
		// TODO: Make this based on a tile map
		this.image = new Image(new Texture(Gdx.files.internal(Data.texturepack + "Map\\" + "Floor.png")));
		image.setX(x * 32);
		image.setY(y * 32);
	}
}
