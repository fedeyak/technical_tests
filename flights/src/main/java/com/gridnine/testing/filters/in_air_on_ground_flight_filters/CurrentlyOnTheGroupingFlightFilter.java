package main.java.com.gridnine.testing.filters.in_air_on_ground_flight_filters;

import main.java.com.gridnine.testing.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class CurrentlyOnTheGroupingFlightFilter extends InAirOnGroundFlightFilterHelper {
    public CurrentlyOnTheGroupingFlightFilter(List<Flight> flights) {
        super(flights);
    }

    @Override
    public List<Flight> processFlights() {
        return flights.stream()
                .filter(this::isOnTheGround)
                .collect(Collectors.toList());
    }
}
