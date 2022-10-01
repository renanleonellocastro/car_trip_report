package connect.stellantis.car.trip.report;

import java.util.ArrayList;
import java.util.Collections;

public class CarTripDateHour {
    private ArrayList<CarTripDateHourData> m_datehour;

    public CarTripDateHour() {
        m_datehour = new ArrayList<>();
    }

    public ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        for (CarTripDateHourData tripDatehourData : m_datehour) {
            data.add(tripDatehourData.getDateHour());
        }
        return data;
    }

    public void addData(CarTripDateHourData datehourData) {
        m_datehour.add(datehourData);
        Collections.sort(m_datehour);
    }

    public String getTripStartValue() {
        return m_datehour.get(0).getDateHour();
    }

    public String getTripEndValue() {
        return m_datehour.get(m_datehour.size() - 1).getDateHour();
    }
}
