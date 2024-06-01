package main.java.com.gridnine.testing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Flight {
    private final List<Segment> segments;
    private final List<Segment> flightIntervals;
    private int numberOfSegments;

    public Flight(final List<Segment> segments) {
        this.segments = segments;
        numberOfSegments = segments.size();
        this.flightIntervals = new ArrayList<>(numberOfSegments - 1);
        setFlightIntervals();
    }

    private void setFlightIntervals() {
        for (int i = 0; i < numberOfSegments; i++) {
            if ((i + 1) < numberOfSegments) {
                flightIntervals.add(Segment.getNewSegment(
                        segments.get(i).getArrivalDate(), segments.get(i + 1).getDepartureDate()));
            }
        }
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public int getNumberOfSegments() {
        return numberOfSegments;
    }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}
