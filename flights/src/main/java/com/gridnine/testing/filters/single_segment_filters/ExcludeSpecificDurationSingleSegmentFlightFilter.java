package main.java.com.gridnine.testing.filters.single_segment_filters;

import main.java.com.gridnine.testing.Flight;
import main.java.com.gridnine.testing.Segment;

import java.util.List;
import java.util.stream.Collectors;

public class ExcludeSpecificDurationSingleSegmentFlightFilter extends SingleSegmentFlightFilter{
    public ExcludeSpecificDurationSingleSegmentFlightFilter(int number, List<Flight> flights) {
        super(number, flights);
    }

    private boolean segmentDurationNotEqualsNumber(Flight flight) {
        List<Segment> segments = flight.getSegments();
        return segments.stream()
                .anyMatch(segment -> segmentDuration(segment) != number);
    }

    @Override
    public List<Flight> processFlights() {
        return flights.stream()
                .filter(flight -> segmentDurationNotEqualsNumber(flight))
                .collect(Collectors.toList());
    }
}
