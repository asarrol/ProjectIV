package edu.luc.etl.cs313.android.simplestopwatch.android;

public class LapRunningState implements StopwatchState {

	public LapRunningState(final StopwatchAdapter adapter) {
		this.adapter = adapter;
	}

	private final StopwatchAdapter adapter;

	@Override
	public void onStartStop() {
		adapter.actionStop();
		adapter.toLapStoppedState();
	}

	@Override
	public void onLapReset() {
		adapter.toRunningState();
		adapter.actionUpdateView();
	}

	@Override
	public void onTick() {
		adapter.actionInc();
		adapter.toLapRunningState();
	}

	@Override
	public void updateView() {
		adapter.updateViewLaptime();
	}
}
