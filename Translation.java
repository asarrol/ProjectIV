package stopwatch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.SwingUtilities;

/**
 * The controller logic of the stopwatch.
 */
public class Translation implements ActionListener, Constants {

  private final int STOP_RUNTIME_STATE = 0;
  private final int RUN_RUNTIME_STATE = 1;
  private final int RUN_LAPTIME_STATE = 2;
  private final int STOP_LAPTIME_STATE = 3;

  private int theState = STOP_RUNTIME_STATE;
  private Application swa;

  private PropertyChangeSupport listeners = new PropertyChangeSupport(this);

  public void setApplication(Application swa) {
    this.swa = swa;
  }
  
  public void addPropertyChangeListener(PropertyChangeListener l) {
    listeners.addPropertyChangeListener(l);
  }
  
  public void removePropertyChangeListener(PropertyChangeListener l) {
    listeners.removePropertyChangeListener(l);
  }
  
  public void actionPerformed(ActionEvent event) {
    String eventLabel = event.getActionCommand();
    if (eventLabel == null) {
      if (theState == RUN_RUNTIME_STATE) {
        swa.incRuntime();
        fireTime(swa.getRuntime());
      } else if (theState == RUN_LAPTIME_STATE) {
        swa.incRuntime();
      }
    } else if (eventLabel.equals(START)) {
      if (theState == STOP_RUNTIME_STATE) {
        theState = RUN_RUNTIME_STATE;
      } else if (theState == RUN_RUNTIME_STATE) {
        theState = STOP_RUNTIME_STATE;
      } else if (theState == RUN_LAPTIME_STATE) {
        theState = STOP_LAPTIME_STATE;
      } else if (theState == STOP_LAPTIME_STATE) {
        theState = RUN_LAPTIME_STATE;
      }
    } else if (eventLabel.equals(RESET)) {
      if (theState == RUN_RUNTIME_STATE) {
        theState = RUN_LAPTIME_STATE;
      } else if (theState == RUN_LAPTIME_STATE) {
        theState = RUN_RUNTIME_STATE;
      } else if (theState == STOP_RUNTIME_STATE) {
        swa.resetRuntime();
      } else if (theState == STOP_LAPTIME_STATE) {
        theState = STOP_RUNTIME_STATE;
      }
      fireTime(swa.getRuntime());
    }
  }
  
  protected void fireTime(final int time) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        listeners.firePropertyChange(NOW, null, new Integer(time));
      }
    });
  }
}
