package edu.luc.etl.cs313.android.simplestopwatch.model.state;

/**
 * The restricted view states have of their surrounding state machine.
 * This is a client-specific interface in Peter Coad's terminology.
 *
 * @author laufer
 */
interface StopwatchSMStateView {

    // transitions
    void toRunningState();
    void toStoppedState();
    void toAlarmingState();
    void toIncrementState();

    // actions
    void actionInit();
    void actionReset();
    void actionStart();
    void actionStop();
    void actionInc();
    void actionUpdateView();
    void actionDec();
    void actionIncTime();
    int actionGetTime ();
    int actionGetIncTime();

    // state-dependent UI updates
    //void updateUIRuntime();
    //I used Laptime for the display time
    void updateUILaptime();
}
