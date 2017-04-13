package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

/**
 * Created by Sarah on 4/6/2017.
 */

public class IncrementState implements StopwatchState {

    public IncrementState(final StopwatchSMStateView sm) {
        this.sm = sm;
    }

    private final int count = 3;

    private final StopwatchSMStateView sm;

    private int temp;

    //currently using start/stop button as our single multipurpose button
    @Override
    public void onStartStop() {
        temp = sm.actionGetTime(); //take note of runtime when clicked
        sm.actionIncTime(); //when clicked, increase increment time by one min
        if(sm.actionGetIncTime() < 100 ) {
            sm.actionUpdateView(); //update time on screen to reflect current increment time
        }
        sm.toIncrementState(); //when clicked send back to self in increment state
    }

    //sort of ignoring for now
    //@Override
    //public void onLapReset() {
    //    sm.toRunningState();
    //    sm.actionUpdateView();
    //}

    @Override
    public void onTick() {
        sm.actionInc(); //increment runtime
        if (sm.actionGetTime() - temp == count ) {
            //add single beep functionality here
            sm.toRunningState(); //if three seconds has passed send to running state
        }
        else sm.toIncrementState(); //otherwise return to increment state
    }

    @Override
    public void updateView() {
        sm.updateUILaptime();
    } //UILaptime returns increment time

    @Override
    public int getId() { return R.string.INCREMENTING;} //going to need to make this say incrementing eventually
}
