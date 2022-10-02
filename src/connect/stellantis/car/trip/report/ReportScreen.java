package connect.stellantis.car.trip.report;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class ReportScreen extends JFrame {
    private JLabel m_backgroundLabel;
    private JLabel m_tripStartLabel;
    private JLabel m_tripEndLabel;
    private ArrayList<JLabel> m_batteryVoltageLabel;
    private ArrayList<JLabel> m_odometerLabel;
    private ArrayList<JLabel> m_dateHourLabel;
    private ArrayList<JLabel> m_fuelLabel;
    private ArrayList<JLabel> m_oilLevelLabel;
    private ArrayList<JLabel> m_tirePressureFrontLeftLabel;
    private ArrayList<JLabel> m_tirePressureFrontRightLabel;
    private ArrayList<JLabel> m_tirePressureBackLeftLabel;
    private ArrayList<JLabel> m_tirePressureBackRightLabel;
    private JButton m_backButton;

    public ReportScreen(String backgroundPath, String backButtonPath,
        Double batteryVoltageOnTripBegin, Integer odometerOnTripBegin, String dateHourOnTripBegin,
        Double fuelOnTripBegin, Integer oilLevelInTripBegin, Double tirePressureFrontLeftInTripBegin,
        Double tirePressureFrontRightInTripBegin, Double tirePressureBackLeftInTripBegin,
        Double tirePressureBackRightInTripBegin, Double batteryVoltageOnTripEnd, Integer odometerOnTripEnd,
        String DateHourOnTripEnd, Double fuelOnTripEnd, Integer oilLevelInTripEnd,
        Double tirePressureFrontLeftInTripEnd, Double tirePressureFrontRightInTripEnd,
        Double tirePressureBackLeftInTripEnd, Double tirePressureBackRightInTripEnd) {
        configureScreen();
        loadElements(backgroundPath, backButtonPath, batteryVoltageOnTripBegin, odometerOnTripBegin,
        dateHourOnTripBegin, fuelOnTripBegin, oilLevelInTripBegin, tirePressureFrontLeftInTripBegin,
        tirePressureFrontRightInTripBegin, tirePressureBackLeftInTripBegin, tirePressureBackRightInTripBegin,
        batteryVoltageOnTripEnd, odometerOnTripEnd, DateHourOnTripEnd, fuelOnTripEnd, oilLevelInTripEnd,
        tirePressureFrontLeftInTripEnd, tirePressureFrontRightInTripEnd, tirePressureBackLeftInTripEnd,
        tirePressureBackRightInTripEnd);
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

    private void loadElements(String backgroundPath, String backButtonPath,
        Double batteryVoltageOnTripBegin, Integer odometerOnTripBegin, String dateHourOnTripBegin,
        Double fuelOnTripBegin, Integer oilLevelInTripBegin, Double tirePressureFrontLeftInTripBegin,
        Double tirePressureFrontRightInTripBegin, Double tirePressureBackLeftInTripBegin,
        Double tirePressureBackRightInTripBegin, Double batteryVoltageOnTripEnd, Integer odometerOnTripEnd,
        String dateHourOnTripEnd, Double fuelOnTripEnd, Integer oilLevelInTripEnd,
        Double tirePressureFrontLeftInTripEnd, Double tirePressureFrontRightInTripEnd,
        Double tirePressureBackLeftInTripEnd, Double tirePressureBackRightInTripEnd) {
        m_backgroundLabel = new JLabel(new ImageIcon(backgroundPath));
        m_backButton = new JButton(new ImageIcon(backButtonPath));
        m_tripStartLabel = new JLabel("BEGIN");
        m_tripEndLabel = new JLabel("END");
        m_dateHourLabel = loadElementsLabel("Date and Hour:", dateHourOnTripBegin.toString(),dateHourOnTripEnd.toString(), "");
        m_odometerLabel = loadElementsLabel("Vehicle Odometer:", odometerOnTripBegin.toString(), odometerOnTripEnd.toString(), "Km");
        m_fuelLabel = loadElementsLabel("Fuel:", fuelOnTripBegin.toString(), fuelOnTripEnd.toString(), "Liters");
        m_oilLevelLabel = loadElementsLabel("Oil Level:", oilLevelInTripBegin.toString(), oilLevelInTripEnd.toString(), "%");
        m_batteryVoltageLabel = loadElementsLabel("Battery Voltage:", batteryVoltageOnTripBegin.toString(), batteryVoltageOnTripEnd.toString(), "Volts");
        m_tirePressureFrontLeftLabel = loadElementsLabel("Front Left Tire Pressure:", tirePressureFrontLeftInTripBegin.toString(), tirePressureFrontLeftInTripEnd.toString(), "kPa");
        m_tirePressureFrontRightLabel = loadElementsLabel("Front Right Tire Pressure:", tirePressureFrontRightInTripBegin.toString(), tirePressureFrontRightInTripEnd.toString(), "kPa");
        m_tirePressureBackLeftLabel = loadElementsLabel("Back Left Tire Pressure:", tirePressureBackLeftInTripBegin.toString(), tirePressureBackLeftInTripEnd.toString(), "kPa");
        m_tirePressureBackRightLabel = loadElementsLabel("Back Right Tire Pressure:", tirePressureBackRightInTripBegin.toString(), tirePressureBackRightInTripEnd.toString(), "kPa");
        addElements();
        configureElementsLayout();
    }

    private ArrayList<JLabel> loadElementsLabel(String textValue, String beginValue, String endValue, String unit) {
        ArrayList<JLabel> label = new ArrayList<JLabel>(3);
        label.add(new JLabel(textValue));
        label.add(new JLabel(beginValue + " " + unit));
        label.add(new JLabel(endValue + " " + unit));
        return label;
    }

    private void addElements() {
        add(m_backgroundLabel);
        m_backgroundLabel.add(m_tripStartLabel);
        m_backgroundLabel.add(m_tripEndLabel);
        m_backgroundLabel.add(m_backButton);
        addElementsLabel(m_dateHourLabel);
        addElementsLabel(m_odometerLabel);
        addElementsLabel(m_fuelLabel);
        addElementsLabel(m_oilLevelLabel);
        addElementsLabel(m_batteryVoltageLabel);
        addElementsLabel(m_tirePressureFrontLeftLabel);
        addElementsLabel(m_tirePressureFrontRightLabel);
        addElementsLabel(m_tirePressureBackLeftLabel);
        addElementsLabel(m_tirePressureBackRightLabel);
    }

    private void addElementsLabel(ArrayList<JLabel> label) {
        m_backgroundLabel.add(label.get(0));
        m_backgroundLabel.add(label.get(1));
        m_backgroundLabel.add(label.get(2));
    }

    private void configureElementsLayout() {
        m_backgroundLabel.setLayout(null);
        m_backButton.setLayout(null);
        configureElementsText();
        configureElementsBounds();
        configureElementsOpacity();
    }

    private void configureElementsText() {
        m_tripStartLabel.setFont(new Font("Serif", Font.BOLD, 30));
        m_tripStartLabel.setForeground(Color.WHITE);
        m_tripEndLabel.setFont(new Font("Serif", Font.BOLD, 30));
        m_tripEndLabel.setForeground(Color.WHITE);
        configureElementTextLabel(m_dateHourLabel);
        configureElementTextLabel(m_odometerLabel);
        configureElementTextLabel(m_fuelLabel);
        configureElementTextLabel(m_oilLevelLabel);
        configureElementTextLabel(m_batteryVoltageLabel);
        configureElementTextLabel(m_tirePressureFrontLeftLabel);
        configureElementTextLabel(m_tirePressureFrontRightLabel);
        configureElementTextLabel(m_tirePressureBackLeftLabel);
        configureElementTextLabel(m_tirePressureBackRightLabel);
    }

    private void configureElementTextLabel(ArrayList<JLabel> label) {
        label.get(0).setFont(new Font("Serif", Font.BOLD, 20));
        label.get(0).setForeground(Color.WHITE);
        label.get(1).setFont(new Font("Serif", Font.BOLD, 20));
        label.get(1).setForeground(Color.WHITE);
        label.get(2).setFont(new Font("Serif", Font.BOLD, 20));
        label.get(2).setForeground(Color.WHITE);
    }

    private void configureElementsBounds() {
        m_backgroundLabel.setBounds(0, 0, getSize().width, getSize().height);
        m_backButton.setBounds(getInsets().left + 30, getInsets().top + 30, 90, 90);
        m_tripStartLabel.setBounds(getInsets().left + 300, getInsets().top + 100, 700, 50);
        m_tripEndLabel.setBounds(getInsets().left + 600, getInsets().top + 100, 700, 50);
        configureElementsBoundsLabel(m_dateHourLabel, 150);
        configureElementsBoundsLabel(m_odometerLabel, 200);
        configureElementsBoundsLabel(m_fuelLabel, 250);
        configureElementsBoundsLabel(m_oilLevelLabel, 300);
        configureElementsBoundsLabel(m_batteryVoltageLabel, 350);
        configureElementsBoundsLabel(m_tirePressureFrontLeftLabel, 400);
        configureElementsBoundsLabel(m_tirePressureFrontRightLabel, 450);
        configureElementsBoundsLabel(m_tirePressureBackLeftLabel, 500);
        configureElementsBoundsLabel(m_tirePressureBackRightLabel, 550);
    }

    private void configureElementsBoundsLabel(ArrayList<JLabel> label, Integer top) {
        label.get(0).setBounds(getInsets().left + 30, getInsets().top + top, 700, 50);
        label.get(1).setBounds(getInsets().left + 300, getInsets().top + top, 700, 50);
        label.get(2).setBounds(getInsets().left + 600, getInsets().top + top, 700, 50);
    }

    private void configureElementsOpacity() {
        m_backButton.setContentAreaFilled(false);
    }
}

