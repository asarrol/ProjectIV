package edu.luc.etl.cs313.android.simplestopwatch.model;

import static edu.luc.etl.cs313.android.simplestopwatch.model.Constants.*;

/**
 * The passive (dumb) data model of the stopwatch.
 */
public class TimeModel {

	private int runningTime = 0;

	private int lapTime = -1;

	public void resetRuntime() {
		runningTime = 0;
	}

	public void incRuntime() {
		runningTime = (runningTime + SEC_PER_TICK) % SEC_PER_HOUR;
	}

	public int getRuntime() {
		return runningTime;
	}

	public void setLaptime() {
		lapTime = runningTime;
	}

	public int getLaptime() {
		return lapTime;
	}
}