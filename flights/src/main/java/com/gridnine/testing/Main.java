package main.java.com.gridnine.testing;

import main.java.com.gridnine.testing.filters.FlightFilter;
import main.java.com.gridnine.testing.filters.interval_durations_flight_filters.SpecificIntervalDurationFlightFilter;
import main.java.com.gridnine.testing.filters.single_segment_filters.SingleSegmentFlightFilter;
import main.java.com.gridnine.testing.filters.single_segment_filters.SpecificDurationSingleSegmentFlightFilter;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        FlightFilter filter;

         List<Flight> flights = FlightBuilder.createFlights();
        flights.forEach(System.out::println);

//        List<Flight> filteredFlights = new SpecifiedSegmentAmountFlightFilter(1, flights).processFlights();
//        filteredFlights.forEach(System.out::println);

        System.out.println();
        List<Flight> filteredFlights = new SpecificIntervalDurationFlightFilter(1, flights).processFlights();
//                new SpecificDurationSingleSegmentFlightFilter(1, flights).processFlights();
//                new SpecificTotalTimeFlightFilter(1, flights).processFlights();
//                new SegmentCeilingFlightFilter(2, flights).processFlights();
        filteredFlights.forEach(System.out::println);
    }
}
