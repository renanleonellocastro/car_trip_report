package connect.stellantis.car.trip.report;

import java.util.ArrayList;
import java.util.Collections;

public class CarTripTirePressure {
    private ArrayList<CarTripTirePressureData> m_tirepressure;

    public CarTripTirePressure() {
        m_tirepressure = new ArrayList<>();
    }

    public ArrayList<Double> getData() {
        ArrayList<Double> data = new ArrayList<>();
        for (CarTripTirePressureData tripTirePressureData : m_tirepressure) {
            data.add(tripTirePressureData.getTirePressure());
        }
        return data;
    }

    public void addData(CarTripTirePressureData tirepressureData) {
        m_tirepressure.add(tirepressureData);
        Collections.sort(m_tirepressure);
    }

    public double getTripStartValue() {
        return m_tirepressure.get(0).getTirePressure();
    }

    public double getTripEndValue() {
        return m_tirepressure.get(m_tirepressure.size() - 1).getTirePressure();
    }
}
