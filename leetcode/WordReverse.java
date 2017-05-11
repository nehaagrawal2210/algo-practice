package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by neagrawa on 4/19/17.
 */
public class WordReverse extends TestCase {

    public String reverseWords(String s) {
        String result=null,currWord;
        s+=" ";
        for (int i = 0,start=0; i <s.length(); i++) {
            if(s.charAt(i)==' ') //if character is blank space a word is encountered
            {
                currWord = new StringBuffer(s.substring(start,i)).reverse().toString();
                result = (result==null)? currWord : result+" "+currWord;
                start=i+1;
            }
        }
        return result;
    }

    @Test
    public void testReverseWords()
    {
        String s="Let me take a long.... nap";
        assertEquals("teL em ekat a ....gnol pan",reverseWords(s));
    }
}
