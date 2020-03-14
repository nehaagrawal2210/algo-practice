package practice;

public class OneAway {
    public static boolean isOneEditAway(String word1, String word2) {
        if (Math.abs(word1.length() - word2.length()) > 1) {
            return false;
        }

        String first = word1, second = word2;
        boolean isReplacement = false, foundDifference = false;
        if (word1.length() < word2.length()) {
            first = word1;
            second = word2;
        } else if (word2.length() < word1.length()) {
            first = word2;
            second = word1;
        } else {
            isReplacement = true;
        }

        int index1 = 0, index2 = 0;
        while (index1 < first.length() && index2 < second.length()) {
            if (first.charAt(index1) != second.charAt(index2)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
                if (isReplacement) {
                    index1++;
                }
            } else {
                index1++;
            }
            index2++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isOneEditAway("pale", "ple"));
        System.out.println(isOneEditAway("pales", "pale"));
        System.out.println(isOneEditAway("pale", "bale"));
        System.out.println(isOneEditAway("pale", "bake"));
        System.out.println(isOneEditAway("pale", "pales"));
        System.out.println(isOneEditAway("bake", "pale"));
        System.out.println(isOneEditAway("bake", "pake"));

        System.out.println();
        System.out.println(isOneEditAway("aple", "apple"));
    }
}
