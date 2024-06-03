package main.java.com.gridnine.testing.filters.interval_durations_flight_filters;

import main.java.com.gridnine.testing.Flight;
import main.java.com.gridnine.testing.Segment;

import java.util.List;
import java.util.stream.Collectors;

public class ExcludeSpecificIntervalDurationFlightFilterHelper extends IntervalDurationFlightFilterHelper {

    public ExcludeSpecificIntervalDurationFlightFilterHelper(int intervalDuration, List<Flight> flights) {
        super(intervalDuration, flights);
    }

    private boolean excludeSpecificIntervalDurationFlightFilter(Flight flight) {
        List<Segment> intervals = getIntervals(flight);
        return intervals.stream().anyMatch(segment -> segmentDuration(segment) != number);
    }

    @Override
    public List<Flight> processFlights() {
        return flights.stream()
                .filter(this::excludeSpecificIntervalDurationFlightFilter)
                .collect(Collectors.toList());
    }
}
