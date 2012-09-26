package stopwatch;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 * The driver for the stopwatch.
 */
public class Main extends JPanel implements Constants {

  Timer timer = null;

  public Main() {
    Translation translation = new Translation();
    translation.setApplication(new Application());
    timer = new Timer(1000, translation);
    Presentation visibleInterface = new Presentation();
    visibleInterface.addActionListener(translation);
    translation.addPropertyChangeListener(visibleInterface);
    this.add(visibleInterface);
  }


  public static void main(String args[]) {
	  // create a frame around the applet
    JFrame frame = new JFrame("Stop Watch Demo");
    Main theInterface = new Main();

    // invoke the applet's lifecycle methods manually
    frame.getContentPane().add(theInterface);
    // bring the close button to life
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    theInterface.timer.start();

    frame.pack();
    frame.setVisible(true);
  } // end main.
}