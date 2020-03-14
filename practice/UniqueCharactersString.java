package practice;

public class UniqueCharactersString {

    public static boolean hasUniqueCharacters(String word) {
        boolean[] isVisited = new boolean[26];
        for (int i = 0; i < word.length(); i++) {
            int c = (int) word.charAt(i);
            if (isVisited[c-'a']) {
                return false;
            }
            isVisited[c] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "abcdefghijklm";
        String b = "abcadefghijklm";
        String c = "abcadefghijkla";
        System.out.println(hasUniqueCharacters(a));
        System.out.println(hasUniqueCharacters(b));
        System.out.println(hasUniqueCharacters(c));
    }
}
