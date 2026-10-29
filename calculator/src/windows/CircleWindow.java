package windows;

import math.Circle;

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.WindowManager;
import core.logger.Logger;

public class CircleWindow extends JFrame{
	public CircleWindow()
	{
		Logger.info("Creating CircleWindow.");
	
	    Logger.debug("Setting window title.");
	    setTitle("Circle Surface Area");
	
	    Logger.debug("Setting window size to 600x400.");
	    setSize(600, 400);
	
	    Logger.debug("Setting default close operation.");
	    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	    Logger.debug("Centering window on screen.");
	    setLocationRelativeTo(null);
	
	    Logger.debug("Creating main panel.");
	    JPanel panel = new JPanel(new FlowLayout());
	    
	    //Output Field Creation
	    JLabel outputLabel = new JLabel("Area:");
	    JTextField outputField = new JTextField(20);
	    outputField.setEditable(false);
	    
	    //Radius Input Field creation
	    JLabel radiusLabel = new JLabel("Radius:");
	    JTextField radiusField = new JTextField(20);
	    
	    //Calculate Button Creation + Action event to take input and pass to Circle math function
	    JButton calculateButton = new JButton("Calculate");
	    
	    calculateButton.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		String input = radiusField.getText();
	    		
	    		try {
	    			Double radius = Double.parseDouble(input);
	    			
	    			String result = Circle.CircleCalc(radius);
	    			
	    			outputField.setText(result);
	    		} catch (NumberFormatException ex) {
	    			outputField.setText("ERROR: Invalid Input");
	    		}
	    	}
	    });
	    
	    //Adding everything to panel and frame
	    panel.add(radiusLabel);
	    panel.add(radiusField);
	    panel.add(calculateButton);
	    panel.add(outputLabel);
	    panel.add(outputField);
	    
	    this.add(panel);
	}
}
