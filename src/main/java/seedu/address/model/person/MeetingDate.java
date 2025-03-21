package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a Person's meeting date with the nutritionist in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidMeetingDate(String)}
 */
public class MeetingDate {
    public static final String DEFAULT_MEETING_DATE = "none";

    public static final String MESSAGE_CONSTRAINTS =
            "Meeting date must be in the format YYYY-MM-DD.";

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final String meetingDate;

    /**
     * Constructs a {@code MeetingDate}.
     *  If the given date is null or empty, it is stored as "none".
     *
     * @param date A valid meeting date or empty value
     */
    public MeetingDate(String date) {
        requireNonNull(date);
        checkArgument(isValidMeetingDate(date), MESSAGE_CONSTRAINTS);
        this.meetingDate = date;
    }

    /**
     * Returns true if a given string is a valid diet type.
     */
    public static boolean isValidMeetingDate(String test) {
        if (test.equals(DEFAULT_MEETING_DATE)) {
            return true; // "none" is valid
        }
        try {
            LocalDate.parse(test, FORMATTER);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return meetingDate;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof MeetingDate)) {
            return false;
        }

        MeetingDate otherMeetingDate = (MeetingDate) other;
        return meetingDate.equals(otherMeetingDate.meetingDate);
    }

    @Override
    public int hashCode() {
        return meetingDate.hashCode();
    }
}
