package main.java.com.gridnine.testing.filters.segment_amount_filters;

import main.java.com.gridnine.testing.Flight;
import java.util.List;
import java.util.stream.Collectors;

// Returns List of Flights with a specified amount of Segments
public class SpecificSegmentAmountFlightFilter extends SegmentAmountFiltersHelper {
    public SpecificSegmentAmountFlightFilter(int numberOfSegments, List<Flight> flights) {
        super(numberOfSegments, flights);
    }
    @Override
    public List<Flight> processFlights() {
        return flights.stream()
                .filter(flight -> getNumberOfSegments(flight) == number)
                .collect(Collectors.toList());
    }
}
