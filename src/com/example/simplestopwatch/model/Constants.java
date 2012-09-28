package com.example.simplestopwatch.model;

/**
 * Event labels for the stopwatch.
 */
public final class Constants {

    // misc constants
    public static final int SEC_PER_TICK  = 1;
    public static final int SEC_PER_MIN   = 60;
    public static final int SEC_PER_HOUR  = 3600;
    
    /**
    The caller references the constants using <tt>Consts.EMPTY_STRING</tt>, 
    and so on. Thus, the caller should be prevented from constructing objects of 
    this class, by declaring this private constructor.
    Source: http://www.javapractices.com/topic/TopicAction.do?Id=2
   */
   private Constants(){
     //this prevents even the native class from 
     //calling this ctor as well :
     throw new AssertionError();
   }
}