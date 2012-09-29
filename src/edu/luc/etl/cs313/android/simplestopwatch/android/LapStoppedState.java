package edu.luc.etl.cs313.android.simplestopwatch.android;

public class LapStoppedState implements StopwatchState {

	public LapStoppedState(final StopwatchAdapter adapter) {
		this.adapter = adapter;
	}

	private final StopwatchAdapter adapter;

	@Override
	public void onStartStop() {
		adapter.actionStart();
		adapter.toLapRunningState();
	}

	@Override
	public void onLapReset() {
		adapter.toStoppedState();
		adapter.actionUpdateView();
	}

	@Override
	public void onTick() {
		throw new UnsupportedOperationException("onTick");
	}

	@Override
	public void updateView() {
		adapter.updateViewLaptime();
	}
}
