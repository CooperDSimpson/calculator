package windows;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;

import core.WindowManager;
import core.logger.Logger;

public class CurrencyWindow extends JFrame{
	public CurrencyWindow()
	{
		Logger.info("Creating CurrencyWindow.");
	
	    Logger.debug("Setting window title.");
	    setTitle("Circle Surface Area");
	
	    Logger.debug("Setting window size to 600x400.");
	    setSize(600, 400);
	
	    Logger.debug("Centering window on screen.");

	    setLocationRelativeTo(WindowManager.getMainWindow());
	
	    Logger.debug("Creating main panel.");
	    JPanel panel = new JPanel(new FlowLayout());
	}
}
