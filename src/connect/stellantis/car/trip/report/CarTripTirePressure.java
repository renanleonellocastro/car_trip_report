package connect.stellantis.car.trip.report;

import java.util.ArrayList;
import java.util.Collections;

public class CarTripTirePressure {
    private ArrayList<CarTripTirePressureData> m_tirePressure;

    public CarTripTirePressure() {
        m_tirePressure = new ArrayList<>();
    }

    public ArrayList<Number> getMeasuredData() {
        ArrayList<Number> data = new ArrayList<>();
        for (CarTripTirePressureData tripTirePressureLevelData : m_tirePressure) {
            data.add(tripTirePressureLevelData.getTirePressure());
        }
        return data;
    }

    public ArrayList<Long> getTimeData() {
        ArrayList<Long> data = new ArrayList<>();
        for (CarTripTirePressureData tripTirePressureLevelData : m_tirePressure) {
            data.add(tripTirePressureLevelData.getTime());
        }
        return data;
    }

    public void addData(CarTripTirePressureData tirepressureData) {
        m_tirePressure.add(tirepressureData);
        Collections.sort(m_tirePressure);
    }

    public double getTripStartValue() {
        return m_tirePressure.get(0).getTirePressure();
    }

    public double getTripEndValue() {
        return m_tirePressure.get(m_tirePressure.size() - 1).getTirePressure();
    }
}
