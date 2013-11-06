package edu.luc.etl.cs313.android.simplestopwatch.model.clock;

import edu.luc.etl.cs313.android.simplestopwatch.common.NeedsRunnableScheduler;
import edu.luc.etl.cs313.android.simplestopwatch.common.RunnableScheduler;

/**
 * The active model of the internal clock that periodically emits tick events.
 *
 * @author laufer
 */
public interface ClockModel extends NeedsRunnableScheduler {
	void setOnTickListener(OnTickListener listener);
	void start();
	void stop();
}
