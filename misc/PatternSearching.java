package misc;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/15/2017.
 */
public class PatternSearching extends TestCase{

    /**
     * Naive pattern search O(n^2)
     * @param text
     * @param pattern
     */
    public void patternSearch(String text,String pattern)
    {
        int j,m=pattern.length();
        for (int i = 0; i <= text.length()-pattern.length(); i++) {
            for (j = 0; j < pattern.length(); j++) {
                if(text.charAt(i+j)!=pattern.charAt(j))
                    break;
            }
            if(j==m)
                System.out.println("Pattern found at "+i);
        }
    }

    /**
     * LPS array computation for KMP algo
     * @param pattern
     * @return
     */
    public int[] computeLPSArray(String pattern)
    {
        int len=0,i=1,m=pattern.length();
        int lps[]=new int[m];
        lps[0]=0;
        while (i<m)
        {
            if(pattern.charAt(i)==pattern.charAt(len))
                lps[i++]=++len;
            else if(len==0)
                lps[i++]=0;
            else len = lps[len-1];
        }
        return lps;
    }

    public void kmpPatternSearching(String text,String pattern)
    {
        int m= pattern.length();
        int n= text.length();

        //compute lps array
        int[] lps = computeLPSArray(pattern);
        int i=0,j=0;
        while (i<n)
        {
            if(pattern.charAt(j)==text.charAt(i))
            {
                j++;
                i++;
            }
            else //if(i<n && pattern.charAt(j)!=pattern.charAt(i))
            {
                if(j!=0) j=lps[j-1];
                else i++;
            }
            if(j==m)
            {
                System.out.println("Pattern found "+(i-j));
                j= lps[j-1];
            }
        }
    }

    @Test
    public void testPatternSearching()
    {
        String text="AABAACAADAABAAABAA";
        String pat="AABA";
        patternSearch(text,pat);
        String txt = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        kmpPatternSearching(txt,pattern);
        kmpPatternSearching(text,pat);
    }
}
