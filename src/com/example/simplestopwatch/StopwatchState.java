package com.example.simplestopwatch;

import android.os.Handler;

public interface StopwatchState {

	public void performAction(MainActivity context, Application app, Handler handler);
}
