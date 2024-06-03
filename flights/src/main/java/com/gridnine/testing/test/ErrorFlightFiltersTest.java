package main.java.com.gridnine.testing.test;

import main.java.com.gridnine.testing.Flight;
import main.java.com.gridnine.testing.filters.FlightFiltersSuite;
import main.java.com.gridnine.testing.filters.in_air_on_ground_flight_filters.CurrentlyOnTheGroupingFlightFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ErrorFlightFiltersTest {

    FlightFiltersSuite filtersSuite = new FlightFiltersSuite(TestFlightBldr.createALLFlights());

    @Test
    public void CollectRightFlightsTest() {
        Assertions.assertEquals(TestFlightBldr.createNOFaultyFlights(), filtersSuite.collectRightFlights());
    }

    @Test
    public void ExcludeFaultySegmentsFlightFilterTest() {
        Assertions.assertEquals(TestFlightBldr.noFaultySegments(), filtersSuite.excludeFaultySegments());
    }

    @Test
    public void ExcludeNonConsecutiveSegmentsFlightFilterTest() {
        Assertions.assertEquals(TestFlightBldr.noFaultyFlights(), filtersSuite.excludeNonConsecutiveSegments());
    }

    @Test
    public void CurrentlyOnTheGroupingFlightFilterTest() {
        List<Flight> flights = TestFlightBldr.createALLFlights();
        List<Flight> onGroundFlights = new CurrentlyOnTheGroupingFlightFilter(flights).processFlights();
        Assertions.assertEquals(onGroundFlights, filtersSuite.currentlyOnTheGrouping());
//        Assertions.assertEquals(TestFlightBldr.currentlyOnTheGround(), filtersSuite.currentlyOnTheGrouping());
    }


}
