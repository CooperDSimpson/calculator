package windows;

import javax.swing.*;
import java.awt.*;

import java.util.LinkedHashMap;
import java.util.Map;

import core.logger.Logger;

public class MainWindow extends JFrame {

    public MainWindow() {

        Logger.info("Creating MainWindow.");

        setTitle("Surface Area Calculator");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // ==================== MAIN PANEL ====================

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        
        // ==================== MAIN TITLE ====================

        JLabel mainTitle = new JLabel(
            "2D and 3D Shapes Surface Area Calculator Menu",
            SwingConstants.CENTER
        );

        mainTitle.setFont(new Font("Arial", Font.BOLD, 18));

        panel.add(mainTitle, BorderLayout.NORTH);

        // ==================== SHAPES PANEL ====================

        JPanel shapesPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        // ==================== 2D SHAPES ====================

        JPanel twoDPanel = new JPanel(new BorderLayout(5, 10));
        twoDPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        JLabel twoDTitle = new JLabel("2D Shapes", SwingConstants.CENTER);
        twoDTitle.setFont(new Font("Arial", Font.BOLD, 16));

        JPanel twoDButtonsPanel = new JPanel();
        twoDButtonsPanel.setLayout(new BoxLayout(twoDButtonsPanel, BoxLayout.Y_AXIS));
        twoDButtonsPanel.setBorder(
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        JButton circleButton = new JButton("Circle");
        JButton triangleButton = new JButton("Triangle");
        JButton squareButton = new JButton("Square");

        JButton[] twoDButtons = {
            circleButton,
            triangleButton,
            squareButton
        };

        for (JButton button : twoDButtons) {
            button.setPreferredSize(new Dimension(150, 30));
            button.setMinimumSize(new Dimension(150, 30));
            button.setMaximumSize(new Dimension(150, 30));
            button.setAlignmentX(Component.CENTER_ALIGNMENT);

            twoDButtonsPanel.add(button);
            twoDButtonsPanel.add(Box.createVerticalStrut(8));
        }

        twoDButtonsPanel.add(Box.createVerticalGlue());

        twoDPanel.add(twoDTitle, BorderLayout.NORTH);
        twoDPanel.add(twoDButtonsPanel, BorderLayout.CENTER);

        // ==================== 3D SHAPES ====================

        JPanel threeDPanel = new JPanel(new BorderLayout(5, 10));
        threeDPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        JLabel threeDTitle = new JLabel("3D Shapes", SwingConstants.CENTER);
        threeDTitle.setFont(new Font("Arial", Font.BOLD, 16));

        JPanel threeDButtonsPanel = new JPanel();
        threeDButtonsPanel.setLayout(new BoxLayout(threeDButtonsPanel, BoxLayout.Y_AXIS));
        threeDButtonsPanel.setBorder(
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        JButton cubeButton = new JButton("Cube");
        JButton rectangularPrismButton = new JButton("Rectangular Prism");
        JButton cylinderButton = new JButton("Cylinder");

        JButton[] threeDButtons = {
            cubeButton,
            rectangularPrismButton,
            cylinderButton
        };

        for (JButton button : threeDButtons) {
            button.setPreferredSize(new Dimension(150, 30));
            button.setMinimumSize(new Dimension(150, 30));
            button.setMaximumSize(new Dimension(150, 30));
            button.setAlignmentX(Component.CENTER_ALIGNMENT);

            threeDButtonsPanel.add(button);
            threeDButtonsPanel.add(Box.createVerticalStrut(8));
        }

        threeDButtonsPanel.add(Box.createVerticalGlue());

        threeDPanel.add(threeDTitle, BorderLayout.NORTH);
        threeDPanel.add(threeDButtonsPanel, BorderLayout.CENTER);

        shapesPanel.add(twoDPanel);
        shapesPanel.add(threeDPanel);

        panel.add(shapesPanel, BorderLayout.CENTER);

        // ==================== CONVERSIONS PANEL ====================

        JPanel conversionsSection = new JPanel(new BorderLayout(5, 5));

        JLabel conversionsTitle = new JLabel(
            "Conversions Calculator",
            SwingConstants.CENTER
        );

        conversionsTitle.setFont(new Font("Arial", Font.BOLD, 18));

        JPanel conversionsPanel = new JPanel();
        conversionsPanel.setLayout(
            new BoxLayout(conversionsPanel, BoxLayout.Y_AXIS)
        );

        conversionsPanel.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
            )
        );

        JButton volumeButton = new JButton("Volume");
        JButton temperatureButton = new JButton("Temperature");
        JButton currencyButton = new JButton("Currency");
        JButton timeButton = new JButton("Time");

        JButton[] conversionButtons = {
            volumeButton,
            temperatureButton,
            currencyButton,
            timeButton
        };

        for (JButton button : conversionButtons) {
            button.setPreferredSize(new Dimension(150, 30));
            button.setMinimumSize(new Dimension(150, 30));
            button.setMaximumSize(new Dimension(150, 30));
            button.setAlignmentX(Component.CENTER_ALIGNMENT);

            conversionsPanel.add(button);
            conversionsPanel.add(Box.createVerticalStrut(8));
        }

        conversionsPanel.add(Box.createVerticalGlue());

        conversionsSection.add(conversionsTitle, BorderLayout.NORTH);
        conversionsSection.add(conversionsPanel, BorderLayout.CENTER);

        panel.add(conversionsSection, BorderLayout.SOUTH);

        // ==================== ADD MAIN PANEL ====================

        add(panel);

        Logger.info("MainWindow created successfully.");
    }
}