package edu.luc.etl.cs313.android.simplestopwatch.model.time;

import static edu.luc.etl.cs313.android.simplestopwatch.common.Constants.*;

/**
 * An implementation of the stopwatch data model.
 */
public class DefaultTimeModel implements TimeModel {

    private int runningTime = 0;

    private int lapTime = -1;

    private int incrementTime = 0;

    @Override
    public void resetRuntime() {
        runningTime = 0;
        incrementTime = 0;
    }

    @Override
    public void incRuntime() {
        runningTime = (runningTime + SEC_PER_TICK) % SEC_PER_HOUR;
    }

    @Override
    public int getRuntime() {
        return runningTime;
    }

    //eventually won't need
    @Override
    public void setLaptime() {
        lapTime = runningTime;
    }

    @Override
    public int getLaptime() {
        return lapTime;
    }


    //for ours
    //increases increment time by 1 minute
    @Override
    public void setIncrementTime() {
        if (incrementTime < 99) { //make sure doesn't break program if try to increment above 99
            incrementTime = incrementTime + SEC_PER_TICK;
        }
    }

    //returns incrementTime
    @Override
    public int getIncrementTime() { return incrementTime; }

    //decreases increment time by seconds per tick event, currently set to run 1000ms
    @Override
    public void decIncrementTime() { incrementTime = (incrementTime - SEC_PER_TICK) % SEC_PER_HOUR; }
}