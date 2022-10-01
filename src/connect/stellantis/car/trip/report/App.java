package connect.stellantis.car.trip.report;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class App extends JFrame {
    public static void main(String[] args) {
        CarTripConstants constants = new CarTripConstants();

        CarTripData tripData = new CarTripData("src/trip_data.csv");
        CarTripBatteryVoltage batteryVoltage = tripData.getBatteryVoltage();
        CarTripDateHour dateHour = tripData.getDateHour();
        CarTripFuel fuel = tripData.getFuel();
        CarTripOdometer odometer = tripData.getOdometer();
        CarTripOilLevel oilLevel = tripData.getOilLevel();
        CarTripTirePressure tirePressureFrontLeft = tripData.getFrontLeftTirePresure();
        CarTripTirePressure tirePressureFrontRight = tripData.getFrontRightTirePresure();
        CarTripTirePressure tirePressureBackLeft = tripData.getBackLeftTirePresure();
        CarTripTirePressure tirePressureBackRight = tripData.getBackRightTirePresure();

        MainScreen mainScreen = new MainScreen(constants.backgroundImagePath,
            constants.batteryImagePath, constants.fuelImagePath, constants.odometerImagePath,
            constants.oilImagePath, constants.tireImagePath, constants.reportImagePath);

        ReportScreen reportScreen = new ReportScreen(constants.reportBackgroundImagePath,
            constants.backImagePath, batteryVoltage.getTripStartValue(), odometer.getTripStartValue(),
            dateHour.getTripStartValue(), fuel.getTripStartValue(), oilLevel.getTripStartValue(),
            tirePressureFrontLeft.getTripStartValue(), tirePressureFrontRight.getTripStartValue(),
            tirePressureBackLeft.getTripStartValue(), tirePressureBackRight.getTripStartValue(),
            batteryVoltage.getTripEndValue(), odometer.getTripEndValue(), dateHour.getTripEndValue(),
            fuel.getTripEndValue(), oilLevel.getTripEndValue(), tirePressureFrontLeft.getTripEndValue(),
            tirePressureFrontRight.getTripEndValue(), tirePressureBackLeft.getTripEndValue(),
            tirePressureBackRight.getTripEndValue());
        
        mainScreen.setVisible(true);

        addScreenButtonListeners(mainScreen, reportScreen);
    }

    private static void addScreenButtonListeners(MainScreen mainScreen, ReportScreen reportScreen) {
        mainScreen.getReportButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainScreen.setVisible(false);
                reportScreen.setVisible(true);
            }
        });

        reportScreen.getBackButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reportScreen.setVisible(false);
                mainScreen.setVisible(true);
            }
        });
    }
}
