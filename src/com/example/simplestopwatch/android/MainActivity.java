package com.example.simplestopwatch.android;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.example.simplestopwatch.R;
import com.example.simplestopwatch.model.Application;
import com.example.simplestopwatch.model.Constants;

public class MainActivity extends Activity {

	private Application model;
	private StopwatchState stopwatchState;
	private Timer timer;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setStopped();
        
        // Setup default values
        stopwatchState = new Stopped();
        model = new Application();
        timer = new Timer();
        
        // Start timer
        timer.scheduleAtFixedRate(new TimerTask() {
        	public void run() {
        		runOnUiThread(new Runnable() {
        			public void run() {
        				stopwatchState.action(MainActivity.this);
        			}
        		});
        	}
        }, 0, 1000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    //
    // Start / Stop button click action
    //
    public void startStop(View view) {
    	stopwatchState.onStartStop(this);
    }
    
    //
    // Rest / Lap button click action
    //
    public void resetLap(View view) {
    	stopwatchState.onLapReset(this);
    }
    
	//
	// stopwatch functions
	public void actionReset() {
		model.resetRuntime();
		updateResultsInUi();
	}

	public void actionRun() {
		model.incRuntime();
		updateResultsInUi();
	}

	public void actionLap() {
		model.incRuntime();
	}
	
    //
    // setState
    //	Sets the current state
    public void setLapStopped() {
    	this.stopwatchState = new LapStopped();
    }
    public void setRunning() {
    	this.stopwatchState = new Running();
    }
    public void setStopped() {
    	this.stopwatchState = new Stopped();
    }
    public void setLapRunning() {
    	this.stopwatchState = new LapRunning();
    }
    
    // updateResultsInUi()
    //	Updates the seconds and minutes in the UI.
    public void updateResultsInUi() {
    	TextView tvS = (TextView) findViewById(R.id.seconds);
    	TextView tvM = (TextView) findViewById(R.id.minutes);
    	int time = model.getRuntime();
    	int seconds = time % Constants.SEC_PER_MIN;
    	int minutes = time / Constants.SEC_PER_MIN;
    	
        tvS.setText("" + seconds);
        tvM.setText("" + minutes);
    }
}