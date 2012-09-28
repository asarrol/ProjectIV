package com.example.simplestopwatch.android;

public class Running implements StopwatchState {

	public void onStartStop(MainActivity adapter) {
		adapter.setStopped();
	}

	public void onLapReset(MainActivity adapter) {
		adapter.setLapRunning();
	}
	
	public void action(MainActivity adapter){
		adapter.actionRun();
	}
}
