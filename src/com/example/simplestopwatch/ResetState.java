package com.example.simplestopwatch;

import android.os.Handler;

public class ResetState implements StopwatchState {

	public void performAction(MainActivity context, Application app, Handler handler) {
		app.resetRuntime();
		handler.post(context.updateResults);
		context.setState(new StopState());
	}
}
