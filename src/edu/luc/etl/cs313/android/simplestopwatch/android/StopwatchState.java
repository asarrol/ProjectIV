package edu.luc.etl.cs313.android.simplestopwatch.android;

public interface StopwatchState {
	public void onStartStop();
	public void onLapReset();
	public void onTick();
	public void updateView();
}
