package main.java.com.gridnine.testing.filters.departure_arrival_flight_filters;

import main.java.com.gridnine.testing.Flight;
import main.java.com.gridnine.testing.Segment;
import main.java.com.gridnine.testing.filters.FlightFilter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DepartureArrivalFlightFilters extends FlightFilter {
    private static final int FLIGHT_IS_OVER = 1;
    private static final int FLIGHT_IN_PROGRESS = 2;
    private static final int FLIGHT_NOT_STARTED = 3;

    private LocalDateTime now = LocalDateTime.now();

    public DepartureArrivalFlightFilters(int flightStatus, List<Flight> flights) {
        super(flightStatus, flights);
    }

    private int checkFlightStatus(Flight flight) {
        List<Segment> segments = flight.getSegments();
        LocalDateTime initialDeparture = segments.get(0).getDepartureDate();
        LocalDateTime finalArrival = segments.get(segments.size() - 1).getArrivalDate();
        if (initialDeparture.isBefore(now) && finalArrival.isBefore(now)) {
            return FLIGHT_IS_OVER;
        }
        if (initialDeparture.isBefore(now) && finalArrival.isAfter(now)) {
            return FLIGHT_IN_PROGRESS;
        }
        return FLIGHT_NOT_STARTED;
        //todo
        // check cases when initialDeparture or finalArrival equals to now

    }

    @Override
    public List<Flight> processFlights() {
        if (number == FLIGHT_IS_OVER) {
            return flights.stream()
                    .filter(flight -> checkFlightStatus(flight) == FLIGHT_IS_OVER)
                    .collect(Collectors.toList());
        }
        if (number == FLIGHT_IN_PROGRESS) {
            return flights.stream()
                    .filter(flight -> checkFlightStatus(flight) == FLIGHT_IN_PROGRESS)
                    .collect(Collectors.toList());
        }
        return flights.stream()
                .filter(flight -> checkFlightStatus(flight) == FLIGHT_NOT_STARTED)
                .collect(Collectors.toList());
    }
}
