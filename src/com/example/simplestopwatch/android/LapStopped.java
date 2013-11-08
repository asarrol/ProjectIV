package com.example.simplestopwatch.android;

public class LapStopped implements StopwatchState {

	public void onStartStop(MainActivity adapter) {
		adapter.setRunning();
	}

	public void onLapReset(MainActivity adapter) {
		adapter.setStopped();
	}
	
	public void action(MainActivity adapter){
		adapter.actionReset();
	}
}
