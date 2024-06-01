package main.java.com.gridnine.testing.filters.segment_amount_filters;

import main.java.com.gridnine.testing.Flight;
import main.java.com.gridnine.testing.filters.FlightFilter;

import java.util.List;
import java.util.stream.Collectors;

// Returns List of Flights with a specified amount of Segments
public class SpecifiedSegmentAmountFlightFilter extends FlightFilter {
    public SpecifiedSegmentAmountFlightFilter(int number, List<Flight> flights) {
        super(number, flights);
    }
    @Override
    public List<Flight> processFlights() {
        return flights.stream()
                .filter(flight -> flight.getNumberOfSegments() == number)
                .collect(Collectors.toList());
    }
}
