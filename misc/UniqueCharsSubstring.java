package misc;

import junit.framework.TestCase;
import org.junit.*;

/**
 * Created by neha on 3/6/2017.
 */
//http://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
public class UniqueCharsSubstring extends TestCase {
    public void getSubString(String s,int k)
    {
        int l=s.length();
        int hasFound[]=new int[26];
        int maxWindowSize = Integer.MIN_VALUE, u=0;
        String str=null;
        for (int currStart=0,currEnd=0; currEnd < l; currEnd++) {
            char c = s.charAt(currEnd);
            if(hasFound[c-'a']==0) u++;
            hasFound[c-'a']++;
            if(u>k) {
                int prevCurrStart = currStart;
                while (hasFound[s.charAt(prevCurrStart) - 'a'] != 0) {
                    hasFound[s.charAt(currStart) - 'a']--;
                    prevCurrStart = currStart;
                    currStart++;
                }
                u--;
            }
            else if (u==k){
                int len=currEnd-currStart+1;
                if(len>maxWindowSize)
                {
                    len=maxWindowSize;
                    str=s.substring(currStart,currEnd+1);
                }
            }
        }

        if(u<k)
            System.out.println("Not enough chars");
        else System.out.println(str);
    }

    @org.junit.Test
    public void testGetUniqueChars()
    {
        String s="aabacbebebedddd";
        int k=4;
        getSubString(s,k);
    }
}
