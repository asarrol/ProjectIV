package edu.luc.etl.cs313.android.simplestopwatch.android;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;
import edu.luc.etl.cs313.android.simplestopwatch.R;
import static edu.luc.etl.cs313.android.simplestopwatch.model.time.Constants.SEC_PER_MIN;

/**
 * GUI-level test of several essential click-counter scenarios.
 *
 * @author laufer
 * @see http://developer.android.com/tools/testing/activity_testing.html
 */
public class StopwatchActivityTest extends ActivityInstrumentationTestCase2<StopwatchAdapter> {

	/**
	 * Creates an {@link ActivityInstrumentationTestCase2} for the
	 * {@link SkeletonActivity} activity.
	 */
	public StopwatchActivityTest() {
		super(StopwatchAdapter.class);
	}

	/**
	 * Verifies that the activity under test can be launched.
	 */
	public void testActivityTestCaseSetUpProperly() {
		assertNotNull("activity should be launched successfully", getActivity());
	}

	public void testActivityScenarioRun() throws Throwable {
		getActivity().runOnUiThread(new Runnable() { @Override public void run() {
			assertEquals(0, getDisplayedValue());
			assertTrue(getStartStopButton().performClick());
		}});
		Thread.sleep(5500); // <-- do run this in the UI thread!
		getActivity().runOnUiThread(new Runnable() { @Override public void run() {
			assertEquals(5, getDisplayedValue());
			assertTrue(getStartStopButton().performClick());
		}});
	}

	public void testActivityScenarioRunLapReset() throws Throwable {
		getActivity().runOnUiThread(new Runnable() { @Override public void run() {
			assertEquals(0, getDisplayedValue());
			assertTrue(getStartStopButton().performClick());
		}});
		Thread.sleep(5500); // <-- do run this in the UI thread!
		getActivity().runOnUiThread(new Runnable() { @Override public void run() {
			assertEquals(5, getDisplayedValue());
			assertTrue(getResetLapButton().performClick());
		}});
		Thread.sleep(4000); // <-- do run this in the UI thread!
		getActivity().runOnUiThread(new Runnable() { @Override public void run() {
			assertEquals(5, getDisplayedValue());
			assertTrue(getStartStopButton().performClick());
		}});
		getActivity().runOnUiThread(new Runnable() { @Override public void run() {
			assertEquals(5, getDisplayedValue());
			assertTrue(getResetLapButton().performClick());
		}});
		getActivity().runOnUiThread(new Runnable() { @Override public void run() {
			assertEquals(9, getDisplayedValue());
			assertTrue(getResetLapButton().performClick());
		}});
		getActivity().runOnUiThread(new Runnable() { @Override public void run() {
			assertEquals(0, getDisplayedValue());
			assertTrue(getResetLapButton().performClick());
		}});
	}

	// auxiliary methods for easy access to UI widgets

	protected int tvToInt(final TextView t) {
		return Integer.parseInt(t.getText().toString().trim());
	}

	protected int getDisplayedValue() {
		final TextView ts = (TextView) getActivity().findViewById(R.id.seconds);
		final TextView tm = (TextView) getActivity().findViewById(R.id.minutes);
		return SEC_PER_MIN * tvToInt(tm) + tvToInt(ts);
	}

	protected Button getStartStopButton() {
		return (Button) getActivity().findViewById(R.id.startStop);
	}

	protected Button getResetLapButton() {
		return (Button) getActivity().findViewById(R.id.resetLap);
	}
}
