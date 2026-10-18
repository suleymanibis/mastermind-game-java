import java.util.Objects;
import java.util.Scanner;

public class MastermindGame {
    public static void run() {
        final int MAX_ATTEMPTS = 10;

        Scanner input = new Scanner(System.in);
        NumberGenerator numberGenerator = new NumberGenerator();
        InputValidator inputValidator = new InputValidator();
        GuessEvaluator guessEvaluator = new GuessEvaluator();
        int bestScore = -1;

        while (true) {
            String secretNumber = numberGenerator.generate4DigitNumber();

            System.out.println("The secret number was chosen! The game is starting...");

            int currentAttempts = MAX_ATTEMPTS;
            EvaluationResult result = new EvaluationResult(0, 0);
            String guessNumber;
            String resultText;
            int currentScore = 0;

            while (currentAttempts > 0 && result.bulls() != 4) {
                System.out.println(currentAttempts + " attempts remaining!");

                while (true) {
                    System.out.print("Enter your guess: ");
                    guessNumber = input.nextLine();

                    ValidationResult isValid = inputValidator.inputIsValid(guessNumber);

                    if (Objects.requireNonNull(isValid) == ValidationResult.VALID) {
                        break;
                    } else {
                        System.out.println("Your guess is not valid: " + isValid);
                    }
                }

                result = guessEvaluator.evalGuess(secretNumber, guessNumber);
                System.out.println("Result: +" + result.bulls() + " -" + result.cows());
                currentAttempts--;
            }

            if (result.bulls() == 4) {
                resultText = "Congratulations, you won the game!";
                currentScore = currentAttempts;
                bestScore = Math.max(bestScore, currentScore);
            }
            else
                resultText = "Unfortunately, you lost the game! The secret number was " + secretNumber + ". \nHowever, don't be sad. I think, you'll win next time :)";

            System.out.println(resultText);
            System.out.println();
            System.out.println("Your current score: " + currentScore);
            if (bestScore == -1) System.out.println("You haven't won a single game so far!");
            else System.out.println("Your best score: " + bestScore);

            System.out.println();
            System.out.print("Do you want to play again (y/n): ");
            String choice = input.nextLine().toLowerCase();

            if (!choice.startsWith("y")) {
                System.out.println("The game is existing...");
                break;
            }
        }

    }

}
