package connect.stellantis.car.trip.report;

import java.util.ArrayList;
import java.util.Collections;

public class CarTripOdometer {
    private ArrayList<CarTripOdometerData> m_odometer;

    public CarTripOdometer() {
        m_odometer = new ArrayList<>();
    }

    public ArrayList<Number> getMeasuredData() {
        ArrayList<Number> data = new ArrayList<>();
        for (CarTripOdometerData tripOdometerData : m_odometer) {
            data.add(tripOdometerData.getOdometer());
        }
        return data;
    }

    public ArrayList<Long> getTimeData() {
        ArrayList<Long> data = new ArrayList<>();
        for (CarTripOdometerData tripOdometerData : m_odometer) {
            data.add(tripOdometerData.getTime());
        }
        return data;
    }

    public void addData(CarTripOdometerData odometerData) {
        m_odometer.add(odometerData);
        Collections.sort(m_odometer);
    }

    public int getTripStartValue() {
        return m_odometer.get(0).getOdometer();
    }

    public int getTripEndValue() {
        return m_odometer.get(m_odometer.size() - 1).getOdometer();
    }
}
