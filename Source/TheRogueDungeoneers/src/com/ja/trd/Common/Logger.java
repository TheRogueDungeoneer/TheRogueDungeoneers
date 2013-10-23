package com.ja.trd.Common;

import com.badlogic.gdx.Gdx;

public class Logger
{
	public static void Log(String message)
	{
		Gdx.app.log(Constants.LOG_TAG, message);
	}
}
