package main.java.com.gridnine.testing.filters.segment_amount_filters;

import main.java.com.gridnine.testing.Flight;
import main.java.com.gridnine.testing.filters.FlightFilter;

import java.util.List;
import java.util.stream.Collectors;

public class SegmentFloorFlightFilter extends FlightFilter {

    public SegmentFloorFlightFilter(int number, List<Flight> flights) {
        super(number, flights);
    }

    @Override
    public List<Flight> processFlights() {
        return flights.stream()
                .filter(flight -> flight.getNumberOfSegments() <= number)
                .collect(Collectors.toList());
    }
}
