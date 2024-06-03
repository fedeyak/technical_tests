package main.java.com.gridnine.testing.filters.segment_amount_filters;

import main.java.com.gridnine.testing.Flight;
import main.java.com.gridnine.testing.filters.FlightFilter;

import java.util.List;

public abstract class SegmentAmountFiltersHelper extends FlightFilter {
    public SegmentAmountFiltersHelper(int number, List<Flight> flights) {
        super(number, flights);
    }

    protected int getNumberOfSegments(Flight flight) {
        return flight.getSegments().size();
    }
}
