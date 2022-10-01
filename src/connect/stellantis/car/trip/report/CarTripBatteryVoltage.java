package connect.stellantis.car.trip.report;

import java.util.ArrayList;
import java.util.Collections;

public class CarTripBatteryVoltage {
    private ArrayList<CarTripBatteryVoltageData> m_batteryvoltage;

    public CarTripBatteryVoltage() {
        m_batteryvoltage = new ArrayList<>();
    }

    public ArrayList<Double> getData() {
        ArrayList<Double> data = new ArrayList<>();
        for (CarTripBatteryVoltageData tripBatteryVoltageData : m_batteryvoltage) {
            data.add(tripBatteryVoltageData.getBatteryVoltage());
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
