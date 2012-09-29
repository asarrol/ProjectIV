package edu.luc.etl.cs313.android.simplestopwatch.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import edu.luc.etl.cs313.android.simplestopwatch.R;
import edu.luc.etl.cs313.android.simplestopwatch.model.Constants;
import edu.luc.etl.cs313.android.simplestopwatch.model.TickListener;
import edu.luc.etl.cs313.android.simplestopwatch.model.TickModel;
import edu.luc.etl.cs313.android.simplestopwatch.model.TimeModel;

public class ConcreteStopwatchAdapter extends Activity implements TickListener, StopwatchAdapter {

	/**
	 * The active background timer.
	 */
	private TickModel tickModel;

	/**
	 * The passive current running time and lap time.
	 */
	private TimeModel timeModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tickModel = new TickModel(this);
		timeModel = new TimeModel();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	protected void onStart() {
		super.onStart();
		toStoppedState();
		actionReset();
	}

	// TODO lifecycle methods

	/**
	 * Updates the seconds and minutes in the UI.
	 * @param time
	 */
	public void updateView(final int time) {
		final TextView tvS = (TextView) findViewById(R.id.seconds);
		final TextView tvM = (TextView) findViewById(R.id.minutes);
		final int seconds = time % Constants.SEC_PER_MIN;
		final int minutes = time / Constants.SEC_PER_MIN;
		tvS.setText(Integer.toString(seconds / 10) + Integer.toString(seconds % 10));
		tvM.setText(Integer.toString(minutes / 10) + Integer.toString(minutes % 10));
	}

	@Override public void updateViewRuntime() { updateView(timeModel.getRuntime()); }
	@Override public void updateViewLaptime() { updateView(timeModel.getLaptime()); }

	/**
	 * The internal state of this adapter component. Required for the State pattern.
	 */
	private StopwatchState state;

	protected void setState(final StopwatchState state) { this.state = state; }

	// forward event listener methods to the current state
	public void onStartStop(final View view) { state.onStartStop(); }
	public void onLapReset(final View view)  { state.onLapReset(); }
	@Override public void onTick()           { state.onTick(); }

	// known states
	private final StopwatchState STOPPED     = new StoppedState(this);
	private final StopwatchState RUNNING     = new RunningState(this);
	private final StopwatchState LAP_RUNNING = new LapRunningState(this);
	private final StopwatchState LAP_STOPPED = new LapStoppedState(this);

	// transitions
	@Override public void toRunningState()    { setState(RUNNING); }
	@Override public void toStoppedState()    { setState(STOPPED); }
	@Override public void toLapRunningState() { setState(LAP_RUNNING); }
	@Override public void toLapStoppedState() { setState(LAP_STOPPED); }

	// actions
	@Override public void actionReset()      { timeModel.resetRuntime(); actionUpdateView(); }
	@Override public void actionStart()      { tickModel.start(); }
	@Override public void actionStop()       { tickModel.stop(); }
	@Override public void actionLap()        { timeModel.setLaptime(); }
	@Override public void actionInc()        { timeModel.incRuntime(); actionUpdateView(); }
	@Override public void actionUpdateView() { state.updateView(); }
}
