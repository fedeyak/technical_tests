package main.java.com.gridnine.testing.filters.segment_amount_filters;

import main.java.com.gridnine.testing.Flight;
import java.util.List;
import java.util.stream.Collectors;

public class SegmentAmountFloorFlightFilter extends SegmentAmountFiltersHelper {

    public SegmentAmountFloorFlightFilter(int numberOfSegments, List<Flight> flights) {
        super(numberOfSegments, flights);
    }

    @Override
    public List<Flight> processFlights() {
        return flights.stream()
                .filter(flight -> getNumberOfSegments(flight) <= number)
                .collect(Collectors.toList());
    }
}
