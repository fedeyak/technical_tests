package main.java.com.gridnine.testing.filters.error_flight_filters;

import main.java.com.gridnine.testing.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class RevealNonConsecutiveSegmentsFlightFilter extends ErrorFlightFiltersHelper{
    public RevealNonConsecutiveSegmentsFlightFilter(List<Flight> flights) {
        super(flights);
    }

    @Override
    public List<Flight> processFlights() {
        return flights.stream()
                .filter(flight -> allSegmentsConsecutive(flight) == false)
                .collect(Collectors.toList());
    }
}
