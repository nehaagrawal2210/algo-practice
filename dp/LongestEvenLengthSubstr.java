package dp;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/14/2017.
 */

public class LongestEvenLengthSubstr extends TestCase{
//    http://www.geeksforgeeks.org/longest-even-length-substring-sum-first-second-half/
    public int getLength(String s)
    {
        int l,r,leftSum,rightSum,res=Integer.MIN_VALUE;
        //take i as intermediate
        for (int i = 0; i < s.length(); i++) {
            l=i;
            r=i+1;
            leftSum=rightSum=0;
            while (r<s.length() && l>=0)
            {
                leftSum= leftSum+ Character.getNumericValue(s.charAt(l));
                rightSum= rightSum+Character.getNumericValue(s.charAt(r));
                if(leftSum==rightSum)
                    res=Math.max(res,r-l+1);
                l--;
                r++;
            }
        }
        return res;
    }

    @Test
    public void testGetLength()
    {
        String str = "123123";
        assertEquals(6,getLength(str));
    }
}
