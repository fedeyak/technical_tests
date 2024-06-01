package main.java.com.gridnine.testing.filters.error_flight_filters;

import main.java.com.gridnine.testing.Flight;
import main.java.com.gridnine.testing.Segment;
import main.java.com.gridnine.testing.filters.FlightFilter;

import java.time.LocalDateTime;
import java.util.List;

public abstract class ErrorFlightFiltersHelper extends FlightFilter {
    public ErrorFlightFiltersHelper(List<Flight> flights) {
        super(flights);
    }

    protected boolean allSegmentsConsecutive(Flight flight) {
        boolean allSegmentsConsecutive = true;
        List<Segment> segments = flight.getSegments();
        for (int i = 0; i < segments.size() - 1; i++) {
            LocalDateTime currentArrival = segments.get(i).getArrivalDate();
            LocalDateTime nextDeparture = segments.get(i + 1).getDepartureDate();
            if (nextDeparture.isBefore(currentArrival)) {
                allSegmentsConsecutive = false;
                break;
            }
        }
        return allSegmentsConsecutive;
    }

    protected boolean departureBeforeArrival(Flight flight) {
        boolean departureBeforeArrival = true;
        List<Segment> segments = flight.getSegments();
        for (int i = 0; i < segments.size(); i++) {
            LocalDateTime departure = segments.get(i).getDepartureDate();
            LocalDateTime arrival = segments.get(i).getArrivalDate();
            if (arrival.isBefore(departure)) {
                departureBeforeArrival = false;
                break;
            }
        }
        return departureBeforeArrival;
    }
}
