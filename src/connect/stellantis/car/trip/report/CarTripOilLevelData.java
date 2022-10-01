package connect.stellantis.car.trip.report;

public class CarTripOilLevelData implements Comparable<CarTripOilLevelData> {
    private long m_time;
    private int m_oillevel;

    public CarTripOilLevelData(Long time, Integer oillevel) {
        m_time = time;
        m_oillevel = oillevel;
    }

    public long getTime() {
        return m_time;
    }

    public int getOilLevel() {
        return m_oillevel;
    }

    public int compareTo(CarTripOilLevelData other) {
        if (this.getTime() >= other.getTime()) {
            return 1;
        } else {
            return -1;
        }
	}
}
