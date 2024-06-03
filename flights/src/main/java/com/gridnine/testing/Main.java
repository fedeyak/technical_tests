package main.java.com.gridnine.testing;

import main.java.com.gridnine.testing.filters.FlightFiltersSuite;

import java.util.List;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();
        FlightFiltersSuite filtersSuite = new FlightFiltersSuite(flights);
        System.out.println("All existing Flights:");
        flights.forEach(System.out::println);

        System.out.println();
        System.out.println("Exclude Flights departing earlier then NOW:");
        List<Flight> futureFlights = filtersSuite.flightStatus(3);
        futureFlights.forEach(System.out::println);

        System.out.println();
        System.out.println("Exclude Flights with faulty Segments:");
        List<Flight> noFaultySegmentFlights = filtersSuite.collectRightFlights();
        noFaultySegmentFlights.forEach(System.out::println);

        System.out.println();
        System.out.println("Exclude Flights having more than two hour intervals between Segments:");
        List<Flight> twoHoursFloorIntervalFlights = filtersSuite.intervalDurationFloor(2);
        twoHoursFloorIntervalFlights.forEach(System.out::println);
    }
}
