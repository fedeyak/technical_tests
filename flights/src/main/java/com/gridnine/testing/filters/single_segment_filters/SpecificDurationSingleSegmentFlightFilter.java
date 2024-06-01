package main.java.com.gridnine.testing.filters.single_segment_filters;

import main.java.com.gridnine.testing.Flight;
import main.java.com.gridnine.testing.Segment;

import java.util.List;
import java.util.stream.Collectors;

public class SpecificDurationSingleSegmentFlightFilter extends SingleSegmentFlightFilter{
    public SpecificDurationSingleSegmentFlightFilter(int number, List<Flight> flights) {
        super(number, flights);
    }

    private boolean segmentDurationEqualsNumber(Flight flight) {
        List<Segment> segments = flight.getSegments();
        return segments.stream()
                .anyMatch(segment -> segmentDuration(segment) == number);
    }

    @Override
    public List<Flight> processFlights() {
        return flights.stream()
                .filter(flight -> segmentDurationEqualsNumber(flight))
                .collect(Collectors.toList());
    }
}
