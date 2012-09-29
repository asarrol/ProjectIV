package edu.luc.etl.cs313.android.simplestopwatch.android;

public interface StopwatchTransitions {
	public void toRunningState();
	public void toStoppedState();
	public void toLapRunningState();
	public void toLapStoppedState();
}
