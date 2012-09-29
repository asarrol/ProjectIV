package edu.luc.etl.cs313.android.simplestopwatch.model.time;

import static edu.luc.etl.cs313.android.simplestopwatch.model.time.Constants.*;

/**
 * An implementation of the stopwatch data model.
 */
public class DefaultTimeModel implements TimeModel {

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