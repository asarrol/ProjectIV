package edu.luc.etl.cs313.android.simplestopwatch.model;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Handler;

/**
 * The active (event-emitting) model of the internal clock that produces periodic ticks.
 */
public class TickModel {

	public TickModel(final TickListener listener) {
		this.listener = listener;
	}

	private final TickListener listener;

	private Timer timer; // TODO use handler only

	private Handler handler = new Handler();

	public void start() {
		timer = new Timer();

		// The tickModel runs performAction() every 1000 milliseconds
		timer.schedule(new TimerTask() {
			@Override public void run() {
				// schedule the onTick event on the UI thread
				handler.post(new Runnable() {
					@Override public void run() {
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