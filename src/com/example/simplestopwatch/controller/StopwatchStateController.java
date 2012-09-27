package com.example.simplestopwatch.controller;

import com.example.simplestopwatch.model.Application;
import com.example.simplestopwatch.view.MainActivity;

import android.os.Handler;

public class StopwatchStateController implements StopwatchController {

	private MainActivity view;
	private Application model;
	private StopwatchState stopwatchState;
	private Handler handler;
	
	public StopwatchStateController(MainActivity view, Application model, Handler handler) {
		this.view = view;
		this.model = model;
		this.handler = handler;
		setStopState();
	}
	
	//
	// stopwatch functions
	public void Reset() {
		model.resetRuntime();
		handler.post(new Runnable() {
			public void run() { view.updateResultsInUi(); }
		});
	}

	public void Run() {
		model.incRuntime();
		handler.post(new Runnable() {
			public void run() { view.updateResultsInUi(); }
		});
	}

	public void Lap() {
		model.incRuntime();
	}
	
    //
    // setState
    //	Sets the current state
    public void setResetState() {
    	this.stopwatchState = new ResetState();
    }
    public void setRunState() {
    	this.stopwatchState = new RunState();
    }
    public void setStopState() {
    	this.stopwatchState = new StopState();
    }
    public void setLapState() {
    	this.stopwatchState = new LapState();
    }

    // Actions
    public void startStopPressed() {
    	stopwatchState.startStopPressed(this);
    }
    
    public void lapResetPressed() {
    	stopwatchState.lapResetPressed(this);
    }
    
    public void action() {
    	stopwatchState.action(this);
    }
    
    // Getters
    public int getRuntime() {
    	return model.getRuntime();
    }
}