package edu.luc.etl.cs313.android.simplestopwatch.android;

/**
 * A source of UI update events for the stopwatch.
 * This interface is typically implemented by the model.
 *
 * @author laufer
 */
public interface StopwatchUIUpdateAware {
	void setUIUpdateListener(StopwatchUIUpdateListener listener);
}
