package com.example.simplestopwatch;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	private StopwatchState stopwatchState;	// current state of the stopwatch
	private Timer timer;					// running background timer
	private Application app;				// stopwatch data
	
	// Need handler for callbacks to the UI thread
    private final Handler handler = new Handler();
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Setup default values
        app = new Application();
        timer = new Timer();
        setState(new StopState());
        
        // Start Timer
        //	The timer runs performAction() every 1000 milliseconds
        timer.schedule(new TimerTask() {
        	public void run() {
        		performAction();
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
    	// Figure out what action the user is trying to signal.
    	if (stopwatchState instanceof RunState)
    		stopwatchState = new StopState();
    	else
    		stopwatchState = new RunState();
    }
    
    //
    // Rest / Lap button click action
    //
    public void resetLap(View view) {
    	// Figure out what action the user is trying to signal.
    	if (stopwatchState instanceof LapState) {
    		stopwatchState = new ResetState();
    		performAction();	// Gets immediate action for user to see.
    	}
    	else
    		stopwatchState = new LapState();
    }
    
    //
    // setState
    //	Sets the current state in the context.
    public void setState(StopwatchState state) {
    	this.stopwatchState = state;
    }
    // performAction
    // Performs the action by the current state.
    public void performAction() {
    	this.stopwatchState.performAction(this, app, handler);
    }
    
    //
    // Create runnable for posting back to the UI thread.
    //	NOTE: I'm not sure this is being done properly.
    public final Runnable updateResults = new Runnable() {
        public void run() {
            updateResultsInUi();
        }
    };
    // updateResultsInUi()
    //	Updates the seconds and minutes in the UI.
    private void updateResultsInUi() {
    	TextView tvS = (TextView) findViewById(R.id.seconds);
    	TextView tvM = (TextView) findViewById(R.id.minutes);
    	int time = app.getRuntime();
    	int seconds = time % Constants.SEC_PER_MIN;
    	int minutes = time / Constants.SEC_PER_MIN;
    	
        tvS.setText("" + seconds);
        tvM.setText("" + minutes);
    }
}