package edu.luc.etl.cs313.android.simplestopwatch.android;

/**
 * Actions tied to state transitions.
 *
 * @author laufer
 */
public interface StopwatchActions {
	void actionReset();
	void actionStart();
	void actionStop();
	void actionLap();
	void actionInc();
	void actionUpdateView();
}
