package edu.luc.etl.cs313.android.simplestopwatch.common;

/**
 * A listener for stopwatch events coming from the UI.
 *
 * @author laufer
 */
public interface StopwatchUIListener {
    void onStartStop();
    void onLapReset();

    //using onStartStop for our functionality for now
    //for later
    //void onClick();
}
