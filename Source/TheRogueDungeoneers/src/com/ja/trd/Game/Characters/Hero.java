package com.ja.trd.Game.Characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.ja.trd.Common.Data;

public class Hero extends Character
{
	public Hero()
	{
		image = new Image(new Texture(Gdx.files.internal(Data.texturepack + "Characters\\" + "hero.png")));
		position = new Vector2(0, 0);
	}
}
