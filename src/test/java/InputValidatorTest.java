import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class InputValidatorTest {
    private InputValidator inputValidator;
    private Random random;

    @BeforeEach
    void setUp(){
        inputValidator = new InputValidator();
        random = new Random();
    }

    @Test
    void testInputHasFourDigit_IfInputHasLessThan4Digit(){
        int inputInt = random.nextInt(1000);
        String input = String.valueOf(inputInt);

        ValidationResult result = inputValidator.inputIsValid(input);
        assertEquals(ValidationResult.INVALID_LENGTH, result, "The input is not 4-digit.");
    }

    @Test
    void testInputHasFourDigit_IfInputMoreThan4Digit(){
        int inputInt = random.nextInt(10000, 100000);
        String input = String.valueOf(inputInt);

        ValidationResult result = inputValidator.inputIsValid(input);
        assertEquals(ValidationResult.INVALID_LENGTH, result, "The input is not 4-digit.");
    }

    @Test
    void testInputIsValid_IfInputIsNull(){
        ValidationResult result = inputValidator.inputIsValid(null);
        assertEquals(ValidationResult.NULL_OR_EMPTY, result, "The input is null.");
    }

    @Test
    void testInputIsValid_IfInputIsEmpty(){
        ValidationResult result = inputValidator.inputIsValid("");
        assertEquals(ValidationResult.NULL_OR_EMPTY, result, "The input is empty.");
    }

    @Test
    void testInputContainsFullDigits_IfInputContainsSpace(){
        ValidationResult result = inputValidator.inputIsValid("    ");
        assertEquals(ValidationResult.NOT_A_NUMBER, result, "The input is not a number.");
    }

    @Test
    void testInputContainsFullDigits_IfInputContainsLetter(){
        ValidationResult result = inputValidator.inputIsValid("12a4");
        assertEquals(ValidationResult.NOT_A_NUMBER, result, "The input is not a number.");
    }

    @Test
    void testInputIsUnique_IfInputContainsSameNumbers(){
        ValidationResult result = inputValidator.inputIsValid("1334");
        assertEquals(ValidationResult.DUPLICATE_DIGITS, result, "The input has duplicate numbers.");
    }

    @Test
    void testInputIsValid_IfInputIsValid(){
        ValidationResult result = inputValidator.inputIsValid("0234");
        assertEquals(ValidationResult.VALID, result, "The input is valid.");
    }
}
