package connect.stellantis.car.trip.report;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class TireSelectionScreen extends JFrame {
    private JLabel m_backgroundLabel;
    private JButton m_backButton;
    private JLabel m_tireFrontLeftLabel;
    private JLabel m_tireFrontRightLabel;
    private JLabel m_tireBackLeftLabel;
    private JLabel m_tireBackRightLabel;
    private JButton m_tireFrontLeftButton;
    private JButton m_tireFrontRightButton;
    private JButton m_tireBackLeftButton;
    private JButton m_tireBackRightButton;
    private CarTripTirePressure m_frontLeftTirePressure;
    private CarTripTirePressure m_frontRightTirePressure;
    private CarTripTirePressure m_backLeftTirePressure;
    private CarTripTirePressure m_backRightTirePressure;

    public TireSelectionScreen(String backgroundPath, String backButtonPath, String tireButtonPath,
        CarTripTirePressure frontLeftTire, CarTripTirePressure frontRightTire, CarTripTirePressure backLeftTire,
        CarTripTirePressure backRightTire) {
        m_frontLeftTirePressure = frontLeftTire;
        m_frontRightTirePressure = frontRightTire;
        m_backLeftTirePressure = backLeftTire;
        m_backRightTirePressure = backRightTire;
        configureScreen();
        loadElements(backgroundPath, backButtonPath, tireButtonPath);
    }

    public JButton getBackButton() {
        return m_backButton;
    }

    public JButton getTireFrontLeftButton() {
        return m_tireFrontLeftButton;
    }

    public JButton getTireFrontRightButton() {
        return m_tireFrontRightButton;
    }

    public JButton getTireBackLeftButton() {
        return m_tireBackLeftButton;
    }

    public JButton getTireBackRightButton() {
        return m_tireBackRightButton;
    }

    private void configureScreen() {
        setSize(1080, 641);
        setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
    }

    private void loadElements(String backgroundPath, String backButtonPath, String tireButtonPath) {
        m_backgroundLabel = new JLabel(new ImageIcon(backgroundPath));
        m_tireFrontLeftLabel = new JLabel("Front Left");
        m_tireFrontRightLabel = new JLabel("Front Right");
        m_tireBackLeftLabel = new JLabel("Back Left");
        m_tireBackRightLabel = new JLabel("Back Right");
        m_backButton = new JButton(new ImageIcon(backButtonPath));
        m_tireFrontLeftButton = new JButton(new ImageIcon(tireButtonPath));
        m_tireFrontRightButton = new JButton(new ImageIcon(tireButtonPath));
        m_tireBackLeftButton = new JButton(new ImageIcon(tireButtonPath));
        m_tireBackRightButton = new JButton(new ImageIcon(tireButtonPath));
        addElements();
        configureElementsLayout();
    }

    private void addElements() {
        add(m_backgroundLabel);
        m_backgroundLabel.add(m_tireFrontLeftLabel);
        m_backgroundLabel.add(m_tireFrontRightLabel);
        m_backgroundLabel.add(m_tireBackLeftLabel);
        m_backgroundLabel.add(m_tireBackRightLabel);
        m_backgroundLabel.add(m_backButton);
        m_backgroundLabel.add(m_tireFrontLeftButton);
        m_backgroundLabel.add(m_tireFrontRightButton);
        m_backgroundLabel.add(m_tireBackLeftButton);
        m_backgroundLabel.add(m_tireBackRightButton);
    }

    private void configureElementsLayout() {
        m_backgroundLabel.setLayout(null);
        m_backButton.setLayout(null);
        m_tireFrontLeftButton.setLayout(null);
        m_tireFrontRightButton.setLayout(null);
        m_tireBackLeftButton.setLayout(null);
        m_tireBackRightButton.setLayout(null);
        configureElementsText();
        configureElementsBounds();
        configureElementsOpacity();
    }

    private void configureElementsText() {
        m_tireFrontLeftLabel.setFont(new Font("Serif", Font.BOLD, 30));
        m_tireFrontLeftLabel.setForeground(Color.WHITE);
        m_tireFrontRightLabel.setFont(new Font("Serif", Font.BOLD, 30));
        m_tireFrontRightLabel.setForeground(Color.WHITE);
        m_tireBackLeftLabel.setFont(new Font("Serif", Font.BOLD, 30));
        m_tireBackLeftLabel.setForeground(Color.WHITE);
        m_tireBackRightLabel.setFont(new Font("Serif", Font.BOLD, 30));
        m_tireBackRightLabel.setForeground(Color.WHITE);
    }

    private void configureElementsBounds() {
        m_backgroundLabel.setBounds(0, 0, getSize().width, getSize().height);
        m_backButton.setBounds(getInsets().left + 30, getInsets().top + 30, 90, 90);
        m_tireFrontLeftButton.setBounds(getInsets().left + 250, getInsets().top + 40, 173, 222);
        m_tireFrontLeftLabel.setBounds(getInsets().left + 250, getInsets().top + 50, 173, 222);
        m_tireFrontRightButton.setBounds(getInsets().left + 650, getInsets().top + 40, 173, 222);
        m_tireFrontRightLabel.setBounds(getInsets().left + 650, getInsets().top + 50, 173, 222);
        m_tireBackLeftButton.setBounds(getInsets().left + 250, getInsets().top + 350, 173, 222);
        m_tireBackLeftLabel.setBounds(getInsets().left + 250, getInsets().top + 360, 173, 222);
        m_tireBackRightButton.setBounds(getInsets().left + 650, getInsets().top + 350, 173, 222);
        m_tireBackRightLabel.setBounds(getInsets().left + 650, getInsets().top + 360, 173, 222);
    }

    private void configureElementsOpacity() {
        m_backButton.setContentAreaFilled(false);
        m_tireFrontLeftButton.setContentAreaFilled(false);
        m_tireFrontRightButton.setContentAreaFilled(false);
        m_tireBackLeftButton.setContentAreaFilled(false);
        m_tireBackRightButton.setContentAreaFilled(false);
    }
}


