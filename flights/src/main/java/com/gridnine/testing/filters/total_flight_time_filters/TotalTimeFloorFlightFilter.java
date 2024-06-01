package main.java.com.gridnine.testing.filters.total_flight_time_filters;

import main.java.com.gridnine.testing.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class TotalTimeFloorFlightFilter extends TotalTimeFlightFilter{
    public TotalTimeFloorFlightFilter(int number, List<Flight> flights) {
        super(number, flights);
    }

    @Override
    public List<Flight> processFlights() {
        return flights.stream()
                .filter(flight -> flightDuration(flight) <= number)
                .collect(Collectors.toList());
    }
}
