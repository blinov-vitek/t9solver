package space.blinov;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.regex.Pattern;
import space.blinov.exception.ValidationError;

public class T9Solver {
    Map<Character, String> combinations = ImmutableMap.<Character, String>builder()
            .put(' ', "0")
            .put('a', "2")
            .put('b', "22")
            .put('c', "222")
            .put('d', "3")
            .put('e', "33")
            .put('f', "333")
            .put('g', "4")
            .put('h', "44")
            .put('i', "444")
            .put('j', "5")
            .put('k', "55")
            .put('l', "555")
            .put('m', "6")
            .put('n', "66")
            .put('o', "666")
            .put('p', "7")
            .put('q', "77")
            .put('r', "777")
            .put('s', "7777")
            .put('t', "8")
            .put('u', "88")
            .put('v', "888")
            .put('w', "9")
            .put('x', "99")
            .put('y', "999")
            .put('z', "9999")
            .build();

    public String solve(String phrase) {
        validate(phrase);

        String firstCombination = combinations.get(phrase.charAt(0));
        StringBuilder finalCombination = new StringBuilder(firstCombination);
        for (int i = 1; i < phrase.length(); i++) {
            char c = phrase.charAt(i);
            String charCombination = combinations.get(c);
            if (digitsIsRepeated(finalCombination, charCombination)) {
                finalCombination.append(" ");
            }
            finalCombination.append(charCombination);
        }

        return finalCombination.toString();
    }

    private void validate(String phrase) {
        if (phrase == null || phrase.isEmpty()) {
            throw new ValidationError("input string should be not empty");
        }

        Pattern pattern = Pattern.compile("[a-z ]+");
        if (!pattern.matcher(phrase).matches()) {
            throw new ValidationError("input string should contain only a-z and spaces");
        }
    }

    private boolean digitsIsRepeated(StringBuilder finalCombination, String charCombination) {
        return getLastChar(finalCombination) == charCombination.charAt(0);
    }

    private char getLastChar(StringBuilder finalCombination) {
        return finalCombination.charAt(finalCombination.length() - 1);
    }
}