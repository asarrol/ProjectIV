package com.example.simplestopwatch.controller;

public interface StopwatchState {
	public void startStopPressed(StopwatchStateController adapter);
	public void lapResetPressed(StopwatchStateController adapter);
	public void action(StopwatchStateController adapter);
}
