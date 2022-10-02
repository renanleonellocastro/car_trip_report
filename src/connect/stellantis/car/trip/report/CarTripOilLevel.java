package connect.stellantis.car.trip.report;

import java.util.ArrayList;
import java.util.Collections;

public class CarTripOilLevel {
    private ArrayList<CarTripOilLevelData> m_oillevel;

    public CarTripOilLevel() {
        m_oillevel = new ArrayList<>();
    }

    public ArrayList<Number> getMeasuredData() {
        ArrayList<Number> data = new ArrayList<>();
        for (CarTripOilLevelData tripOilLevelData : m_oillevel) {
            data.add(tripOilLevelData.getOilLevel());
        }
        return data;
    }

    public ArrayList<Long> getTimeData() {
        ArrayList<Long> data = new ArrayList<>();
        for (CarTripOilLevelData tripOilLevelData : m_oillevel) {
            data.add(tripOilLevelData.getTime());
        }
        return data;
    }

    public void addData(CarTripOilLevelData oillevelData) {
        m_oillevel.add(oillevelData);
        Collections.sort(m_oillevel);
    }

    public int getTripStartValue() {
        return m_oillevel.get(0).getOilLevel();
    }

    public int getTripEndValue() {
        return m_oillevel.get(m_oillevel.size() - 1).getOilLevel();
    }
}
