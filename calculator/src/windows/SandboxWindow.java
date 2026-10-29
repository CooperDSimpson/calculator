// Sandbox for experimenting with Swing components.

package windows;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

import core.WindowManager;
import core.logger.Logger;

public class SandboxWindow extends JFrame {

    // Main window
    public SandboxWindow() {

        Logger.info("Creating Sandbox Window.");

        setTitle("Sandbox");
        setSize(800, 700);
	    setLocationRelativeTo(WindowManager.getMainWindow());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Main container
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        mainPanel.setBackground(new Color(35, 35, 35));

        // Scroll container
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setBorder(null);

        // =====================================================
        // DEMO 1 - BUTTONS
        // =====================================================

        JPanel buttonPanel = createDemoPanel("1. Buttons");

        JButton normalButton = new JButton("Normal");
        JButton darkButton = new JButton("Dark");
        JButton borderedButton = new JButton("Bordered");

        darkButton.setBackground(Color.BLACK);
        darkButton.setForeground(Color.WHITE);
        darkButton.setOpaque(true);
        darkButton.setFocusPainted(false);

        borderedButton.setBorder(
            BorderFactory.createLineBorder(Color.WHITE, 2)
        );

        buttonPanel.add(normalButton);
        buttonPanel.add(darkButton);
        buttonPanel.add(borderedButton);

        // =====================================================
        // DEMO 2 - TEXT FIELDS
        // =====================================================

        JPanel textPanel = createDemoPanel("2. Text Fields");

        JTextField textField = new JTextField("Editable text", 15);
        JPasswordField passwordField = new JPasswordField("password", 15);

        JLabel textLabel = new JLabel("Regular text display");

        textPanel.add(textField);
        textPanel.add(passwordField);
        textPanel.add(textLabel);

        // =====================================================
        // DEMO 3 - CHECKBOXES
        // =====================================================

        JPanel checkboxPanel = createDemoPanel("3. Checkboxes");

        JCheckBox check1 = new JCheckBox("Option 1");
        JCheckBox check2 = new JCheckBox("Option 2");
        JCheckBox check3 = new JCheckBox("Option 3");

        checkboxPanel.add(check1);
        checkboxPanel.add(check2);
        checkboxPanel.add(check3);

        // =====================================================
        // DEMO 4 - RADIO BUTTONS
        // =====================================================

        JPanel radioPanel = createDemoPanel("4. Radio Buttons");

        JRadioButton radio1 = new JRadioButton("Small");
        JRadioButton radio2 = new JRadioButton("Medium");
        JRadioButton radio3 = new JRadioButton("Large");

        ButtonGroup radioGroup = new ButtonGroup();

        radioGroup.add(radio1);
        radioGroup.add(radio2);
        radioGroup.add(radio3);

        radioPanel.add(radio1);
        radioPanel.add(radio2);
        radioPanel.add(radio3);

        // =====================================================
        // DEMO 5 - SLIDER
        // =====================================================

        JPanel sliderPanel = createDemoPanel("5. Slider");

        JSlider slider = new JSlider(0, 100, 50);

        slider.setMajorTickSpacing(25);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        JLabel sliderValue = new JLabel("Value: 50");

        slider.addChangeListener(e ->
            sliderValue.setText("Value: " + slider.getValue())
        );

        sliderPanel.add(slider);
        sliderPanel.add(sliderValue);

        // =====================================================
        // DEMO 6 - PROGRESS BAR
        // =====================================================

        JPanel progressPanel = createDemoPanel("6. Progress Bar");

        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(65);
        progressBar.setStringPainted(true);

        progressPanel.add(progressBar);

        // =====================================================
        // DEMO 7 - COMBO BOX
        // =====================================================

        JPanel comboPanel = createDemoPanel("7. Combo Box");

        String[] options = {
            "Java",
            "C++",
            "Python",
            "Rust",
            "JavaScript"
        };

        JComboBox<String> comboBox = new JComboBox<>(options);

        JLabel selectedLanguage = new JLabel("Selected: Java");

        comboBox.addActionListener(e ->
            selectedLanguage.setText(
                "Selected: " + comboBox.getSelectedItem()
            )
        );

        comboPanel.add(comboBox);
        comboPanel.add(selectedLanguage);

        // =====================================================
        // DEMO 8 - TOGGLE BUTTON
        // =====================================================

        JPanel togglePanel = createDemoPanel("8. Toggle Button");

        JToggleButton toggleButton = new JToggleButton("OFF");

        toggleButton.addActionListener(e -> {
            toggleButton.setText(
                toggleButton.isSelected() ? "ON" : "OFF"
            );
        });

        togglePanel.add(toggleButton);

        // =====================================================
        // DEMO 9 - COLORS
        // =====================================================

        JPanel colorPanel = createDemoPanel("9. Colors");

        Color[] colors = {
            Color.RED,
            Color.GREEN,
            Color.BLUE,
            Color.ORANGE,
            Color.MAGENTA,
            Color.CYAN
        };

        for (Color color : colors) {

            JPanel colorBox = new JPanel();

            colorBox.setPreferredSize(new Dimension(55, 55));
            colorBox.setBackground(color);
            colorBox.setBorder(
                BorderFactory.createLineBorder(Color.WHITE)
            );

            colorPanel.add(colorBox);
        }

        // =====================================================
        // DEMO 10 - BORDERS
        // =====================================================

        JPanel borderPanel = createDemoPanel("10. Borders");

        Border[] borders = {
            BorderFactory.createLineBorder(Color.BLACK, 2),
            BorderFactory.createEtchedBorder(),
            BorderFactory.createRaisedBevelBorder(),
            BorderFactory.createLoweredBevelBorder()
        };

        String[] borderNames = {
            "Line",
            "Etched",
            "Raised",
            "Lowered"
        };

        for (int i = 0; i < borders.length; i++) {

            JLabel label = new JLabel(borderNames[i]);

            label.setBorder(
                BorderFactory.createCompoundBorder(
                    borders[i],
                    BorderFactory.createEmptyBorder(10, 15, 10, 15)
                )
            );

            borderPanel.add(label);
        }

        // =====================================================
        // DEMO 11 - COUNTER
        // =====================================================

        JPanel counterPanel = createDemoPanel("11. Interactive Counter");

        JButton decreaseButton = new JButton("-");
        JButton increaseButton = new JButton("+");

        JLabel counterLabel = new JLabel("0");

        final int[] counter = {0};

        increaseButton.addActionListener(e -> {
            counter[0]++;
            counterLabel.setText(String.valueOf(counter[0]));
        });

        decreaseButton.addActionListener(e -> {
            counter[0]--;
            counterLabel.setText(String.valueOf(counter[0]));
        });

        counterPanel.add(decreaseButton);
        counterPanel.add(counterLabel);
        counterPanel.add(increaseButton);

        // =====================================================
        // ADD ALL DEMOS TO MAIN PANEL
        // =====================================================

        mainPanel.add(buttonPanel);
        mainPanel.add(Box.createVerticalStrut(10));

        mainPanel.add(textPanel);
        mainPanel.add(Box.createVerticalStrut(10));

        mainPanel.add(checkboxPanel);
        mainPanel.add(Box.createVerticalStrut(10));

        mainPanel.add(radioPanel);
        mainPanel.add(Box.createVerticalStrut(10));

        mainPanel.add(sliderPanel);
        mainPanel.add(Box.createVerticalStrut(10));

        mainPanel.add(progressPanel);
        mainPanel.add(Box.createVerticalStrut(10));

        mainPanel.add(comboPanel);
        mainPanel.add(Box.createVerticalStrut(10));

        mainPanel.add(togglePanel);
        mainPanel.add(Box.createVerticalStrut(10));

        mainPanel.add(colorPanel);
        mainPanel.add(Box.createVerticalStrut(10));

        mainPanel.add(borderPanel);
        mainPanel.add(Box.createVerticalStrut(10));

        mainPanel.add(counterPanel);

        add(scrollPane);
    }

    // =====================================================
    // DEMO PANEL FACTORY
    // Creates a titled container for each demo.
    // =====================================================

    private JPanel createDemoPanel(String title) {

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 15));

        panel.setBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                title
            )
        );

        panel.setBackground(new Color(230, 230, 230));

        panel.setAlignmentX(Component.LEFT_ALIGNMENT);

        return panel;
    }
}