package com.example.simplestopwatch.controller;

public class ResetState implements StopwatchState {

	public void startStopPressed(StopwatchStateController adapter) {
		// Do nothing, will be automatically
		// sent to the Stop state.
		
	}

	public void lapResetPressed(StopwatchStateController adapter) {
		// Do nothing, will be automatically
		// sent to the Stop state.
	}

	public void action(StopwatchStateController adapter) {
		adapter.Reset();
		adapter.setStopState();
	}
}
