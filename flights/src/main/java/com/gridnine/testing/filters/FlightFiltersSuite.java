package main.java.com.gridnine.testing.filters;

import main.java.com.gridnine.testing.Flight;
import main.java.com.gridnine.testing.filters.departure_arrival_flight_filters.DepartureArrivalFlightFilters;
import main.java.com.gridnine.testing.filters.error_flight_filters.*;
import main.java.com.gridnine.testing.filters.in_air_on_ground_flight_filters.CurrentlyInTheAirFlightFilter;
import main.java.com.gridnine.testing.filters.in_air_on_ground_flight_filters.CurrentlyOnTheGroupingFlightFilter;
import main.java.com.gridnine.testing.filters.interval_durations_flight_filters.ExcludeSpecificIntervalDurationFlightFilterHelper;
import main.java.com.gridnine.testing.filters.interval_durations_flight_filters.IntervalDurationCeilingFlightFilterHelper;
import main.java.com.gridnine.testing.filters.interval_durations_flight_filters.IntervalDurationFloorFlightFilterHelper;
import main.java.com.gridnine.testing.filters.interval_durations_flight_filters.SpecificIntervalDurationFlightFilterHelper;
import main.java.com.gridnine.testing.filters.segment_amount_filters.ExcludeSpecificSegmentAmountFlightFilter;
import main.java.com.gridnine.testing.filters.segment_amount_filters.SegmentAmountCeilingFlightFilter;
import main.java.com.gridnine.testing.filters.segment_amount_filters.SegmentAmountFloorFlightFilter;
import main.java.com.gridnine.testing.filters.segment_amount_filters.SpecificSegmentAmountFlightFilter;
import main.java.com.gridnine.testing.filters.single_segment_filters.ExcludeSpecificDurationSingleSegmentFlightFilter;
import main.java.com.gridnine.testing.filters.single_segment_filters.SingleSegmentCeilingFlightFilter;
import main.java.com.gridnine.testing.filters.single_segment_filters.SingleSegmentFloorFlightFilter;
import main.java.com.gridnine.testing.filters.single_segment_filters.SpecificDurationSingleSegmentFlightFilter;
import main.java.com.gridnine.testing.filters.total_flight_time_filters.ExcludeSpecificTotalTimeFlightFilterHelper;
import main.java.com.gridnine.testing.filters.total_flight_time_filters.SpecificTotalTimeFlightFilterHelper;
import main.java.com.gridnine.testing.filters.total_flight_time_filters.TotalTimeCeilingFlightFilterHelper;
import main.java.com.gridnine.testing.filters.total_flight_time_filters.TotalTimeFloorFlightFilterHelper;

import java.util.List;

public class FlightFiltersSuite {
    private final List<Flight> flights;

    public FlightFiltersSuite(List<Flight> flights) {
        this.flights = flights;
    }

//    Process faulty Flights
//    There are two types of errors related to a Flight:
//    (i) Segment's arrival is prior to Segment's departure, and
//    (ii) Next Segment's departure is prior to the current Segment's departure.
//    For the user's convenience the filter can process all errors at once,
//    or process each error separately.

    public List<Flight> collectRightFlights() {
        return new CollectRightFlights(flights).processFlights();
    }
    public List<Flight> collectWrongFlights() {
        return new CollectWrongFlights(flights).processFlights();
    }
    public List<Flight> excludeFaultySegments() {
        return new ExcludeFaultySegmentsFlightFilter(flights).processFlights();
    }
    public List<Flight> excludeNonConsecutiveSegments() {
        return new ExcludeNonConsecutiveSegmentsFlightFilter(flights).processFlights();
    }
    public List<Flight> revealFaultySegments() {
        return new RevealFaultySegmentsFlightFilter(flights).processFlights();
    }
    public List<Flight> revealNonConsecutiveSegments() {
        return new RevealNonConsecutiveSegmentsFlightFilter(flights).processFlights();
    }

    //=====================================================================================//


// Return Flights which are either completed, or currently in progress or not stared yet.
//    To implement the required filter the specific numeric values should be used:
//    -- 1: the flight is over;
//    -- 2: the flight is currently in progress;
//    -- 3: the flight has not started yet.
    public List<Flight> flightStatus(final int flightStatus) {
        return new DepartureArrivalFlightFilters(flightStatus, flights).processFlights();
    }

    //=====================================================================================//



    //    Return Flights which are currently in progress and currently either in the air or on the ground.
    public List<Flight> currentlyInTheAir() {
        return new CurrentlyInTheAirFlightFilter(flights).processFlights();
    }

    public List<Flight> currentlyOnTheGrouping() {
        return new CurrentlyOnTheGroupingFlightFilter(flights).processFlights();
    }

    //=====================================================================================//


    //    Process total flight time of each Flight.
    public List<Flight> specificTotalTime(final int numberOfHours) {
        return new SpecificTotalTimeFlightFilterHelper(numberOfHours, flights).processFlights();
    }

    public List<Flight> excludeSpecificTotalTime(final int numberOfHours) {
        return new ExcludeSpecificTotalTimeFlightFilterHelper(numberOfHours, flights).processFlights();
    }

    public List<Flight> totalTimeFloor(final int numberOfHours) {
        return new TotalTimeFloorFlightFilterHelper(numberOfHours, flights).processFlights();
    }

    public List<Flight> totalTimeCeiling(final int numberOfHours) {
        return new TotalTimeCeilingFlightFilterHelper(numberOfHours, flights).processFlights();
    }

    //=====================================================================================//


    //    Process amount of Segments in a Flight.
    public List<Flight> specificSegmentAmount(final int numberOfSegments) {
        return new SpecificSegmentAmountFlightFilter(numberOfSegments, flights).processFlights();
    }

    public List<Flight> excludeSpecificSegmentAmount(final int numberOfSegments) {
        return new ExcludeSpecificSegmentAmountFlightFilter(numberOfSegments, flights).processFlights();
    }

    public List<Flight> segmentAmountFloor(final int numberOfSegments) {
        return new SegmentAmountFloorFlightFilter(numberOfSegments, flights).processFlights();
    }

    public List<Flight> segmentAmountCeiling(final int numberOfSegments) {
        return new SegmentAmountCeilingFlightFilter(numberOfSegments, flights).processFlights();
    }

    //=====================================================================================//


    //    Process durations of individual Segments of a Flight.
    public List<Flight> specificDurationSingleSegment(final int segmentDuration) {
        return new SpecificDurationSingleSegmentFlightFilter(segmentDuration, flights).processFlights();
    }

    public List<Flight> excludeSpecificDurationOfSingleSegment(final int segmentDuration) {
        return new ExcludeSpecificDurationSingleSegmentFlightFilter(segmentDuration, flights).processFlights();
    }

    public List<Flight> singleSegmentFloor(final int segmentDuration) {
        return new SingleSegmentFloorFlightFilter(segmentDuration, flights).processFlights();
    }

    public List<Flight> singleSegmentCeiling(final int segmentDuration) {
        return new SingleSegmentCeilingFlightFilter(segmentDuration, flights).processFlights();
    }

    //=====================================================================================//



    //    Process the duration of intervals between Segments within a Flight.
    public List<Flight> specificDurationOfInterval(final int intervalDuration) {
        return new SpecificIntervalDurationFlightFilterHelper(intervalDuration, flights).processFlights();
    }

    public List<Flight> excludeSpecificDurationOfInterval(final int intervalDuration) {
        return new ExcludeSpecificIntervalDurationFlightFilterHelper(intervalDuration, flights).processFlights();
    }

    public List<Flight> intervalDurationFloor(final int intervalDuration) {
        return new IntervalDurationFloorFlightFilterHelper(intervalDuration, flights).processFlights();
    }

    public List<Flight> intervalDurationCeiling(final int intervalDuration) {
        return new IntervalDurationCeilingFlightFilterHelper(intervalDuration, flights).processFlights();
    }

    //=====================================================================================//

}
