package edu.luc.etl.cs313.android.simplestopwatch.model.clock;

import org.junit.After;
import org.junit.Before;

/**
 * Concrete testcase subclass for the default clock model implementation.
 *
 * @author laufer
 * @see http://xunitpatterns.com/Testcase%20Superclass.html
 */
public class DefaultClockModelTest extends AbstractClockModelTest {

	@Before
	public void setUp() throws Exception {
		setModel(new DefaultClockModel());
		getModel().setRunnableScheduler(new DirectExecutor());
	}

	@After
	public void tearDown() throws Exception {
		setModel(null);
	}
}

/**
 * A stub replacement for {@link android.os.Handler}
 * that executes runnable tasks directly. This enables us
 * to test the {@link DefaultClockModel} in isolation.
 */
class DirectExecutor implements RunnableScheduler {
	@Override
	public boolean post(Runnable r) {
		r.run();
		return true;
	}
}