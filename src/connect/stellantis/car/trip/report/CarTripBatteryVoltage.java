package connect.stellantis.car.trip.report;

import java.util.ArrayList;
import java.util.Collections;

public class CarTripBatteryVoltage {
    private ArrayList<CarTripBatteryVoltageData> m_batteryvoltage;

    public CarTripBatteryVoltage() {
        m_batteryvoltage = new ArrayList<>();
    }

    public ArrayList<Number> getMeasuredData() {
        ArrayList<Number> data = new ArrayList<>();
        for (CarTripBatteryVoltageData tripBatteryVoltageData : m_batteryvoltage) {
            data.add(tripBatteryVoltageData.getBatteryVoltage());
        }
        return data;
    }

    public ArrayList<Long> getTimeData() {
        ArrayList<Long> data = new ArrayList<>();
        for (CarTripBatteryVoltageData tripBatteryVoltageData : m_batteryvoltage) {
            data.add(tripBatteryVoltageData.getTime());
        }
        return data;
    }

    public void addData(CarTripBatteryVoltageData batteryvoltageData) {
        m_batteryvoltage.add(batteryvoltageData);
        Collections.sort(m_batteryvoltage);
    }

    public double getTripStartValue() {
        return m_batteryvoltage.get(0).getBatteryVoltage();
    }

    public double getTripEndValue() {
        return m_batteryvoltage.get(m_batteryvoltage.size() - 1).getBatteryVoltage();
    }
}
