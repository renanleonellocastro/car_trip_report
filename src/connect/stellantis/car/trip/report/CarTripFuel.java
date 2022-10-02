package connect.stellantis.car.trip.report;

import java.util.ArrayList;
import java.util.Collections;

public class CarTripFuel {
    private ArrayList<CarTripFuelData> m_fuel;

    public CarTripFuel() {
        m_fuel = new ArrayList<>();
    }

    public ArrayList<Number> getMeasuredData() {
        ArrayList<Number> data = new ArrayList<>();
        for (CarTripFuelData tripFuelData : m_fuel) {
            data.add(tripFuelData.getFuel());
        }
        return data;
    }

    public ArrayList<Long> getTimeData() {
        ArrayList<Long> data = new ArrayList<>();
        for (CarTripFuelData tripFuelData : m_fuel) {
            data.add(tripFuelData.getTime());
        }
        return data;
    }

    public void addData(CarTripFuelData fuelData) {
        m_fuel.add(fuelData);
        Collections.sort(m_fuel);
    }

    public double getTripStartValue() {
        return m_fuel.get(0).getFuel();
    }

    public double getTripEndValue() {
        return m_fuel.get(m_fuel.size() - 1).getFuel();
    }
}
