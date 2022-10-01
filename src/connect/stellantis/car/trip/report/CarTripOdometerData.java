package connect.stellantis.car.trip.report;

public class CarTripOdometerData implements Comparable<CarTripOdometerData> {
    private long m_time;
    private int m_odometer;

    public CarTripOdometerData(Long time, Integer odometer) {
        m_time = time;
        m_odometer = odometer;
    }

    public long getTime() {
        return m_time;
    }

    public int getOdometer() {
        return m_odometer;
    }

    public int compareTo(CarTripOdometerData other) {
        if (this.getTime() >= other.getTime()) {
            return 1;
        } else {
            return -1;
        }
	}
}
