package com.example.simplestopwatch;

import java.util.Timer;
import java.util.TimerTask;

import com.example.simplestopwatch.R;
import com.example.simplestopwatch.controller.StopwatchStateController;
import com.example.simplestopwatch.model.Application;
import com.example.simplestopwatch.model.Constants;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	private StopwatchStateController adapter;	// adapter that communicates with model
	private Timer timer;	// running background timer
	private Handler handler;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Setup default values
        handler = new Handler();
        adapter = new StopwatchStateController(this, new Application(), handler);
        timer = new Timer();
        
        // Start Timer
        //	The timer runs performAction() every 1000 milliseconds
        timer.schedule(new TimerTask() {
        	public void run() {
        		adapter.action();
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
    	adapter.startStopPressed();
    }
    
    //
    // Rest / Lap button click action
    //
    public void resetLap(View view) {
    	adapter.lapResetPressed();
    }
    
    // updateResultsInUi()
    //	Updates the seconds and minutes in the UI.
    public void updateResultsInUi() {
    	TextView tvS = (TextView) findViewById(R.id.seconds);
    	TextView tvM = (TextView) findViewById(R.id.minutes);
    	int time = adapter.getRuntime();
    	int seconds = time % Constants.SEC_PER_MIN;
    	int minutes = time / Constants.SEC_PER_MIN;
    	
        tvS.setText("" + seconds);
        tvM.setText("" + minutes);
    }
}