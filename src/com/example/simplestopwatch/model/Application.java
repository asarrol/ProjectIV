package com.example.simplestopwatch.model;

import static com.example.simplestopwatch.model.Constants.*;

/**
 * The passive (dumb) data model of the stopwatch.
 */
public class Application {

	private int secVal = 0;

	public void resetRuntime(){
		secVal = 0;
	}

	public void incRuntime(){
		secVal = (secVal + SEC_PER_TICK) % SEC_PER_HOUR;
	}

	public int getRuntime() {
		return secVal;
	}
}