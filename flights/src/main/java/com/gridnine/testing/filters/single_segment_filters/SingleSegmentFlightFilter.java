package main.java.com.gridnine.testing.filters.single_segment_filters;

import main.java.com.gridnine.testing.Flight;
import main.java.com.gridnine.testing.Segment;
import main.java.com.gridnine.testing.filters.FlightFilter;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public abstract class SingleSegmentFlightFilter extends FlightFilter {
    public SingleSegmentFlightFilter(int number, List<Flight> flights) {
        super(number, flights);
    }


}
