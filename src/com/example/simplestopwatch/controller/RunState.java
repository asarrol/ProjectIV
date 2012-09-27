package com.example.simplestopwatch.controller;

public class RunState implements StopwatchState {

	public void startStopPressed(StopwatchStateController adapter) {
		adapter.setStopState();
	}

	public void lapResetPressed(StopwatchStateController adapter) {
		adapter.setLapState();
	}

	public void action(StopwatchStateController adapter) {
		adapter.Run();
	}

}
