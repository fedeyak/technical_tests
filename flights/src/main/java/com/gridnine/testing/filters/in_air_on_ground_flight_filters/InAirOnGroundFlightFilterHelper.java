package main.java.com.gridnine.testing.filters.in_air_on_ground_flight_filters;

import main.java.com.gridnine.testing.Flight;
import main.java.com.gridnine.testing.Segment;
import main.java.com.gridnine.testing.filters.FlightFilter;
import java.time.LocalDateTime;
import java.util.List;

public abstract class InAirOnGroundFlightFilterHelper extends FlightFilter {
    public InAirOnGroundFlightFilterHelper(List<Flight> flights) {
        super(flights);
    }

    protected boolean isOnTheGround(Flight flight) {
        boolean isOnTheGround = true;
        List<Segment> segments = flight.getSegments();
        LocalDateTime now = LocalDateTime.now();
        if (segments.size() == 1) {return false;}

        for (Segment segment : segments) {
            if (segment.getDepartureDate().isBefore(now) && segment.getArrivalDate().isAfter(now)) {
                isOnTheGround = false;
                break;
            }
        }
        return isOnTheGround;
    }
}
