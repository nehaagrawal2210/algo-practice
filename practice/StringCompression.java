package practice;

public class StringCompression {
    //aabcccccaaa = a2b1c5a3 if length of compressed string is larger than original then return original

    public static String compress(String word) {
        StringBuilder compressedString = new StringBuilder();
        int currentCharCount = 0;
        for (int i = 0; i < word.length(); i++) {
            currentCharCount++;
            if (i + 1 >= word.length() || word.charAt(i) != word.charAt(i + 1)) {
                compressedString = compressedString.append(word.charAt(i)).append(currentCharCount);
                currentCharCount = 0;
            }
        }
        if (compressedString.length() > word.length()) {
            return word;
        }
        return compressedString.toString();
    }

    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
    }
}
