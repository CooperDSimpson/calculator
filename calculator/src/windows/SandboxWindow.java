//sandbox for messing around with things.

package windows;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import core.WindowManager;
import core.logger.Logger;

public class SandboxWindow extends JFrame{
	public SandboxWindow()
	{
		Logger.info("Creating Sandbox Window.");
	
	    Logger.debug("Setting window title.");
	    setTitle("Sandbox");
	
	    Logger.debug("Setting window size to 600x400.");
	    setSize(600, 400);
	
	    Logger.debug("Setting default close operation.");
	    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	    Logger.debug("Centering window on screen.");
	    setLocationRelativeTo(null);
	
	    Logger.debug("Creating main panel.");
	    JPanel panel = new JPanel(new FlowLayout());
	    
	    JButton button = new JButton("Calculate");

	    // Colors
	    button.setBackground(Color.BLACK);
		button.setForeground(Color.WHITE);
	
		// Font
		button.setFont(new Font("JetBrains Mono", Font.BOLD, 14));
	
		// Border
		button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
	
		// Other properties
		button.setFocusPainted(false);
		button.setOpaque(true);
		button.setContentAreaFilled(true);
		
		panel.add(button);
		
		add(panel);
	}
}

