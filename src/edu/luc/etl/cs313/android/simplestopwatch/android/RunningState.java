package edu.luc.etl.cs313.android.simplestopwatch.android;

public class RunningState implements StopwatchState {

	public RunningState(final StopwatchAdapter adapter) {
		this.adapter = adapter;
	}

	private final StopwatchAdapter adapter;

	@Override
	public void onStartStop() {
		adapter.actionStop();
		adapter.toStoppedState();
	}

	@Override
	public void onLapReset() {
		adapter.actionLap();
		adapter.toLapRunningState();
	}

	@Override
	public void onTick() {
		adapter.actionInc();
		adapter.toRunningState();
	}

	@Override
	public void updateView() {
		adapter.updateViewRuntime();
	}
}
