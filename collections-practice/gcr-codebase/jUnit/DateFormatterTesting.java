package jUnit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.text.ParseException;

public class DateFormatterTesting {
    DateFormatter obj = new DateFormatter();

    @Test
    void testValidDate() throws ParseException {
        assertEquals("12-01-2026", obj.formatDate("2023-12-31"));
    }

    @Test
    void testInvalidDate() {
        assertThrows(ParseException.class, () -> obj.formatDate("31-12-2023"));
    }
}
