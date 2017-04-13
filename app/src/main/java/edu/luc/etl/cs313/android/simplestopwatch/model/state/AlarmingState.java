package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

import android.media.AudioManager;
import android.media.ToneGenerator;

/**
 * Created by Sarah on 4/6/2017.
 * included ToneGenerator alert object to play alarm Manu Nair 4/13
 */

public class AlarmingState implements StopwatchState {

    public AlarmingState(final StopwatchSMStateView sm) {
        this.sm = sm;
    }

    private final StopwatchSMStateView sm;
    private final ToneGenerator alert= new ToneGenerator(AudioManager.STREAM_NOTIFICATION,100);


    @Override
    public void onStartStop() {
        sm.actionStop(); //stop the timer
        sm.actionReset();
        alert.stopTone();
        sm.toStoppedState(); //send to stopped state
    }

    //ignoring for now
   // @Override
    //public void onLapReset() {
    //    sm.toRunningState();
    //    sm.actionUpdateView();
    //}


    //don't change state onTick. Stays indefinitely until button clicked
    @Override
    public void onTick() {sm.toAlarmingState();alert.startTone(ToneGenerator.TONE_CDMA_ABBR_ALERT);}

    @Override
    public void updateView() { sm.updateUILaptime(); }

    @Override
    public int getId() { return R.string.ALARMING;}

}
