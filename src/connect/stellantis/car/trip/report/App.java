package connect.stellantis.car.trip.report;

public class App {
    public static void main(String[] args) {
        CarTripData tripData = new CarTripData("src/trip_data.csv");
        CarTripFuel fuel = tripData.getFuel();

        for (Double measure : fuel.getData()) {
            System.out.println(measure);
        }
    }
}
