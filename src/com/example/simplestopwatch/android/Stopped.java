package com.example.simplestopwatch.android;

public class Stopped implements StopwatchState {

	public void onStartStop(MainActivity adapter) {
		adapter.setRunning();
	}

	public void onLapReset(MainActivity adapter) {
		adapter.setLapStopped();
	}
	
	public void action(MainActivity adapter){
		
	}
}
