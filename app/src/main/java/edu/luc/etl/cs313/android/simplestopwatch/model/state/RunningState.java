package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

class RunningState implements StopwatchState {

    public RunningState(final StopwatchSMStateView sm) {
        this.sm = sm;
    }

    private final StopwatchSMStateView sm;

    @Override
    public void onStartStop() {
        sm.actionReset();  //if button is pressed while running, stops and resets time and increment to zero
        sm.updateUILaptime();
        sm.toStoppedState();
    }

    //ignoring still for now
    //@Override
    //public void onLapReset() {
    //    sm.actionLap();
    //    sm.toLapRunningState();
    //}

    @Override
    public void onTick() {
        sm.actionInc(); //increments runtime
        sm.actionDec(); //decrements increment time
        if ( sm.actionGetIncTime() > 0 ){ sm.toRunningState(); } //resends to running state
        else { sm.updateUILaptime(); sm.toAlarmingState(); }
    }

    @Override
    public void updateView() { sm.updateUILaptime(); }
    //changed to Laptime, not sure how this will affect it currently

    @Override
    public int getId() {
        return R.string.RUNNING;
    }
}
