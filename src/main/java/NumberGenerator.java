import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NumberGenerator {
    public String generate4DigitNumber() {
        Random random = new Random();
        int number;

        while (true) {
            number = random.nextInt(1000, 10000);
            String digits = String.valueOf(number);
            Set<Character> uniqueDigits = new HashSet<>();

            for (char c: digits.toCharArray()){
                uniqueDigits.add(c);
            }

            if (uniqueDigits.size() == 4){
                return digits;
            }
        }
    }
}
