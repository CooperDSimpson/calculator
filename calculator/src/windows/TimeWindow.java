package windows;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;

import core.WindowManager;
import core.logger.Logger;

public class TimeWindow extends JFrame{
	public TimeWindow()
	{
		Logger.info("Creating TimeWindow.");
	
	    Logger.debug("Setting window title.");
	    setTitle("Time Conversion");
	
	    Logger.debug("Setting window size to 600x400.");
	    setSize(600, 400);

	    setLocationRelativeTo(WindowManager.getMainWindow());
	
	    Logger.debug("Creating main panel.");
	    JPanel panel = new JPanel(new FlowLayout());
	}
}
