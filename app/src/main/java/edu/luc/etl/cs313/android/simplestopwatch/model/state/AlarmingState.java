package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

/**
 * Created by Sarah on 4/6/2017.
 */

public class AlarmingState implements StopwatchState {

    public AlarmingState(final StopwatchSMStateView sm) {
        this.sm = sm;
    }

    private final StopwatchSMStateView sm;

    //look to alarmingstate in clickcounter for sound?

    @Override
    public void onStartStop() {
        sm.actionStop(); //stop the timer
        sm.actionReset();
        sm.toStoppedState(); //send to stopped state
    }

    //ignoring for now
    @Override
    public void onLapReset() {
        sm.toRunningState();
        sm.actionUpdateView();
    }


    //don't change state onTick. Stays indefinitely until button clicked
    @Override
    public void onTick() { sm.toAlarmingState(); }

    @Override
    public void updateView() { sm.updateUILaptime(); }

    @Override
    public int getId() { return R.string.ALARMING;}

}
