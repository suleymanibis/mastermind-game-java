public class GuessEvaluator {
    public EvaluationResult evalGuess(String secretNumber, String guessNumber){
        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < 4; i++){
            if (secretNumber.contains("" + guessNumber.charAt(i))){
                if(secretNumber.charAt(i) == guessNumber.charAt(i)){
                    bulls++;
                } else {
                    cows++;
                }
            }
        }

        return new EvaluationResult(bulls, cows);
    }
}
