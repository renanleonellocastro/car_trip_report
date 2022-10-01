package connect.stellantis.car.trip.report;

public class CarTripFuelData implements Comparable<CarTripFuelData> {
    private long m_time;
    private double m_fuel;

    public CarTripFuelData(Long time, Double fuel) {
        m_time = time;
        m_fuel = fuel;
    }

    public long getTime() {
        return m_time;
    }

    public double getFuel() {
        return m_fuel;
    }

    public int compareTo(CarTripFuelData other) {
        if (this.getTime() >= other.getTime()) {
            return 1;
        } else {
            return -1;
        }
	}
}
