package practice1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Assert;

import junit.framework.TestCase;

public class NonRepeatingCharacter extends TestCase {

    public void testNonRepeatingCharacter() {
        String a = "aabc";
        List<Character> expected = Arrays.asList('a', (char) -1, 'b', 'b');
        List<Character> output = getFirstNonRepeating(a);
        Assert.assertEquals(expected, output);
    }

    public void testNonRepeatingCharacterLong() {
        String a = "geeksforgeeksandgeeksquizfor";
        List<Character> expected = Arrays.asList('g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'k', 'k', 'k', 's', 'f', 'f',
                'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'o', 'r', 'a');
        List<Character> output = getFirstNonRepeating(a);
        Assert.assertEquals(expected, output);
    }

    private List<Character> getFirstNonRepeating(String a) {
        int[] count = new int[26];
        Queue<Character> q = new LinkedList<>();
        List<Character> res = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            q.add(c);
            count[c - 'a']++;
            while (!q.isEmpty() && count[q.peek() - 'a'] > 1) {
                q.poll();
            }
            res.add(q.isEmpty() ? (char) -1 : q.peek());
        }
        return res;
    }
}
