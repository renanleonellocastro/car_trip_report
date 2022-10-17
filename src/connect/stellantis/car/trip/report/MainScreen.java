package connect.stellantis.car.trip.report;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MainScreen extends JFrame {
    private JLabel m_backgroundLabel;
    private JButton m_batteryButton;
    private JButton m_fuelButton;
    private JButton m_odometerButton;
    private JButton m_oilButton;
    private JButton m_tireButton;
    private JButton m_reportButton;
    private JButton m_mobileButton;

    public MainScreen(String backgroundPath, String batteryPath, String fuelPath,
        String odometerPath, String oilPath, String tirePath, String reportPath, String mobilePath) {
        configureScreen();
        loadElements(backgroundPath, batteryPath, fuelPath, odometerPath, oilPath, tirePath, reportPath, mobilePath);
    }

    public JButton getReportButton() {
        return m_reportButton;
    }

    public JButton getBatteryButton() {
        return m_batteryButton;
    }

    public JButton getFuelButton() {
        return m_fuelButton;
    }

    public JButton getOdometerButton() {
        return m_odometerButton;
    }

    public JButton getOilButton() {
        return m_oilButton;
    }

    public JButton getTireButton() {
        return m_tireButton;
    }

    public JButton getMobileButton() {
        return m_mobileButton;
    }

    private void configureScreen() {
        setSize(1080, 641);
        setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
    }

    private void loadElements(String backgroundPath, String batteryPath, String fuelPath,
     String odometerPath, String oilPath, String tirePath, String reportPath, String mobilePath) {
        m_backgroundLabel = new JLabel(new ImageIcon(backgroundPath));
        m_batteryButton = new JButton(new ImageIcon(batteryPath));
        m_fuelButton = new JButton(new ImageIcon(fuelPath));
        m_odometerButton = new JButton(new ImageIcon(odometerPath));
        m_oilButton = new JButton(new ImageIcon(oilPath));
        m_tireButton = new JButton(new ImageIcon(tirePath));
        m_reportButton = new JButton(new ImageIcon(reportPath));
        m_mobileButton = new JButton(new ImageIcon(mobilePath));
        addElements();
        configureElementsLayout();
    }

    private void addElements() {
        add(m_backgroundLabel);
        m_backgroundLabel.add(m_batteryButton);
        m_backgroundLabel.add(m_fuelButton);
        m_backgroundLabel.add(m_odometerButton);
        m_backgroundLabel.add(m_oilButton);
        m_backgroundLabel.add(m_tireButton);
        m_backgroundLabel.add(m_reportButton);
        m_backgroundLabel.add(m_mobileButton);
    }

    private void configureElementsLayout() {
        m_backgroundLabel.setLayout(null);
        m_batteryButton.setLayout(null);
        m_fuelButton.setLayout(null);
        m_odometerButton.setLayout(null);
        m_oilButton.setLayout(null);
        m_tireButton.setLayout(null);
        m_reportButton.setLayout(null);
        m_mobileButton.setLayout(null);
        configureElementsBounds();
        configureElementsOpacity();
    }

    private void configureElementsBounds() {
        m_backgroundLabel.setBounds(0, 0, getSize().width, getSize().height);
        m_mobileButton.setBounds(getInsets().left + 290, getInsets().top + 480, 90, 90);
        m_reportButton.setBounds(getInsets().left + 400, getInsets().top + 480, 90, 90);
        m_fuelButton.setBounds(getInsets().left + 510, getInsets().top + 480, 90, 90);
        m_odometerButton.setBounds(getInsets().left + 620, getInsets().top + 480, 90, 90);
        m_oilButton.setBounds(getInsets().left + 730, getInsets().top + 480, 90, 90);
        m_tireButton.setBounds(getInsets().left + 840, getInsets().top + 480, 90, 90);
        m_batteryButton.setBounds(getInsets().left + 950, getInsets().top + 480, 90, 90);
    }

    private void configureElementsOpacity() {
        m_batteryButton.setContentAreaFilled(false);
        m_fuelButton.setContentAreaFilled(false);
        m_odometerButton.setContentAreaFilled(false);
        m_oilButton.setContentAreaFilled(false);
        m_tireButton.setContentAreaFilled(false);
        m_reportButton.setContentAreaFilled(false);
        m_mobileButton.setContentAreaFilled(false);
    }
}
