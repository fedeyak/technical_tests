package main.java.com.gridnine.testing.test;

import main.java.com.gridnine.testing.Flight;
import main.java.com.gridnine.testing.Segment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestFlightBldr {
    private static LocalDateTime now = LocalDateTime.now();
    private static LocalDateTime tomorrow = now.plusDays(1);
    private static LocalDateTime yesterday = now.minusDays(1);

    public static List<Flight> nullFlights() {
        return null;
    }

    public static List<Flight> emptyFlights() {
        return new ArrayList<>();
    }


    public static List<Flight> createALLFlights() {
        return Arrays.asList(
                //1 segment; 3 hours; past
                createFlight(Segment.getNewSegment(yesterday, yesterday.plusHours(3))),
                //1 segment; 4 hours; current
                createFlight(Segment.getNewSegment(now.minusHours(2), now.plusHours(2))),
                //1 segment; 2 hours; future
                createFlight(Segment.getNewSegment(tomorrow, tomorrow.plusHours(2))),
                //1 segment; 2 hours; faulty segment
                createFlight(Segment.getNewSegment(tomorrow, tomorrow.minusHours(2))),

                //2 segments; 2h [1h] 3h; past
                createFlight(Segment.getNewSegment(yesterday, yesterday.plusHours(2)),
                        Segment.getNewSegment(yesterday.plusHours(3), yesterday.plusHours(6))),
                //2 segments; 2h [2h] 4h; current, on the ground
                createFlight(Segment.getNewSegment(now.minusHours(3), now.minusHours(1)),
                        Segment.getNewSegment(now.plusHours(1), now.plusHours(5))),
                //2 segments; 3h [3h] 3h; current, in the air;
                createFlight(Segment.getNewSegment(now.minusHours(1), now.plusHours(2)),
                        Segment.getNewSegment(now.plusHours(5), now.plusHours(8))),
                //2 segments; 1h [4h] 1h; future;
                createFlight(Segment.getNewSegment(tomorrow, tomorrow.plusHours(1)),
                        Segment.getNewSegment(tomorrow.plusHours(5), now.plusHours(8))),
                //2 segments; 1h [4h] 1h; future;
                createFlight(Segment.getNewSegment(tomorrow, tomorrow.plusHours(1)),
                        Segment.getNewSegment(tomorrow.plusHours(5), tomorrow.plusHours(6))),
                //2 segments; 2h [2h] 2h; faulty segment;
                createFlight(Segment.getNewSegment(tomorrow, tomorrow.minusHours(2)),
                        Segment.getNewSegment(tomorrow.plusHours(2), tomorrow.plusHours(4))),
                //2 segments; 2h [2h] 2h; faulty flight;
                createFlight(Segment.getNewSegment(tomorrow, tomorrow.plusHours(2)),
                        Segment.getNewSegment(tomorrow.plusHours(1), tomorrow.plusHours(3)))
        );
    }

    public static List<Flight> noFaultySegments() {
        return Arrays.asList(
                //1 segment; 3 hours; past
                createFlight(Segment.getNewSegment(yesterday, yesterday.plusHours(3))),
                //1 segment; 4 hours; current
                createFlight(Segment.getNewSegment(now.minusHours(2), now.plusHours(2))),
                //1 segment; 2 hours; future
                createFlight(Segment.getNewSegment(tomorrow, tomorrow.plusHours(2))),
                //1 segment; 2 hours; faulty segment
//                createFlight(Segment.getNewSegment(tomorrow, tomorrow.minusHours(2))),

                //2 segments; 2h [1h] 3h; past
                createFlight(Segment.getNewSegment(yesterday, yesterday.plusHours(2)),
                        Segment.getNewSegment(yesterday.plusHours(3), yesterday.plusHours(6))),
                //2 segments; 2h [2h] 4h; current, on the ground
                createFlight(Segment.getNewSegment(now.minusHours(3), now.minusHours(1)),
                        Segment.getNewSegment(now.plusHours(1), now.plusHours(5))),
                //2 segments; 3h [3h] 3h; current, in the air;
                createFlight(Segment.getNewSegment(now.minusHours(1), now.plusHours(2)),
                        Segment.getNewSegment(now.plusHours(5), now.plusHours(8))),
                //2 segments; 1h [4h] 1h; future;
                createFlight(Segment.getNewSegment(tomorrow, tomorrow.plusHours(1)),
                        Segment.getNewSegment(tomorrow.plusHours(5), now.plusHours(8))),
                //2 segments; 1h [4h] 1h; future;
                createFlight(Segment.getNewSegment(tomorrow, tomorrow.plusHours(1)),
                        Segment.getNewSegment(tomorrow.plusHours(5), tomorrow.plusHours(6))),
                //2 segments; 2h [2h] 2h; faulty segment;
//                createFlight(Segment.getNewSegment(tomorrow, tomorrow.minusHours(2)),
//                        Segment.getNewSegment(tomorrow.plusHours(2), tomorrow.plusHours(4))),
                //2 segments; 2h [2h] 2h; faulty flight;
                createFlight(Segment.getNewSegment(tomorrow, tomorrow.plusHours(2)),
                        Segment.getNewSegment(tomorrow.plusHours(1), tomorrow.plusHours(3)))
        );
    }

    public static List<Flight> noFaultyFlights() {
        return Arrays.asList(
                //1 segment; 3 hours; past
                createFlight(Segment.getNewSegment(yesterday, yesterday.plusHours(3))),
                //1 segment; 4 hours; current
                createFlight(Segment.getNewSegment(now.minusHours(2), now.plusHours(2))),
                //1 segment; 2 hours; future
                createFlight(Segment.getNewSegment(tomorrow, tomorrow.plusHours(2))),
                //1 segment; 2 hours; faulty segment
                createFlight(Segment.getNewSegment(tomorrow, tomorrow.minusHours(2))),

                //2 segments; 2h [1h] 3h; past
                createFlight(Segment.getNewSegment(yesterday, yesterday.plusHours(2)),
                        Segment.getNewSegment(yesterday.plusHours(3), yesterday.plusHours(6))),
                //2 segments; 2h [2h] 4h; current, on the ground
                createFlight(Segment.getNewSegment(now.minusHours(3), now.minusHours(1)),
                        Segment.getNewSegment(now.plusHours(1), now.plusHours(5))),
                //2 segments; 3h [3h] 3h; current, in the air;
                createFlight(Segment.getNewSegment(now.minusHours(1), now.plusHours(2)),
                        Segment.getNewSegment(now.plusHours(5), now.plusHours(8))),
                //2 segments; 1h [4h] 1h; future;
                createFlight(Segment.getNewSegment(tomorrow, tomorrow.plusHours(1)),
                        Segment.getNewSegment(tomorrow.plusHours(5), now.plusHours(8))),
                //2 segments; 1h [4h] 1h; future;
                createFlight(Segment.getNewSegment(tomorrow, tomorrow.plusHours(1)),
                        Segment.getNewSegment(tomorrow.plusHours(5), tomorrow.plusHours(6))),
                //2 segments; 2h [2h] 2h; faulty segment;
                createFlight(Segment.getNewSegment(tomorrow, tomorrow.minusHours(2)),
                        Segment.getNewSegment(tomorrow.plusHours(2), tomorrow.plusHours(4))),
                //2 segments; 2h [2h] 2h; faulty flight;
                createFlight(Segment.getNewSegment(tomorrow, tomorrow.plusHours(2)),
                        Segment.getNewSegment(tomorrow.plusHours(1), tomorrow.plusHours(3)))
        );
    }

    public static List<Flight> createNOFaultyFlights() {
        return Arrays.asList(
                //1 segment; 3 hours; past
                createFlight(Segment.getNewSegment(yesterday, yesterday.plusHours(3))),
                //1 segment; 4 hours; current
                createFlight(Segment.getNewSegment(now.minusHours(2), now.plusHours(2))),
                //1 segment; 2 hours; future
                createFlight(Segment.getNewSegment(tomorrow, tomorrow.plusHours(2))),
                //1 segment; 2 hours; faulty segment
//                createFlight(Segment.getNewSegment(tomorrow, tomorrow.minusHours(2))),

                //2 segments; 2h [1h] 3h; past
                createFlight(Segment.getNewSegment(yesterday, yesterday.plusHours(2)),
                        Segment.getNewSegment(yesterday.plusHours(3), yesterday.plusHours(6))),
                //2 segments; 2h [2h] 4h; current, on the ground
                createFlight(Segment.getNewSegment(now.minusHours(3), now.minusHours(1)),
                        Segment.getNewSegment(now.plusHours(1), now.plusHours(5))),
                //2 segments; 3h [3h] 3h; current, in the air;
                createFlight(Segment.getNewSegment(now.minusHours(1), now.plusHours(2)),
                        Segment.getNewSegment(now.plusHours(5), now.plusHours(8))),
                //2 segments; 1h [4h] 1h; future;
                createFlight(Segment.getNewSegment(tomorrow, tomorrow.plusHours(1)),
                        Segment.getNewSegment(tomorrow.plusHours(5), now.plusHours(8))),
                //2 segments; 1h [4h] 1h; future;
                createFlight(Segment.getNewSegment(tomorrow, tomorrow.plusHours(1)),
                        Segment.getNewSegment(tomorrow.plusHours(5), tomorrow.plusHours(6)))
//                //2 segments; 2h [2h] 2h; faulty segment;
//                createFlight(Segment.getNewSegment(tomorrow, tomorrow.minusHours(2)),
//                        Segment.getNewSegment(tomorrow.plusHours(2), tomorrow.plusHours(4))),
//                //2 segments; 2h [2h] 2h; faulty flight;
//                createFlight(Segment.getNewSegment(tomorrow, tomorrow.plusHours(2)),
//                        Segment.getNewSegment(tomorrow.plusHours(1), tomorrow.plusHours(3)))
        );
    }


    public static List<Flight> currentlyOnTheGround() {
        return Arrays.asList(
//                //1 segment; 3 hours; past
//                createFlight(Segment.getNewSegment(yesterday, yesterday.plusHours(3))),
//                //1 segment; 4 hours; current
//                createFlight(Segment.getNewSegment(now.minusHours(2), now.plusHours(2))),
//                //1 segment; 2 hours; future
//                createFlight(Segment.getNewSegment(tomorrow, tomorrow.plusHours(2))),
//                //1 segment; 2 hours; faulty segment
//                createFlight(Segment.getNewSegment(tomorrow, tomorrow.minusHours(2))),

//                //2 segments; 2h [1h] 3h; past
//                createFlight(Segment.getNewSegment(yesterday, yesterday.plusHours(2)),
//                        Segment.getNewSegment(yesterday.plusHours(3), yesterday.plusHours(6))),
                //2 segments; 2h [2h] 4h; current, on the ground
                createFlight(Segment.getNewSegment(now.minusHours(3), now.minusHours(1)),
                        Segment.getNewSegment(now.plusHours(1), now.plusHours(5)))
                //2 segments; 3h [3h] 3h; current, in the air;
//                createFlight(Segment.getNewSegment(now.minusHours(1), now.plusHours(2)),
//                        Segment.getNewSegment(now.plusHours(5), now.plusHours(8))),
//                //2 segments; 1h [4h] 1h; future;
//                createFlight(Segment.getNewSegment(tomorrow, tomorrow.plusHours(1)),
//                        Segment.getNewSegment(tomorrow.plusHours(5), now.plusHours(8))),
//                //2 segments; 1h [4h] 1h; future;
//                createFlight(Segment.getNewSegment(tomorrow, tomorrow.plusHours(1)),
//                        Segment.getNewSegment(tomorrow.plusHours(5), tomorrow.plusHours(6))),
//                //2 segments; 2h [2h] 2h; faulty segment;
//                createFlight(Segment.getNewSegment(tomorrow, tomorrow.minusHours(2)),
//                        Segment.getNewSegment(tomorrow.plusHours(2), tomorrow.plusHours(4))),
//                //2 segments; 2h [2h] 2h; faulty flight;
//                createFlight(Segment.getNewSegment(tomorrow, tomorrow.plusHours(2)),
//                        Segment.getNewSegment(tomorrow.plusHours(1), tomorrow.plusHours(3)))
        );
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
