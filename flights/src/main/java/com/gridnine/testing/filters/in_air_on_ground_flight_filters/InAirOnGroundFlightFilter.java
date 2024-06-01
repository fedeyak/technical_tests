package main.java.com.gridnine.testing.filters.in_air_on_ground_flight_filters;

import main.java.com.gridnine.testing.Flight;
import main.java.com.gridnine.testing.Segment;
import main.java.com.gridnine.testing.filters.FlightFilter;
import main.java.com.gridnine.testing.filters.departure_arrival_flight_filters.DepartureArrivalFlightFilters;

import java.time.LocalDateTime;
import java.util.List;

public abstract class InAirOnGroundFlightFilter extends FlightFilter {
    private final List<Flight> flightsInProgress;

    public InAirOnGroundFlightFilter(List<Flight> flights) {
        super(flights);
        flightsInProgress = new DepartureArrivalFlightFilters(2, flights).processFlights();
    }

    protected boolean isOnTheGround(Flight flight) {
        boolean isOnTheGround = true;
        List<Segment> segments = flight.getSegments();
        LocalDateTime now = LocalDateTime.now();
        for (Segment segment : segments) {
            if (segment.getDepartureDate().isBefore(now) && segment.getArrivalDate().isAfter(now)) {
                isOnTheGround = false;
                break;
            }
        }
        return isOnTheGround;
    }
}
