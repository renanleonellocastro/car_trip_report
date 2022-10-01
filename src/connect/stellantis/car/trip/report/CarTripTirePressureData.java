package connect.stellantis.car.trip.report;

public class CarTripTirePressureData implements Comparable<CarTripTirePressureData> {
    private long m_time;
    private double m_tirepressure;

    public CarTripTirePressureData(Long time, Double tirepressure) {
        m_time = time;
        m_tirepressure = tirepressure;
    }

    public long getTime() {
        return m_time;
    }

    public double getTirePressure() {
        return m_tirepressure;
    }

    public int compareTo(CarTripTirePressureData other) {
        if (this.getTime() >= other.getTime()) {
            return 1;
        } else {
            return -1;
        }
	}
}
