package windows;

import math.Circle;

import javax.swing.*;
import javax.swing.JSeparator;

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
	
	    setLocationRelativeTo(WindowManager.getMainWindow());
	
	    Logger.debug("Creating main panel.");
	    JPanel panel = new JPanel(new FlowLayout());
	    
	    //Output Field Creation
	    Logger.debug("Creating area label");
	    JLabel areaLabel = new JLabel("Area:");
	    JTextField areaField = new JTextField(20);
	    areaField.setEditable(false);
	    
	    JLabel formulaLabel = new JLabel("Formula:");
	    JTextField formulaField = new JTextField(20);
	    formulaField.setEditable(false);
	    
	    //Input Field creation
	    JLabel radiusLabel = new JLabel("Radius:");
	    JTextField radiusField = new JTextField(20);
	    
	    //Calculate Button Creation + Action event to take input and pass to Circle math function
	    JButton calculateButton = new JButton("Calculate");
	    JButton resetButton = new JButton("Reset");
	    
	    calculateButton.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		String input = radiusField.getText();
	    		
	    		try {
	    			Double radius = Double.parseDouble(input);
	    			
	    			String result = Circle.CircleCalc(radius);
	    			
	    			areaField.setText(result);
	    			
	    			String formula = String.format("PI*%f^2=%s", radius, result);
	    			
	    			formulaField.setText(formula);
	    		} catch (NumberFormatException ex) {
	    			areaField.setText("ERROR: Invalid Input");
	    			formulaField.setText("ERROR: Invalid Input");
	    		}
	    	}
	    });
	    
	    resetButton.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		radiusField.setText("");
	    		areaField.setText("");
	    		formulaField.setText("");
	    	}
	    });
	    
	    //Adding everything to panel and frame
	    panel.add(radiusLabel);
	    panel.add(radiusField);
	    panel.add(calculateButton);
	    panel.add(resetButton);
	    panel.add(formulaLabel);
	    panel.add(formulaField);
	    panel.add(areaLabel);
	    panel.add(areaField);
	    
	    this.add(panel);
	}
}
