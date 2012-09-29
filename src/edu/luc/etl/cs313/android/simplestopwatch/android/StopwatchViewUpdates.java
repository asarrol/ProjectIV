package edu.luc.etl.cs313.android.simplestopwatch.android;

/**
 * Client-specific interface for triggering state-specific view updates.
 *
 * @author laufer
 */
public interface StopwatchViewUpdates {
	void updateViewRuntime();
	void updateViewLaptime();
}
