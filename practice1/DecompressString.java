package practice1;

import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

//https://techdevguide.withgoogle.com/resources/compress-decompression/?types=coding-interview-question#code-challenge
public class DecompressString extends TestCase {
//    Input: 3[abc]4[ab]c
//    Output: abcabcabcababababc
//
//    Input: 10[a]
//    Output: aaaaaaaaaa
//
//    Input: 2[3[a]b]
//    Output: aaabaaab

//    Consider edge cases: a[]b, 0[abc]

    public String decompress(String expr) {
        Stack<String> stack = new Stack<>();

        for (int i = expr.length() - 1; i >= 0; i--) {
            char c = expr.charAt(i);
            if (isInputCharacter(c)) {
                stack.push(String.valueOf(c));
            } else if (c == '[') {
                StringBuilder repeatString = new StringBuilder();
                while (!stack.peek().equals(String.valueOf(']'))) {
                    repeatString.append(stack.pop());
                }
                //pop the square bracket
                stack.pop();

                //extract the repetition count
                int j = i - 1;
                int count = 0;
                int multiplicative = 1;
                while (j >= 0 && isDigit(expr.charAt(j))) {
                    count = multiplicative * Character.getNumericValue(expr.charAt(j)) + count;
                    multiplicative = multiplicative * 10;
                    j--;
                }
                i = j + 1;
                String repeatStringExpr = repeatString(repeatString.toString(), count);
                stack.push(repeatStringExpr);
            }
        }
        StringBuilder decompressedString = new StringBuilder();
        while (!stack.isEmpty()) {
            decompressedString.append(stack.pop());
        }
        return decompressedString.toString();
    }

    private String repeatString(String str, int times) {
        StringBuilder repeatStr = new StringBuilder();
        for (int i = 0; i < times; i++) {
            repeatStr.append(str);
        }
        return repeatStr.toString();
    }

    private boolean isDigit(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    private boolean isInputCharacter(char c) {
        if (c == ']' || (c >= 'a' && c <= 'z')) {
            return true;
        }
        return false;
    }

    public int numJewelsInStones(String jewels, String stone) {
        Set<Character> jewelTypes = new HashSet<>();

        for(int i=0;i<jewels.length();i++){
            jewelTypes.add(jewels.charAt(i));
        }

        int jewelCount = 0;
        for(int i=0;i<stone.length();i++){
            if(jewelTypes.contains(stone.charAt(i))){
                jewelCount++;
            }
        }
        return jewelCount;
    }

    public void testCount(){
        System.out.println(Character.getNumericValue('z'));
        System.out.println(Character.getNumericValue('Z'));
        System.out.println(numJewelsInStones("z","ZZ"));
    }

    public void testDecompress() {
        System.out.println(decompress("1[2[3[4[5[6[7[8[9[a]]]]]]]]]"));
        System.out.println(decompress("10[a]"));
        System.out.println(decompress("3[abc]4[ab]c"));
        System.out.println(decompress("2[3[a]b]"));
        System.out.println(decompress("a[]b"));
        System.out.println(decompress("0[abc]"));
    }
}
