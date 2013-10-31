package edu.luc.etl.cs313.android.simplestopwatch.model.clock;

/**
 * The active model of the internal clock that periodically emits tick events.
 *
 * @author laufer
 */
public interface ClockModel {
	void setRunnableScheduler(RunnableScheduler scheduler);
	void setOnTickListener(OnTickListener listener);
	void start();
	void stop();
}
