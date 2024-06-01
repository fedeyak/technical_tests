package main.java.com.gridnine.testing.filters;

import main.java.com.gridnine.testing.Flight;
import main.java.com.gridnine.testing.Segment;

import java.time.Duration;
import java.util.List;

public abstract class FlightFilter {
    protected final int number;
    protected final List<Flight> flights;

    public FlightFilter(int number, List<Flight> flights) {
        this.number = number;
        this.flights = flights;
    }

    public FlightFilter(List<Flight> flights) {
        this.flights = flights;
        this.number = 0;
    }

    protected long segmentDuration(Segment segment) {
        return Duration.between(segment.getDepartureDate(), segment.getArrivalDate()).toHours();
    }

    public abstract List<Flight> processFlights();
}
