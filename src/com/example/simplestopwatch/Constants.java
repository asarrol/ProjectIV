package com.example.simplestopwatch;

/**
 * Event labels for the stopwatch.
 */
public interface Constants {

    // misc constants
  
    int SEC_PER_TICK  = 1;
    int SEC_PER_MIN   = 60;
    int SEC_PER_HOUR  = 3600;  

    // incoming events

    
    int STOP = 0;
    int START = 1;
    int RESET = 2;
    int LAP = 3;

    // outgoing events

    String NOW        = "Now";
}