package practice;

public class URLifyString {
    public static String urlify(String word) {
        int spaceCount = 0;
        word = word.trim();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        int newCharCount = word.length() + spaceCount * 2;
        char[] urlifiedChar = new char[newCharCount];
        int resultIndexCount = newCharCount - 1;
        for (int i = word.length() - 1; i >= 0; i--) {
            char c = word.charAt(i);
            if (c == ' ') {
                urlifiedChar[resultIndexCount] = '0';
                urlifiedChar[resultIndexCount - 1] = '2';
                urlifiedChar[resultIndexCount - 2] = '%';
                resultIndexCount = resultIndexCount - 3;
            } else {
                urlifiedChar[resultIndexCount--] = c;
            }
        }
        return new String(urlifiedChar);
    }

    public static void main(String[] args) {
        String a = "Mr John Smith  ";
        System.out.println(urlify(a));
    }
}
