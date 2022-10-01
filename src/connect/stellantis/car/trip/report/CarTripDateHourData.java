package connect.stellantis.car.trip.report;

public class CarTripDateHourData implements Comparable<CarTripDateHourData> {
    private long m_time;
    private String m_datehour;

    public CarTripDateHourData(Long time, String dateHour) {
        m_time = time;
        m_datehour = dateHour;
    }

    public long getTime() {
        return m_time;
    }

    public String getDateHour() {
        return m_datehour;
    }

    public int compareTo(CarTripDateHourData other) {
        if (this.getTime() >= other.getTime()) {
            return 1;
        } else {
            return -1;
        }
	}
}