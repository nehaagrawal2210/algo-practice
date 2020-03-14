package practice;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {

    public static boolean checkPalindromPermutation(String word) {
        Map<Character, Integer> characterCount = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (isASCII(c)) {
                characterCount.put(c, characterCount.getOrDefault(c, 0) + 1);
            }
        }

        boolean foundOdd = false;
        for (Map.Entry<Character, Integer> entry : characterCount.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }

        return true;
    }

    private static boolean isASCII(char c) {
        if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
            return true;
        }
        return false;
    }
}
