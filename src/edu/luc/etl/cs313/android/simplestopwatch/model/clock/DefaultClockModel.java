package edu.luc.etl.cs313.android.simplestopwatch.model.clock;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Handler;

/**
 * An implementation of the internal clock.
 *
 * @author laufer
 */
public class DefaultClockModel implements ClockModel {

	// TODO make accurate by keeping track of partial seconds when canceled etc.

	private Timer timer; // TODO use handler only

	private Handler handler = new Handler();

	private OnTickListener listener;

	public void setOnTickListener(final OnTickListener listener) {
		this.listener = listener;
	}

	public void start() {
		timer = new Timer();

		// The tickModel runs performAction() every 1000 milliseconds
		timer.schedule(new TimerTask() {
			@Override public void run() {
				// schedule the onTick event on the UI thread
				handler.post(new Runnable() {
					@Override public void run() {
						// fire event
						listener.onTick();
					}
				});
			}
		}, /*initial delay*/ 1000, /*periodic delay*/ 1000);
	}

	public void stop() {
		timer.cancel();
	}
}