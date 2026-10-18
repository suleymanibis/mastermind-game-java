import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class NumberGeneratorTest {
    private NumberGenerator generator;

    @BeforeEach
    void setUp(){
        generator = new NumberGenerator();
    }

    @Test
    void testGeneratedNumberIsFourDigit(){
        String result = generator.generate4DigitNumber();

        assertEquals(4, result.length(), "The number is not 4-digit: " + result);
    }

    @Test
    void testGeneratedNumberHasUniqueDigits(){
        String result = generator.generate4DigitNumber();

        Set<Character> uniqueDigits = new HashSet<>();
        for(char c: result.toCharArray()) {
            uniqueDigits.add(c);
        }

        assertEquals(4, uniqueDigits.size(), "The number does not has unique digits: " + result);
    }

    @Test
    void testGeneratedNumberFirstDigitIsNotZero(){
        String result = generator.generate4DigitNumber();

        assertNotEquals('0', result.charAt(0), "The first digit of the number is zero: " + result);
    }

    @RepeatedTest(100)
    void testGeneratedNumberConsistentlyValid(){
        String result = generator.generate4DigitNumber();

        Set<Character> uniqueDigits = new HashSet<>();
        for(char c: result.toCharArray()) {
            uniqueDigits.add(c);
        }

        assertEquals(4, result.length());
        assertEquals(4, uniqueDigits.size());
        assertNotEquals('0', result.charAt(0));
    }
}
