package com.example.simplestopwatch.android;

public class LapRunning implements StopwatchState {

	public void onStartStop(MainActivity adapter) {
		adapter.setLapStopped();
	}

	public void onLapReset(MainActivity adapter) {
		adapter.setRunning();
	}
	
	public void action(MainActivity adapter){
		adapter.actionLap();
	}
}
