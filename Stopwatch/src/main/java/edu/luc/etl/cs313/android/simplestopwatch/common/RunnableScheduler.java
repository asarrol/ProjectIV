package edu.luc.etl.cs313.android.simplestopwatch.common;

/**
 * An after-the-fact abstraction of {@link android.os.Handler}.
 * This is required for testing components that depend on a
 * message scheduler outside of the Android platform.
 *
 * @author laufer
 */
public interface RunnableScheduler {
	boolean post(Runnable r);
}
