package connect.stellantis.car.trip.report;

import java.util.*;
import java.io.FileReader;
import com.opencsv.CSVReader;

public class CarTripData {
    private CarTripFuel m_fuel;
    private CarTripDateHour m_dateHour;
    private CarTripOdometer m_odometer;
    private CarTripOilLevel m_oilLevel;
    private CarTripTirePressure[] m_tirePressure;
    private CarTripBatteryVoltage m_batteryVoltage;

    public CarTripData(String tripDataFile) {
        m_fuel = new CarTripFuel();
        m_dateHour = new CarTripDateHour();
        m_odometer = new CarTripOdometer();
        m_oilLevel = new CarTripOilLevel();
        m_tirePressure = new CarTripTirePressure[4];
        m_batteryVoltage = new CarTripBatteryVoltage();

        for (int i = 0; i < 4; ++i) {
            m_tirePressure[i] = new CarTripTirePressure();
        }

        readTripDataFile(tripDataFile);
    }

    public CarTripFuel getFuel() {
        return m_fuel;
    }

    public CarTripDateHour getDateHour() {
        return m_dateHour;
    }

    public CarTripOdometer getOdometer() {
        return m_odometer;
    }

    public CarTripOilLevel getOilLevel() {
        return m_oilLevel;
    }

    public CarTripBatteryVoltage getBatteryVoltage() {
        return m_batteryVoltage;
    }

    public CarTripTirePressure getFrontLeftTirePresure() {
        return m_tirePressure[0];
    }

    public CarTripTirePressure getFrontRightTirePresure() {
        return m_tirePressure[1];
    }

    public CarTripTirePressure getBackLeftTirePresure() {
        return m_tirePressure[2];
    }

    public CarTripTirePressure getBackRightTirePresure() {
        return m_tirePressure[3];
    }

    public void readTripDataFile(String tripDataFile) {
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(tripDataFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
                fillObjectsWithReadData(line);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void fillObjectsWithReadData(String[] data) {
        long time = Long.parseLong(data[1]);
        m_dateHour.addData(new CarTripDateHourData(time, data[2]));
        m_odometer.addData(new CarTripOdometerData(time, Integer.parseInt(data[4])));
        m_fuel.addData(new CarTripFuelData(time, Double.parseDouble(data[6].replace(',','.'))));
        m_batteryVoltage.addData(new CarTripBatteryVoltageData(time, Double.parseDouble(data[11].replace(',','.'))));
        m_oilLevel.addData(new CarTripOilLevelData(time, Integer.parseInt(data[15])));
        m_tirePressure[0].addData(new CarTripTirePressureData(time, Double.parseDouble(data[19].replace(',','.'))));
        m_tirePressure[1].addData(new CarTripTirePressureData(time, Double.parseDouble(data[22].replace(',','.'))));
        m_tirePressure[2].addData(new CarTripTirePressureData(time, Double.parseDouble(data[25].replace(',','.'))));
        m_tirePressure[3].addData(new CarTripTirePressureData(time, Double.parseDouble(data[28].replace(',','.'))));
    }
}
