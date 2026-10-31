package windows;

import java.awt.FlowLayout;

import javax.swing.*;
import core.WindowManager;
import core.logger.Logger;

public class ProfilerWindow extends JFrame{
	public ProfilerWindow()
	{
		Logger.info("Creating ProfilerWindow.");
	
	    Logger.debug("Setting window title.");
	    setTitle("Profiler");
	
	    Logger.debug("Setting window size to 600x400.");
	    setSize(600, 400);
	

	    setLocationRelativeTo(WindowManager.getMainWindow());
	
	    Logger.debug("Creating main panel.");
	    JPanel panel = new JPanel(new FlowLayout());
	}
}
