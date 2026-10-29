package windows;

import javax.swing.JButton;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.WindowManager;
import core.logger.Logger;
import math.Cylinder;

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
	    
<<<<<<< HEAD
	    //Output Field Creation
	    JLabel outputLabel = new JLabel("Surface Area:");
	    JTextField outputField = new JTextField(20);
	    outputField.setEditable(false);
	    
	    //Radius Input Field creation
	    JLabel radiusLabel = new JLabel("Radius:");
	    JTextField radiusField = new JTextField(20);
	    
	    //Height Input Field creation
	    JLabel heightLabel = new JLabel("Height:");
	    JTextField heightField = new JTextField(20);
	    
	    //Calculate Button Creation + Action event to take input and pass to Cylinder math function
	    JButton calculateButton = new JButton("Calculate");
	    
	    calculateButton.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		String radInput = radiusField.getText();
	    		String heightInput = heightField.getText();
	    		
	    		try {
	    			Double radius = Double.parseDouble(radInput);
	    			Double height = Double.parseDouble(heightInput);
	    			
	    			String result = Cylinder.cylinderCalc(radius, height);
	    			
	    			outputField.setText(result);
	    		} catch (NumberFormatException ex) {
	    			outputField.setText("ERROR: Invalid Input");
	    		}
	    	}
	    });
	    
	    //Adding everything to panel and frame
	    panel.add(radiusLabel);
	    panel.add(radiusField);
	    panel.add(heightLabel);
	    panel.add(heightField);
	    panel.add(calculateButton);
	    panel.add(outputLabel);
	    panel.add(outputField);
	    
	    this.add(panel);
=======
	    
>>>>>>> refs/remotes/origin/master
	}
}
