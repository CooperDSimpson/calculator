package windows;

import javax.swing.JButton;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;

import core.WindowManager;
import core.logger.Logger;

public class CylinderWindow extends JFrame{
	public CylinderWindow()
	{
		Logger.info("Creating CylinderWindow.");
	
	    Logger.debug("Setting window title.");
	    setTitle("Cylinder Surface Area");
	
	    Logger.debug("Setting window size to 600x400.");
	    setSize(600, 400);
	
	    Logger.debug("Setting default close operation.");
	
	    Logger.debug("Centering window on screen.");
	    setLocationRelativeTo(null);
	
	    Logger.debug("Creating main panel.");
	    JPanel panel = new JPanel(new FlowLayout());
	    
	    
	}
}
