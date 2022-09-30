package connect.stellantis.car.trip.report;

import java.util.*;
import java.io.FileReader;
import com.opencsv.CSVReader;

public class TripData {
    private ArrayList<Long> m_time;
    private ArrayList<String> m_dateHour;
    private ArrayList<Integer> m_odometer;
    private ArrayList<Double> m_fuel;
    private ArrayList<Double> m_batteryVoltage;
    private ArrayList<Integer>m_oilLevel;
    private ArrayList<Double> m_tire1Pressure;
    private ArrayList<Double> m_tire2Pressure;
    private ArrayList<Double> m_tire3Pressure;
    private ArrayList<Double> m_tire4Pressure;

    public TripData(String tripDataFile) {
        readTripDataFile(tripDataFile);
    }

    public ArrayList<Long> getTime() {
        return m_time;
    }

    public void readTripDataFile(String tripDataFile) {
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(tripDataFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
                System.out.println(line[1]);
                m_time.add(Long.parseLong(line[1]));
                m_dateHour.add(line[2]);
                m_odometer.add(Integer.parseInt(line[5]));
                m_fuel.add(Double.parseDouble(line[7]));
                m_batteryVoltage.add(Double.parseDouble(line[12]));
                m_oilLevel.add(Integer.parseInt(line[16]));
                m_tire1Pressure.add(Double.parseDouble(line[20]));
                m_tire2Pressure.add(Double.parseDouble(line[23]));
                m_tire3Pressure.add(Double.parseDouble(line[26]));
                //m_tire4Pressure.add(Double.parseDouble(line[29]));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
