package com.ja.trd.Tweens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.ja.trd.Common.Constants;

import aurelienribon.tweenengine.TweenAccessor;

public class SplashTween implements TweenAccessor<Sprite>
{
	public static final int ALPHA = 1;
	
	@Override
	public int getValues(Sprite target, int tweenType, float[] returnValues)
	{
		switch (tweenType)
		{
			case ALPHA:
				returnValues[0] = target.getColor().a;
				return 1;
			default:
				return 0;
		}
	}
	
	@Override
	public void setValues(Sprite target, int tweenType, float[] newValues)
	{
		switch (tweenType)
		{
			case ALPHA:
				target.setColor(1, 1, 1, newValues[0]);
				break;
		}
	}
}