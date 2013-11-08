package com.example.simplestopwatch.android;

public interface StopwatchState {
	public void onStartStop(MainActivity adapter);
	public void onLapReset(MainActivity adapter);
	public void action(MainActivity adapter);
}