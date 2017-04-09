package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

class StoppedState implements StopwatchState {

    public StoppedState(final StopwatchSMStateView sm) {
        this.sm = sm;
    }

    private final StopwatchSMStateView sm;

    @Override
    public void onStartStop() {
        sm.actionStart(); //starts timer and therefore tick events.
        sm.toIncrementState(); //sends to increment state
    }

    //ignoring for the moment
    @Override
    public void onLapReset() {
        sm.actionReset();
        sm.toStoppedState();
    }

    @Override
    public void onTick() {
        throw new UnsupportedOperationException("onTick");
    }

    @Override
    public void updateView() {
        sm.updateUILaptime();
    }

    @Override
    public int getId() {
        return R.string.STOPPED;
    }
}
