package edu.luc.etl.cs313.android.simplestopwatch.android;

import edu.luc.etl.cs313.android.simplestopwatch.android.StopwatchAdapter;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import android.util.Log;

/**
 * Concrete Robolectric test subclass.
 *
 * @author laufer
 * @see http://pivotal.github.com/robolectric
 */
@Ignore
@RunWith(RobolectricTestRunner.class)
public class StopwatchActivityRobolectric extends AbstractStopwatchActivityTest {

	private static String TAG = "stopwatch-android-activity-robolectric";

	private StopwatchAdapter activity;

	@Before
	public void setUp() {
		activity = Robolectric.buildActivity(StopwatchAdapter.class).create().start().get();
		Log.d(TAG, "setting up test...");
	}

	@Override
	protected StopwatchAdapter getActivity() {
		return activity;
	}
}
