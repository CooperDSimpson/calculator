package windows;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;

import core.WindowManager;
import core.logger.Logger;

public class RectPrismWindow extends JFrame{
	public RectPrismWindow()
	{
		Logger.info("Creating RectPrismWindow.");
	
	    Logger.debug("Setting window title.");
	    setTitle("Rectangular Prism Surface Area");
	
	    Logger.debug("Setting window size to 600x400.");
	    setSize(600, 400);
	
	    Logger.debug("Setting default close operation.");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	    Logger.debug("Centering window on screen.");
	    setLocationRelativeTo(null);
	
	    Logger.debug("Creating main panel.");
	    JPanel panel = new JPanel(new FlowLayout());
	}
}
