package edu.luc.etl.cs313.android.simplestopwatch.android;

public class StoppedState implements StopwatchState {

	public StoppedState(final StopwatchAdapter adapter) {
		this.adapter = adapter;
	}

	private final StopwatchAdapter adapter;

	@Override
	public void onStartStop() {
		adapter.actionStart();
		adapter.toRunningState();
	}

	@Override
	public void onLapReset() {
		adapter.actionReset();
		adapter.toStoppedState();
	}

	@Override
	public void onTick() {
		throw new UnsupportedOperationException("onTick");
	}

	@Override
	public void updateView() {
		adapter.updateViewRuntime();
	}
}
