package com.example.simplestopwatch;

import android.os.Handler;

public class LapState implements StopwatchState {

	public void performAction(MainActivity context, Application app, Handler handler) {
		app.incRuntime();
	}
}
