package connect.stellantis.car.trip.report;

public class CarTripBatteryVoltageData implements Comparable<CarTripBatteryVoltageData> {
    private long m_time;
    private double m_batteryvoltage;

    public CarTripBatteryVoltageData(Long time, Double batteryvoltage) {
        m_time = time;
        m_batteryvoltage = batteryvoltage;
    }

    public long getTime() {
        return m_time;
    }

    public double getBatteryVoltage() {
        return m_batteryvoltage;
    }

    public int compareTo(CarTripBatteryVoltageData other) {
        if (this.getTime() >= other.getTime()) {
            return 1;
        } else {
            return -1;
        }
	}
}
