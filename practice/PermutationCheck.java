package practice;

public class PermutationCheck {

    public static boolean permutationCheck(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] hasVisited = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            int c = (int) word1.charAt(i);
            hasVisited[c - 'a']++;
        }

        for (int i = 0; i < word2.length(); i++) {
            int c = (int) word2.charAt(i);
            hasVisited[c - 'a']--;
        }

        for (int i = 0; i < hasVisited.length; i++) {
            if (hasVisited[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "abcdefg";
        String b = "fgcbdea";

        String c = "abcdefg";
        String d = "aabcdef";
        System.out.println(permutationCheck(a, b));
        System.out.println(permutationCheck(c, d));
        System.out.println(permutationCheck(d, c));
    }
}
