package windows;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;

import core.WindowManager;
import core.logger.Logger;

public class MainWindow extends JFrame {

    public MainWindow() {

        Logger.info("Creating MainWindow.");

        Logger.debug("Setting window title.");
        setTitle("Surface Area Calculator");

        Logger.debug("Setting window size to 600x400.");
        setSize(600, 400);

        Logger.debug("Setting default close operation.");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Logger.debug("Centering window on screen.");
        setLocationRelativeTo(null);

        Logger.debug("Creating main panel.");
        JPanel panel = new JPanel(new FlowLayout());

        Logger.debug("Creating buttons.");
        JButton calculateButton = new JButton("Calculate");
        JButton closeButton = new JButton("Close");

        calculateButton.addActionListener(event -> {
            Logger.info("Calculate button clicked.");

            // TODO: Implement surface area calculation.
        });

        closeButton.addActionListener(event -> {
            Logger.info("Close button clicked.");
            Logger.info("Closing MainWindow.");

            dispose();
        });

        Logger.debug("Adding Close button to panel.");
        panel.add(closeButton);

        Logger.debug("Adding Calculate button to panel.");
        panel.add(calculateButton);

        Logger.debug("Adding panel to window.");
        add(panel);

        Logger.info("MainWindow created successfully.");
    }
}