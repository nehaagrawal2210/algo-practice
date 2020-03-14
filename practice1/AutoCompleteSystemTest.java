package practice1;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AutoCompleteSystemTest extends TestCase {

    @Test
    public void testAutocomplete() {
        String[] sentences = { "i love you", "island", "ironman", "i love leetcode" , "tether"};
        int[] times = { 5, 3, 2, 2,1 };
        char c = 'i';
        AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
        List<String> res = obj.input(c);
        List<String> res1 = obj.input(' ');
        List<String> res2 = obj.input('a');
        List<String> res3 = obj.input('#');
        List<String> res4 = obj.input('t');
        obj.input('#');
        System.out.println(Arrays.toString(res.toArray()));
        System.out.println(Arrays.toString(res1.toArray()));
        System.out.println(Arrays.toString(res2.toArray()));
        System.out.println(Arrays.toString(res3.toArray()));
        System.out.println(Arrays.toString(res4.toArray()));
    }
}
