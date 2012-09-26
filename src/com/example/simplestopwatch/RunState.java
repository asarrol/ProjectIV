package com.example.simplestopwatch;

import android.os.Handler;

public class RunState implements StopwatchState {

	public void performAction(MainActivity context, Application app, Handler handler){
		handler.post(context.updateResults);
		app.incRuntime();
	}
}
