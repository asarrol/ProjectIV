package edu.luc.etl.cs313.android.simplestopwatch.android;

/**
 * Client-specific interface for state transitions.
 *
 * @author laufer
 */
public interface StopwatchTransitions {
	public void toRunningState();
	public void toStoppedState();
	public void toLapRunningState();
	public void toLapStoppedState();
}
