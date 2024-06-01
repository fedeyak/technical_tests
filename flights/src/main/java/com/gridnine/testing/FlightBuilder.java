package main.java.com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlightBuilder {

    private static LocalDateTime now = LocalDateTime.now();
    private static LocalDateTime tomorrow = now.plusDays(1);
    private static LocalDateTime yesterday = now.minusDays(1);


    static Flight createSingleShortFlight() {
        return createFlight(Segment.getNewSegment(tomorrow, tomorrow.plusHours(1)));
    }

    static Flight createSingleLongFlight() {
        return createFlight(Segment.getNewSegment(tomorrow, tomorrow.plusHours(5)));
    }

    public static List<Flight> createFlights() {
        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
        return Arrays.asList(
                //A normal flight with two hour duration
                createFlight(Segment.getNewSegment(threeDaysFromNow, threeDaysFromNow.plusHours(2))),
                //A normal multi segment flight
                createFlight(Segment.getNewSegment(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                        Segment.getNewSegment(threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5))),
                //A flight departing in the past
                createFlight(Segment.getNewSegment(threeDaysFromNow.minusDays(6), threeDaysFromNow)),
                //A flight that departs before it arrives
                createFlight(Segment.getNewSegment(threeDaysFromNow, threeDaysFromNow.minusHours(6))),
                //A flight with more than two hours ground time
                createFlight(Segment.getNewSegment(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                        Segment.getNewSegment(threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(6))),
                //Another flight with more than two hours ground time
                createFlight(Segment.getNewSegment(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                        Segment.getNewSegment(threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(4)),
                        Segment.getNewSegment(threeDaysFromNow.plusHours(6), threeDaysFromNow.plusHours(7))));
    }

    private static Flight createFlight(final Segment... segment) {
        int segmentLength = segment.length;
        List<Segment> segments = new ArrayList<>(segmentLength);

        for (int i = 0; i < segmentLength; i++) {
            segments.add(segment[i]);
        }
        return new Flight(segments);
    }
}
