package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.common.StopwatchUIUpdateListener;
import edu.luc.etl.cs313.android.simplestopwatch.model.clock.ClockModel;
import edu.luc.etl.cs313.android.simplestopwatch.model.time.TimeModel;

/**
 * An implementation of the state machine for the stopwatch.
 *
 * @author laufer
 */
public class DefaultStopwatchStateMachine implements StopwatchStateMachine {

    public DefaultStopwatchStateMachine(final TimeModel timeModel, final ClockModel clockModel) {
        this.timeModel = timeModel;
        this.clockModel = clockModel;
    }

    private final TimeModel timeModel;

    private final ClockModel clockModel;

    /**
     * The internal state of this adapter component. Required for the State pattern.
     */
    private StopwatchState state;

    protected void setState(final StopwatchState state) {
        this.state = state;
        uiUpdateListener.updateState(state.getId());
    }

    private StopwatchUIUpdateListener uiUpdateListener;

    @Override
    public void setUIUpdateListener(final StopwatchUIUpdateListener uiUpdateListener) {
        this.uiUpdateListener = uiUpdateListener;
    }

    // forward event uiUpdateListener methods to the current state
    // these must be synchronized because events can come from the
    // UI thread or the timer thread
    @Override public synchronized void onStartStop() { state.onStartStop(); }
    //@Override public synchronized void onLapReset()  { state.onLapReset(); }
    @Override public synchronized void onTick()      { state.onTick(); }

    //@Override public void updateUIRuntime() { uiUpdateListener.updateTime(timeModel.getRuntime()); }
    @Override public void updateUILaptime() { uiUpdateListener.updateTime(timeModel.getIncrementTime()); }
    //I changed this to show increment time

    // known states
    private final StopwatchState STOPPED     = new StoppedState(this);
    private final StopwatchState RUNNING     = new RunningState(this);
    private final StopwatchState LAP_RUNNING = new LapRunningState(this);
    private final StopwatchState LAP_STOPPED = new LapStoppedState(this);

    //our known states
    private final StopwatchState ALARMING = new AlarmingState(this);
    private final StopwatchState INCREMENTING = new IncrementState(this);

    // transitions
    @Override public void toRunningState()    { setState(RUNNING); }
    @Override public void toStoppedState()    { setState(STOPPED); }
    @Override public void toLapRunningState() { setState(LAP_RUNNING); }
    @Override public void toLapStoppedState() { setState(LAP_STOPPED); }

    //our transitions
    @Override public void toAlarmingState() { setState(ALARMING); }
    @Override public void toIncrementState() { setState(INCREMENTING);}

    // actions
    @Override public void actionInit()       { toStoppedState(); actionReset(); }
    @Override public void actionReset()      { timeModel.resetRuntime(); actionUpdateView(); }
    @Override public void actionStart()      { clockModel.start(); }
    @Override public void actionStop()       { clockModel.stop(); }
    //@Override public void actionLap()        { timeModel.setLaptime(); }
    @Override public void actionInc()        { timeModel.incRuntime(); actionUpdateView(); }
    @Override public void actionUpdateView() { state.updateView(); }


    //our actions
    @Override public void actionDec() { timeModel.decIncrementTime(); actionUpdateView(); }
    @Override public void actionIncTime() { timeModel.setIncrementTime(); actionUpdateView(); }
    @Override public int actionGetTime () { return timeModel.getRuntime(); }
    @Override public int actionGetIncTime() { return timeModel.getIncrementTime(); }
}
