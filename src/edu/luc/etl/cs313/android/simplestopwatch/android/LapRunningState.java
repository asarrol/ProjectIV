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
		adapter.updateViewRuntime();
	}

	@Override
	public void onTick() {
		adapter.actionIncLap();
		adapter.toLapRunningState();
	}

	@Override
	public void updateView() {
		adapter.updateViewLaptime();
	}
}
