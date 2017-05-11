package leetcode;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neagrawa on 5/1/17.
 */
public class PermutationInString extends TestCase{

    public boolean checkInclusion(String s1, String s2) {

        int[] needToFind = new int[256];
        int[] hasFound = new int[256];

        int s1Len = s1.length();
        for (int i = 0; i < s1Len; i++) needToFind[s1.charAt(i)]++;

        for (int start=0,end = 0,len=0; start<s2.length() && end < s2.length(); end++) {
            char c = s2.charAt(end);
            hasFound[c]++;
            if(needToFind[c]==0)
            {
                while(start<=end) hasFound[s2.charAt(start++)]--;
                len=0;
            }
            else{
                while (hasFound[c]>needToFind[c]){
                    hasFound[s2.charAt(start++)]--;
                    len--;
                }
                len++;
                if(len == s1Len) return true;
            }
        }
        return false;
    }


    public void testCheckInclusion()
    {
        assertTrue(checkInclusion("ab","eidbaooo"));
        assertFalse(checkInclusion("ab","eidboaoo"));
        assertFalse(checkInclusion("hello","ooolleoooleh"));
        assertFalse(checkInclusion("prosperity","properties"));
        assertTrue(checkInclusion("adc","dcda"));
    }
}
