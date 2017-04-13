package edu.luc.etl.cs313.android.simplestopwatch.test.model.state;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.luc.etl.cs313.android.simplestopwatch.R;
import edu.luc.etl.cs313.android.simplestopwatch.common.StopwatchUIUpdateListener;
import edu.luc.etl.cs313.android.simplestopwatch.model.clock.ClockModel;
import edu.luc.etl.cs313.android.simplestopwatch.model.clock.OnTickListener;
import edu.luc.etl.cs313.android.simplestopwatch.model.state.StopwatchStateMachine;
import edu.luc.etl.cs313.android.simplestopwatch.model.time.TimeModel;

/**
 * Testcase superclass for the stopwatch state machine model. Unit-tests the state
 * machine in fast-forward mode by directly triggering successive tick events
 * without the presence of a pseudo-real-time clock. Uses a single unified mock
 * object for all dependencies of the state machine model.
 *
 * @author laufer
 * @see http://xunitpatterns.com/Testcase%20Superclass.html
 */
public abstract class AbstractStopwatchStateMachineTest {

    private StopwatchStateMachine model;

    private UnifiedMockDependency dependency;

    @Before
    public void setUp() throws Exception {
        dependency = new UnifiedMockDependency();
    }

    @After
    public void tearDown() {
        dependency = null;
    }

    /**
     * Setter for dependency injection. Usually invoked by concrete testcase
     * subclass.
     *
     * @param model
     */
    protected void setModel(final StopwatchStateMachine model) {
        this.model = model;
        if (model == null)
            return;
        this.model.setUIUpdateListener(dependency);
        this.model.actionInit();
    }

    protected UnifiedMockDependency getDependency() {
        return dependency;
    }

    /**
     * Verifies that we're initially in the stopped state (and told the listener
     * about it).
     */
    @Test
    public void testPreconditions() {
        assertEquals(R.string.STOPPED, dependency.getState());
    }

    /**
     * Verifies the following scenario: time is 0, press start, wait 5+ seconds,
     * expect time 5.
     */
    @Test
    public void testScenarioRun() {
        assertTimeEquals(0);
        // directly invoke the button press event handler methods
        model.onStartStop();
        onTickRepeat(5);
        assertTimeEquals(5);
    }

    /**
     * Verifies the following scenario: time is 0, press start, wait 5+ seconds,
     * expect time 5, press lap, wait 4 seconds, expect time 5, press start,
     * expect time 5, press lap, expect time 9, press lap, expect time 0.
     *
     * @throws Throwable
     */
    /*
    @Test
    public void testScenarioRunLapReset() {
        assertTimeEquals(0);
        // directly invoke the button press event handler methods
        model.onStartStop();
        assertEquals(R.string.RUNNING, dependency.getState());
        assertTrue(dependency.isStarted());
        onTickRepeat(5);
        assertTimeEquals(5);
        model.onLapReset();
        assertEquals(R.string.LAP_RUNNING, dependency.getState());
        assertTrue(dependency.isStarted());
        onTickRepeat(4);
        assertTimeEquals(5);
        model.onStartStop();
        assertEquals(R.string.LAP_STOPPED, dependency.getState());
        assertFalse(dependency.isStarted());
        assertTimeEquals(5);
        model.onLapReset();
        assertEquals(R.string.STOPPED, dependency.getState());
        assertFalse(dependency.isStarted());
        assertTimeEquals(9);
        model.onLapReset();
        assertEquals(R.string.STOPPED, dependency.getState());
        assertFalse(dependency.isStarted());
        assertTimeEquals(0);
    }
    */

    /**
     * Sends the given number of tick events to the model.
     *
     *  @param n the number of tick events
     */
    protected void onTickRepeat(final int n) {
        for (int i = 0; i < n; i++)
            model.onTick();
    }

    /**
     * Checks whether the model has invoked the expected time-keeping
     * methods on the mock object.
     */
    protected void assertTimeEquals(final int t) {
        assertEquals(t, dependency.getTime());
    }
}

/**
 * Manually implemented mock object that unifies the three dependencies of the
 * stopwatch state machine model. The three dependencies correspond to the three
 * interfaces this mock object implements.
 *
 * @author laufer
 */
class UnifiedMockDependency implements TimeModel, ClockModel, StopwatchUIUpdateListener {

    private int timeValue = -1, stateId = -1;

    private int runningTime = 0, lapTime = -1;

    private int incrementTime = 0;

    private boolean started = false;

    public int getTime() {
        return timeValue;
    }

    public int getState() {
        return stateId;
    }

    public boolean isStarted() {
        return started;
    }

    @Override
    public void updateTime(final int timeValue) {
        this.timeValue = timeValue;
    }

    @Override
    public void updateState(final int stateId) {
        this.stateId = stateId;
    }

    @Override
    public void setOnTickListener(OnTickListener listener) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void start() {
        started = true;
    }

    @Override
    public void stop() {
        started = false;
    }

    @Override
    public void resetRuntime() {
        runningTime = 0;
    }

    @Override
    public void incRuntime() {
        runningTime++;
    }

    @Override
    public int getRuntime() {
        return runningTime;
    }

    @Override
    public int getLaptime() {
        return lapTime;
    }

    @Override
    public void decIncrementTime() { incrementTime--; }

    @Override
    public int getIncrementTime() { return incrementTime; }

    @Override
    public void setIncrementTime() { incrementTime++; }
}
