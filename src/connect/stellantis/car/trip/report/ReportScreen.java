package connect.stellantis.car.trip.report;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicCheckBoxUI;

import java.awt.event.*;

public class ReportScreen extends JFrame {
    private JLabel m_backgroundLabel;
    private JButton m_backButton;

    public ReportScreen(String backgroundPath, String backButtonPath,
        Double batteryVoltageOnTripBegin, Integer odometerOnTripBegin, String DateHourOnTripBegin,
        Double fuelOnTripBegin, Integer oilLevelInTripBegin, Double tirePressureFrontLeftInTripBegin,
        Double tirePressureFrontRightInTripBegin, Double tirePressureBackLeftInTripBegin,
        Double tirePressureBackRightInTripBegin, Double batteryVoltageOnTripEnd, Integer odometerOnTripEnd,
        String DateHourOnTripEnd, Double fuelOnTripEnd, Integer oilLevelInTripEnd,
        Double tirePressureFrontLeftInTripEnd, Double tirePressureFrontRightInTripEnd,
        Double tirePressureBackLeftInTripEnd, Double tirePressureBackRightInTripEnd) {
        configureScreen();
        loadElements(backgroundPath, backButtonPath);
    }

    public JButton getBackButton() {
        return m_backButton;
    }

    private void configureScreen() {
        setSize(1080, 641);
        setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
    }

    private void loadElements(String backgroundPath, String backButtonPath) {
        m_backgroundLabel = new JLabel(new ImageIcon(backgroundPath));
        m_backButton = new JButton(new ImageIcon(backButtonPath));
        addElements();
        configureElementsLayout();
    }

    private void addElements() {
        add(m_backgroundLabel);
        m_backgroundLabel.add(m_backButton);
    }

    private void configureElementsLayout() {
        m_backgroundLabel.setLayout(null);
        m_backButton.setLayout(null);
        configureElementsBounds();
        configureElementsOpacity();
    }

    private void configureElementsBounds() {
        m_backgroundLabel.setBounds(0, 0, getSize().width, getSize().height);
        m_backButton.setBounds(getInsets().left + 30, getInsets().top + 30, 90, 90);
    }

    private void configureElementsOpacity() {
        m_backButton.setContentAreaFilled(false);
    }
}

