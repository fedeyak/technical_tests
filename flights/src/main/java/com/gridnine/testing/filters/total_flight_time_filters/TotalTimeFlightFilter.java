package main.java.com.gridnine.testing.filters.total_flight_time_filters;

import main.java.com.gridnine.testing.Flight;
import main.java.com.gridnine.testing.filters.FlightFilter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public abstract class TotalTimeFlightFilter extends FlightFilter {
    public TotalTimeFlightFilter(int number, List<Flight> flights) {
        super(number, flights);
    }

    protected Long flightDuration(Flight flight) {
        LocalDateTime firstSegmentDeparture = flight.getSegments().get(0).getDepartureDate();
        LocalDateTime lastSegmentArrival = flight.getSegments().get(flight.getNumberOfSegments() - 1).getArrivalDate();
        return Duration.between(firstSegmentDeparture, lastSegmentArrival).toHours();
    }


}
