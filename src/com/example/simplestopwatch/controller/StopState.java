package com.example.simplestopwatch.controller;

public class StopState implements StopwatchState {

	public void startStopPressed(StopwatchStateController adapter) {
		adapter.setRunState();
	}

	public void lapResetPressed(StopwatchStateController adapter) {
		// Do nothing.
	}

	public void action(StopwatchStateController adapter) {
		// Do nothing.
	}

}
