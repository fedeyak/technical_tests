package main.java.com.gridnine.testing.filters.error_flight_filters;

import main.java.com.gridnine.testing.Flight;
import main.java.com.gridnine.testing.Segment;
import main.java.com.gridnine.testing.filters.FlightFilter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ExcludeNonConsecutiveSegmentsFlightFilter extends ErrorFlightFiltersHelper {

    public ExcludeNonConsecutiveSegmentsFlightFilter(List<Flight> flights) {
        super(flights);
    }



    @Override
    public List<Flight> processFlights() {
        return flights.stream()
                .filter(flight -> allSegmentsConsecutive(flight))
                .collect(Collectors.toList());
    }
}
