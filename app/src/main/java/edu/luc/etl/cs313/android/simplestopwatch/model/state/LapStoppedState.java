package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

class LapStoppedState implements StopwatchState {

    public LapStoppedState(final StopwatchSMStateView sm) {
        this.sm = sm;
    }

    private final StopwatchSMStateView sm;

    @Override
    public void onStartStop() {
        sm.actionStart();
        sm.toLapRunningState();
    }

    //@Override
    //public void onLapReset() {
    //    sm.toStoppedState();
    //    sm.actionUpdateView();
    //}

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
        return R.string.LAP_STOPPED;
    }
}
