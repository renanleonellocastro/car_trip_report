package connect.stellantis.car.trip.report;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CarTripManager {
    private CarTripData m_tripData;
    private CarTripBatteryVoltage m_batteryVoltage;
    private CarTripDateHour m_dateHour;
    private CarTripFuel m_fuel;
    private CarTripOdometer m_odometer;
    private CarTripOilLevel m_oilLevel;
    private CarTripTirePressure m_tirePressureFrontLeft;
    private CarTripTirePressure m_tirePressureFrontRight;
    private CarTripTirePressure m_tirePressureBackLeft;
    private CarTripTirePressure m_tirePressureBackRight;
    private MainScreen m_mainScreen;
    private ReportScreen m_reportScreen;
    private ChartScreen m_chartScreen;

    public CarTripManager() {
        m_tripData = new CarTripData(CarTripConstants.collectedDataPath);
        m_batteryVoltage = m_tripData.getBatteryVoltage();
        m_dateHour = m_tripData.getDateHour();
        m_fuel = m_tripData.getFuel();
        m_odometer = m_tripData.getOdometer();
        m_oilLevel = m_tripData.getOilLevel();
        m_tirePressureFrontLeft = m_tripData.getFrontLeftTirePresure();
        m_tirePressureFrontRight = m_tripData.getFrontRightTirePresure();
        m_tirePressureBackLeft = m_tripData.getBackLeftTirePresure();
        m_tirePressureBackRight = m_tripData.getBackRightTirePresure();
        initializeMainScreen();
        initializeReportScreen();
    }

    public void run() {
        m_mainScreen.setVisible(true);
        addScreenButtonListeners();
    }

    private void initializeMainScreen() {
        m_mainScreen = new MainScreen(CarTripConstants.backgroundImagePath, CarTripConstants.batteryImagePath,
            CarTripConstants.fuelImagePath, CarTripConstants.odometerImagePath, CarTripConstants.oilImagePath,
            CarTripConstants.tireImagePath, CarTripConstants.reportImagePath);
    }

    private void initializeReportScreen() {
        m_reportScreen = new ReportScreen(CarTripConstants.reportBackgroundImagePath, CarTripConstants.backImagePath,
            m_batteryVoltage.getTripStartValue(), m_odometer.getTripStartValue(), m_dateHour.getTripStartValue(),
            m_fuel.getTripStartValue(), m_oilLevel.getTripStartValue(), m_tirePressureFrontLeft.getTripStartValue(),
            m_tirePressureFrontRight.getTripStartValue(), m_tirePressureBackLeft.getTripStartValue(),
            m_tirePressureBackRight.getTripStartValue(), m_batteryVoltage.getTripEndValue(), m_odometer.getTripEndValue(),
            m_dateHour.getTripEndValue(), m_fuel.getTripEndValue(), m_oilLevel.getTripEndValue(),
            m_tirePressureFrontLeft.getTripEndValue(), m_tirePressureFrontRight.getTripEndValue(),
            m_tirePressureBackLeft.getTripEndValue(), m_tirePressureBackRight.getTripEndValue());
    }

    private void addScreenButtonListeners() {
        m_mainScreen.getReportButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                m_reportScreen.setLocation(m_mainScreen.getLocation().x, m_mainScreen.getLocation().y);
                m_reportScreen.setVisible(true);
                m_mainScreen.setVisible(false);
            }
        });

        m_mainScreen.getBatteryButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                plotGraph("Battery Voltage During Trip", "seconds", "volts", "Battery Voltage",
                    m_batteryVoltage.getTimeData(), m_batteryVoltage.getMeasuredData());
            }
        });

        m_mainScreen.getOdometerButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                plotGraph("Odometer During Trip", "seconds", "Km", "Car Odometer",
                    m_odometer.getTimeData(), m_odometer.getMeasuredData());
            }
        });
    
        m_mainScreen.getFuelButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                plotGraph("Fuel During Trip", "seconds", "liters", "Car Fuel",
                    m_fuel.getTimeData(), m_fuel.getMeasuredData());
            }
        });
    
        m_mainScreen.getOilButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                plotGraph("Oil Level During Trip", "seconds", "%", "Car Oil Level",
                    m_oilLevel.getTimeData(), m_oilLevel.getMeasuredData());
            }
        });

        m_reportScreen.getBackButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                m_mainScreen.setLocation(m_reportScreen.getLocation().x, m_reportScreen.getLocation().y);
                m_mainScreen.setVisible(true);
                m_reportScreen.setVisible(false);
            }
        });
    }

    private void plotGraph(String title, String labelX, String labelY, String measurementName,
        ArrayList<Long> xData, ArrayList<Number> yData) {
        m_chartScreen = new ChartScreen(title, labelX, labelY, measurementName, xData, yData, CarTripConstants.backImagePath);
        m_chartScreen.setLocation(m_mainScreen.getLocation().x, m_mainScreen.getLocation().y);
        m_chartScreen.setVisible(true);
        m_mainScreen.setVisible(false);

        m_chartScreen.getBackButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                m_mainScreen.setLocation(m_chartScreen.getLocation().x, m_chartScreen.getLocation().y);
                m_mainScreen.setVisible(true);
                m_chartScreen.setVisible(false);
            }
        });
    }
}
