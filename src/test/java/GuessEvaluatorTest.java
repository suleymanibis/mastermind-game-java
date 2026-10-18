import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessEvaluatorTest {
    private GuessEvaluator guessEvaluator;

    @BeforeEach
    void setUp(){
        guessEvaluator = new GuessEvaluator();
    }

    @Test
    void testEvaluationResult_IfGuessAndSecretMatch(){
        String secretNumber = "1234";
        String guessNumber = "1234";

        EvaluationResult result = guessEvaluator.evalGuess(secretNumber, guessNumber);

        assertEquals(new EvaluationResult(4, 0), result, "The results are not matched!");
    }

    @Test
    void testEvaluationResult_IfGuessAndSecretHaveNotCommonDigit(){
        String secretNumber = "1234";
        String guessNumber = "5678";

        EvaluationResult result = guessEvaluator.evalGuess(secretNumber, guessNumber);

        assertEquals(new EvaluationResult(0, 0), result, "The results are not matched!");
    }

    @Test
    void testEvaluationResult_IfGuessAndSecretHaveSameDigitsButPlacesAreDifferent(){
        String secretNumber = "1234";
        String guessNumber = "4321";

        EvaluationResult result = guessEvaluator.evalGuess(secretNumber, guessNumber);

        assertEquals(new EvaluationResult(0, 4), result, "The results are not matched!");
    }

    @Test
    void testEvaluationResult_IfGuessAndSecretHaveSomeSameDigitsAndSomePlacesAreSame(){
        String secretNumber = "1234";
        String guessNumber = "1524";

        EvaluationResult result = guessEvaluator.evalGuess(secretNumber, guessNumber);

        assertEquals(new EvaluationResult(2, 1), result, "The results are not matched!");
    }
}
