package misc;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 3/3/2017.
 */
//http://stackoverflow.com/questions/3592079/minimum-window-width-in-string-x-that-contains-all-characters-in-string-y
//    http://articles.leetcode.com/finding-minimum-window-in-s-which/
public class ShortestSubstringWithAllCharacters extends TestCase{

    public String getShortestSubstring(String S,String T)
    {
        int tLen=T.length(),sLen=S.length();
        int[] needToFind=new int[256];
        int[] hasFound= new int[256];
        for (int i = 0; i < tLen; i++) {
            needToFind[T.charAt(i)]++;
        }
        int minSubStringLen = Integer.MAX_VALUE,subStringLen;
        String minSubstring="";
        int count=0;//to track count of covered letters in T
        char currentChar;
        for (int begin = 0,end = 0; end < sLen; end++) {
            currentChar = S.charAt(end);
            if(needToFind[currentChar] == 0) continue;
            hasFound[currentChar]++;
            if(hasFound[currentChar]<=needToFind[currentChar])
                count++;

            //if all characters are covered
            if(count == tLen) {
//                reduce the window to minimum possible
                while (needToFind[S.charAt(begin)] == 0
                        || hasFound[S.charAt(begin)] > needToFind[S.charAt(begin)])
                {
                    if (hasFound[S.charAt(begin)] > needToFind[S.charAt(begin)]) hasFound[S.charAt(begin)]--;
                    ++begin;
                }
                subStringLen = end - begin + 1;
                if (subStringLen < minSubStringLen) {
                    minSubStringLen = subStringLen;
                    minSubstring = S.substring(begin, end + 1);
                }
            }
        }
        return (count == tLen) ? minSubstring : null;
    }

    @Test
    public void testGetMinSubstring()
    {
        String S= "ADOBECODEBANC";
        String T= "ABC";

        assertEquals("BANC",getShortestSubstring(S,T));

        String S1="this is a test string";
        String T1="tist";

        assertEquals("t stri",getShortestSubstring(S1,T1));

        System.out.println(getShortestSubstring("cabeca","cae"));
        System.out.println(getShortestSubstring("cabefgecdaecf","cae"));
    }
}
