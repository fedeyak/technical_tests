package main.java.com.gridnine.testing;

import main.java.com.gridnine.testing.exceptions.arrivalPriorToDepartureException;
import main.java.com.gridnine.testing.exceptions.departureTimeExpiredException;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Segment {
    private final LocalDateTime departureDate;
    private final LocalDateTime arrivalDate;
    public static Segment getNewSegment(final LocalDateTime dep, final LocalDateTime arr) {
        return new Segment(dep, arr);
    }

    private Segment(final LocalDateTime dep, final LocalDateTime arr) {
        departureDate = Objects.requireNonNull(dep);
        arrivalDate = Objects.requireNonNull(arr);
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    private Long segmentDuration() {
        return Duration.between(departureDate, arrivalDate).toHours();
    }


    @Override
    public String toString() {
        DateTimeFormatter fmt =
                DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");
        return "[" + departureDate.format(fmt) + " -> " + arrivalDate.format(fmt)
                + ']';
    }
}
