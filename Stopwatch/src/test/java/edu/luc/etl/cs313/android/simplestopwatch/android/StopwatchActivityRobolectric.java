package edu.luc.etl.cs313.android.simplestopwatch.android;

import edu.luc.etl.cs313.android.simplestopwatch.android.StopwatchAdapter;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

/**
 * Concrete Robolectric test subclass.
 *
 * @author laufer
 * @see http://pivotal.github.com/robolectric
 */
@RunWith(RobolectricTestRunner.class)
public class StopwatchActivityRobolectric extends AbstractStopwatchActivityTest {

	private static String TAG = "stopwatch-android-activity-robolectric";

	private StopwatchAdapter activity;

	@Before
	public void setUp() {
		activity = Robolectric.buildActivity(StopwatchAdapter.class).create().start().visible().get();
	}

	@Override
	protected StopwatchAdapter getActivity() {
		return activity;
	}

    @Override
    protected void runUiThreadTasks() {
        // Robolectric requires us to run the scheduled tasks explicitly!
        Robolectric.runUiThreadTasks();
    }
}
