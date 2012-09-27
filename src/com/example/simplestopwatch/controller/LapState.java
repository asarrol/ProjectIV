package com.example.simplestopwatch.controller;

public class LapState implements StopwatchState {

	public void startStopPressed(StopwatchStateController adapter) {
		adapter.setRunState();
	}

	public void lapResetPressed(StopwatchStateController adapter) {
		adapter.setResetState();
	}

	public void action(StopwatchStateController adapter) {
		adapter.Lap();
	}

	
}
