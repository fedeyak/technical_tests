package main.java.com.gridnine.testing.filters.single_segment_filters;

import main.java.com.gridnine.testing.Flight;
import main.java.com.gridnine.testing.Segment;
import main.java.com.gridnine.testing.filters.FlightFilter;

import java.util.List;
import java.util.stream.Collectors;

public class SpecificDurationSingleSegmentFlightFilter extends FlightFilter {
    public SpecificDurationSingleSegmentFlightFilter(int segmentDuration, List<Flight> flights) {
        super(segmentDuration, flights);
    }

    private boolean segmentDurationEqualsNumber(Flight flight) {
        List<Segment> segments = flight.getSegments();
        return segments.stream()
                .anyMatch(segment -> segmentDuration(segment) == number);
    }

    @Override
    public List<Flight> processFlights() {
        return flights.stream()
                .filter(this::segmentDurationEqualsNumber)
                .collect(Collectors.toList());
    }
}
