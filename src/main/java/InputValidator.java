import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public ValidationResult inputIsValid(String input){
        if(input == null || input.isEmpty() || input.equals("\n")){
            return ValidationResult.NULL_OR_EMPTY;
        }

        if (input.length() != 4)
            return ValidationResult.INVALID_LENGTH;

        for (char c: input.toCharArray()){
            if(!Character.isDigit(c))
                return ValidationResult.NOT_A_NUMBER;
        }

        Set<Character> uniqueDigits = new HashSet<>();
        for (char c: input.toCharArray()){
            uniqueDigits.add(c);
        }

        return uniqueDigits.size() == 4 ? ValidationResult.VALID : ValidationResult.DUPLICATE_DIGITS;
    }
}
