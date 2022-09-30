package connect.stellantis.car.trip.report;

import java.util.*;

public class App {
    public static void main(String[] args) {
        TripData tripData = new TripData("trip_data.csv");
        ArrayList<Long> teste = tripData.getTime();

        for (Long time : teste) {
            System.out.println(time);
        }
    }
}
