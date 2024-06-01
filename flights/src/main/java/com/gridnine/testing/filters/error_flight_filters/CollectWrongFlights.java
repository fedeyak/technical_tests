package main.java.com.gridnine.testing.filters.error_flight_filters;

import main.java.com.gridnine.testing.Flight;
import main.java.com.gridnine.testing.filters.FlightFilter;

import java.util.List;

public class CollectWrongFlights extends FlightFilter {
    public CollectWrongFlights(List<Flight> flights) {
        super(flights);
    }

    @Override
    public List<Flight> processFlights() {
        return new RevealNonConsecutiveSegmentsFlightFilter
                (new RevealFaultySegmentsFlightFilter(flights).processFlights())
                .processFlights();
    }
}
