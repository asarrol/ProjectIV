package edu.luc.etl.cs313.android.simplestopwatch.model.clock;

import android.os.Handler;

/**
 * Thin adapter for using a Handler as a RunnableScheduler.
 *
 * @author laufer
 */
public class HandlerAsRunnableScheduler implements RunnableScheduler {

	private Handler handler = new Handler();

	@Override
	public boolean post(Runnable r) {
		return handler.post(r);
	}
}
