package windows;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.WindowManager;
import core.logger.Logger;
import math.Circle;
import math.Cube;

public class CubeWindow extends JFrame{
	public CubeWindow()
	{
		Logger.info("Creating CubeWindow.");
	
	    Logger.debug("Setting window title.");
	    setTitle("Cube Surface Area");
	
	    Logger.debug("Setting window size to 600x400.");
	    setSize(600, 400);
	
	    Logger.debug("Setting default close operation.");
	    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	    Logger.debug("Centering window on screen.");
	    setLocationRelativeTo(null);
	
	    Logger.debug("Creating main panel.");
	    JPanel panel = new JPanel(new FlowLayout());
	    
	    //Output Field Creation
	    JLabel outputLabel = new JLabel("Surface Area:");
	    JTextField outputField = new JTextField(20);
	    outputField.setEditable(false);
	    
	    //Input Field creation
	    JLabel lengthLabel = new JLabel("Side Length:");
	    JTextField lengthField = new JTextField(20);
	    
	    //Calculate Button Creation + Action event to take input and pass to Cube math function
	    JButton calculateButton = new JButton("Calculate");
	    
	    calculateButton.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		String input = lengthField.getText();
	    		
	    		try {
	    			Double len = Double.parseDouble(input);
	    			
	    			String result = Cube.cubeCalc(len);
	    			
	    			outputField.setText(result);
	    		} catch (NumberFormatException ex) {
	    			outputField.setText("ERROR: Invalid Input");
	    		}
	    	}
	    });
	    
	    //Adding everything to panel and frame
	    panel.add(lengthLabel);
	    panel.add(lengthField);
	    panel.add(calculateButton);
	    panel.add(outputLabel);
	    panel.add(outputField);
	    
	    this.add(panel);
	}
}
