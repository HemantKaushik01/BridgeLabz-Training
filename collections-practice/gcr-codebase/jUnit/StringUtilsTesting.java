package jUnit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringUtilsTesting {
    StringUtils str = new StringUtils();

    @Test
    void testReverse() { assertEquals("cba", str.reverse("abc")); }

    @Test
    void testIsPalindrome() { assertTrue(str.isPalindrome("madam")); }

    @Test
    void testToUpperCase() { assertEquals("HELLO", str.toUpperCase("hello")); }
}
