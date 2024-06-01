package main.java.com.gridnine.testing.filters.error_flight_filters;

import main.java.com.gridnine.testing.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class RevealFaultySegmentsFlightFilter extends ErrorFlightFiltersHelper{
    public RevealFaultySegmentsFlightFilter(List<Flight> flights) {
        super(flights);
    }

    @Override
    public List<Flight> processFlights() {
        return flights.stream()
                .filter(flight -> departureBeforeArrival(flight) == false)
                .collect(Collectors.toList());
    }
}
