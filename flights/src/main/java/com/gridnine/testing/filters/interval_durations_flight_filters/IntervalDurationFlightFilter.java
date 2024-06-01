package main.java.com.gridnine.testing.filters.interval_durations_flight_filters;

import main.java.com.gridnine.testing.Flight;
import main.java.com.gridnine.testing.Segment;
import main.java.com.gridnine.testing.filters.FlightFilter;
import main.java.com.gridnine.testing.filters.segment_amount_filters.ExcludeSpecifiedSegmentAmountFlightFilter;

import java.util.ArrayList;
import java.util.List;

public abstract class IntervalDurationFlightFilter extends FlightFilter {

    protected final List<Flight> multipleSegmentFlights;

    public IntervalDurationFlightFilter(int number, List<Flight> flights) {
        super(number, flights);
        multipleSegmentFlights =
            new ExcludeSpecifiedSegmentAmountFlightFilter(1, flights).processFlights();
    }

    protected List<Segment> getIntervals(Flight flight) {
        List<Segment> segments = flight.getSegments();
//        int numberOfSegments = segments.size();
        List<Segment> intervals = new ArrayList<>();
        for (int i = 0; i < segments.size() - 1; i++) {
//            if ((i + 1) < numberOfSegments) {
                intervals.add(Segment.getNewSegment(
                        segments.get(i).getArrivalDate(), segments.get(i + 1).getDepartureDate()));
//            }
        }
        return intervals;
    }
}
