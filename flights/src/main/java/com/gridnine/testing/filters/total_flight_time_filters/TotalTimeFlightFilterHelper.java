package main.java.com.gridnine.testing.filters.total_flight_time_filters;

import main.java.com.gridnine.testing.Flight;
import main.java.com.gridnine.testing.filters.FlightFilter;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public abstract class TotalTimeFlightFilterHelper extends FlightFilter {
    public TotalTimeFlightFilterHelper(int number, List<Flight> flights) {
        super(number, flights);
    }

    private int getNumberOfSegments(Flight flight) {
        return flight.getSegments().size();
    }

    protected Long flightDuration(Flight flight) {
        int lastSegment = getNumberOfSegments(flight) - 1;
        LocalDateTime firstSegmentDeparture = flight.getSegments().get(0).getDepartureDate();
        LocalDateTime lastSegmentArrival = flight.getSegments().get(lastSegment).getArrivalDate();
        return Duration.between(firstSegmentDeparture, lastSegmentArrival).toHours();
    }


}
