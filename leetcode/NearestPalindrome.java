package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neagrawa on 4/26/17.
 */
public class NearestPalindrome extends TestCase{

    public String nearestPalindromic(String n) {
            if(Long.parseLong(n)<=10) return Long.toString(Long.parseLong(n)-1);
            String smallerPal = getSmallerPalindrome(n,getApproxPalindrome(n));
            String largerPal = getLargerPalindrome(n,getApproxPalindrome(n));
            long sDiff = Long.parseLong(n) - Long.parseLong(smallerPal);
            long lDiff = Long.parseLong(largerPal) - Long.parseLong(n);
            if(sDiff<lDiff) return smallerPal;
            else if (sDiff == lDiff)  return smallerPal;
            else return largerPal;
    }

    public String getSmallerPalindrome(String inputNumber, String approxPalindrome)
    {
        long inputNo = Long.parseLong(inputNumber);
        long palindrome = Long.parseLong(approxPalindrome);
        if(palindrome<inputNo) return approxPalindrome;
        //processing for smaller palindrome
        int midDigitIndex = inputNumber.length()/2;
        int midDigit = Integer.parseInt(approxPalindrome.substring(midDigitIndex,midDigitIndex+1));
        if(Integer.parseInt(approxPalindrome.substring(midDigitIndex,midDigitIndex+1))!=0 && inputNo>15)
        {
            if(isEvenLength(inputNumber))
                approxPalindrome = approxPalindrome.substring(0,midDigitIndex-1)
                        +  (midDigit -1) + (midDigit-1) + approxPalindrome.substring(midDigitIndex+1);
            else approxPalindrome = approxPalindrome.substring(0,midDigitIndex) + (midDigit-1)
                    + approxPalindrome.substring(midDigitIndex+1);
            return approxPalindrome;
        }
        String roundNum = getRoundDown(inputNumber);
        return getSmallerPalindrome(inputNumber,getApproxPalindrome(roundNum));
    }

    public String getLargerPalindrome(String inputNumber, String approxPalindrome)
    {
        long inputNo = Long.parseLong(inputNumber);
        long palindrome = Long.parseLong(approxPalindrome);
        if(palindrome>inputNo) return approxPalindrome;
        //processing for larger palindrome
        int midDigitIndex = inputNumber.length()/2;
        int midDigit = Integer.parseInt(approxPalindrome.substring(midDigitIndex,midDigitIndex+1));
        if(Integer.parseInt(approxPalindrome.substring(midDigitIndex,midDigitIndex+1))!=9)
        {
            if(isEvenLength(inputNumber))
                approxPalindrome = approxPalindrome.substring(0,midDigitIndex-1)
                        +  (midDigit +1) + (midDigit+1) + approxPalindrome.substring(midDigitIndex+1);
            else approxPalindrome = approxPalindrome.substring(0,midDigitIndex) + (midDigit+1)
                    + approxPalindrome.substring(midDigitIndex+1);
            return approxPalindrome;
        }
        else return getLargerPalindrome(inputNumber, getApproxPalindrome(getRoundUp(inputNumber)));
    }

    public String getRoundDown(String number)
    {
        //assuming middle numbers are 0
        long num = Long.parseLong(number);
        if(num==0) return number;
        long increment= number.length()==2? 10: (long) Math.pow(10,number.length()/2+1);
        Long roundNo = ((long) (num/increment)) * increment -1;
        return roundNo.toString();
    }

    public String getRoundUp(String number)
    {
        //assuming middle numbers are 9
        long num = Long.parseLong(number);
        long increment= (long) Math.pow(10,number.length()/2+1);
        Long roundNo = ((num/increment)+1) * increment;
        return roundNo.toString();
    }

    public String getApproxPalindrome(String num)
    {
        int midDigit = num.length()/2;
        String result;
        if(isEvenLength(num))
            result= num.substring(0,midDigit)
                    + new StringBuffer(num.substring(0,midDigit)).reverse().toString();
        else
            result = num.substring(0,midDigit) + num.substring(midDigit,midDigit+1)
                    + new StringBuffer(num.substring(0,midDigit)).reverse().toString();
        return result;
    }

    public boolean isEvenLength(String num)
    {
        return (num.length()%2 == 0) ? true : false;
    }

    public String getNearestPalindrome(String n)
    {
        long inputNum = Long.parseLong(n);
        if(inputNum == 0 ) return "1";
        if(inputNum<=10 && inputNum>0) return Long.toString(inputNum-1);
        if(inputNum==11) return "9";
        int length = n.length();
        long[] increment = {-1,0,1};
        long[] candidates=  new long[3];
        long leftHalfNum = Long.parseLong(n.substring(0,length/2));
        for (int i = 0; i < candidates.length; i++) {
            Long incrementedNo = leftHalfNum+increment[i];
            candidates[i]= length%2 == 0 ? Long.parseLong(incrementedNo + getReverse(incrementedNo) )
                                         : Long.parseLong(incrementedNo + n.substring(length/2,length/2+1) + getReverse(incrementedNo));
        }
        Long ans=null;
        for (long candidate: candidates)
        {
            if(candidate!=inputNum && candidate!=0) {
                if (ans == null || getDelta(inputNum, candidate) < getDelta(inputNum, ans)
                        || (getDelta(inputNum, candidate) == getDelta(inputNum, ans) && candidate < ans))
                    ans = candidate;
            }
        }
        return ans.toString();
    }

    public long getDelta(Long input,Long ans)
    {
        return Math.abs(input-ans);
    }

    public String getReverse(Long num)
    {
        char[] longNum = num.toString().toCharArray();
        int start = 0, end=longNum.length-1;
        while (start<end)
        {
            char temp = longNum[start];
            longNum[start]= longNum[end];
            longNum[end]= temp;
            start++;
            end--;
        }
        return new String(longNum);
    }

    @Test
    public void testGetNearestPalindrome()
    {
//        assertEquals("11",nearestPalindromic("10"));
//        assertEquals("2002",getNearestPalindrome("1997"));
//        assertEquals("750057",getNearestPalindrome("750018"));
//        assertEquals("0",nearestPalindromic("214747413474137412"));
//        assertEquals("1221",getNearestPalindrome("1213"));
//        assertEquals("9",getNearestPalindrome("10"));
//        assertEquals("9",getNearestPalindrome("11"));
//        assertEquals("77",getNearestPalindrome("73"));
        System.out.println(getNearestPalindrome("100"));
        System.out.println(getNearestPalindrome("807045053224792883"));
    }

}
