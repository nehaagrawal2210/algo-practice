package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neagrawa on 4/19/17.
 */
public class NextGreaterValue extends TestCase{

    @Test
    public void testNextGreaterElement()
    {
        assertEquals(21,nextGreaterElement(12));
        assertEquals(-1,nextGreaterElement(21));
        assertEquals(34576,nextGreaterElement(34567));
        assertEquals(9876157,nextGreaterElement(9875761));
        assertEquals(-1,nextGreaterElement(2147483647));
        assertEquals(12223233,nextGreaterElement(12222333));
        assertEquals(13222344,nextGreaterElement(12443322));
        assertEquals(213456789,nextGreaterElement(198765432));
    }

    public int nextGreaterElement(int n)
    {
        String s=""+n;
        char[] digits=s.toCharArray();
        int len=s.length()-2;
        while (len>=0 && Character.getNumericValue(digits[len])>=Character.getNumericValue(digits[len+1]))
        {
            len--;
        }
        if(len<0) return -1; //given number is in descending order hence no greater value possible

        int start=len+1,end=s.length()-1;
        while (start<end)
        {
            swap(digits,start,end);
            start++;
            end--;
        }

        //the digits after len are in sorted, we need to find ceil value for current digit
        int ceilIndex=getCeilIndex(digits,Character.getNumericValue(digits[len]),len+1,digits.length-1);

        //swap this and ceil value
        swap(digits,ceilIndex,len);

        try {
            return Integer.parseInt(new String(digits));
        }
        catch (NumberFormatException e)
        {
            return -1;
        }
    }

    public void swap(char[] c,int one,int two)
    {
        char temp=c[one];
        c[one]=c[two];
        c[two]=temp;
    }

    public int getCeilIndex(char[] a,int key,int low,int high)
    {
        if(Character.getNumericValue(a[low])>key) return low;
        else if(high-low>1)
        {
            int mid=low+(high-low)/2;
            if(Character.getNumericValue(a[mid])>key && Character.getNumericValue(a[mid-1])<key)
                return mid;
            else if(Character.getNumericValue(a[mid])>key) return getCeilIndex(a,key,low,mid);
            else return getCeilIndex(a,key,mid,high);
        }
        if(Character.getNumericValue(a[low])<=key && Character.getNumericValue(a[high])>key) return high;
        else if(Character.getNumericValue(a[low])==Character.getNumericValue(a[high])) return low;
        else return -1;
    }

}
