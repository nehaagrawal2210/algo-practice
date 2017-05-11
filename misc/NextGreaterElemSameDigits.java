package misc;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/24/2017.
 */
public class NextGreaterElemSameDigits extends TestCase {
//    http://www.geeksforgeeks.org/find-next-greater-number-set-digits/
    public int getNextGreaterElem(String a)
    {
        if(a.length()==1) return Integer.MIN_VALUE;

        char[] val= a.toCharArray();
        int prevDigit = a.length()-1;
        int currentDigit= a.length()-2;
        int index=a.length()-3;
        while (val[currentDigit]>val[prevDigit] && index>=0)
        {
            prevDigit   = currentDigit;
            currentDigit = index--;
        }
        if(index<0) return Integer.MIN_VALUE; //number in descending order
        index=a.length()-1;
        while (val[index]<val[currentDigit] && index>currentDigit)
        {
            index--;
        }
        char c=a.charAt(currentDigit);
        val[currentDigit]= val[index];
        val[index]=c;

        for (int j = val.length-1,i=currentDigit+1; i < j; i++,j--) {
            c=val[i];
            val[i]=val[j];
            val[j]=c;
        }

        return Integer.parseInt(String.valueOf(val));
    }

    @Test
    public void testGetNextGreaterElem()
    {
        String s = "218765";
        assertEquals(251678,getNextGreaterElem(s));
        assertEquals(1243,getNextGreaterElem("1234"));
        assertEquals(Integer.MIN_VALUE,getNextGreaterElem("4321"));
        assertEquals(536479,getNextGreaterElem("534976"));
    }
}

