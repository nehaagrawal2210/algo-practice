package misc;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neagrawa on 4/20/17.
 */
public class GetCeilValue extends TestCase{

    public int getCeilValue(int[] a, int key)
    {
        return getCeilValue(a,key,0,a.length-1);
    }

    public int getCeilValue(int[] a,int key,int low,int high)
    {
        if(a[low]>key) return low;
        else if(high-low>1)
        {
            int mid=low+(high-low)/2;
            if(a[mid]>key && a[mid-1]<key)
                return mid;
            else if(a[mid]>key) return getCeilValue(a,key,low,mid);
            else return getCeilValue(a,key,mid,high);
        }
        if(a[low]<=key && a[high]>key) return high;
        else if(a[low]==a[high]) return low;
        else return -1;
    }

    @Test
    public void testGetCeilValue()
    {
        assertEquals(0,getCeilValue(new int[]{2,5,8,10},1));
        assertEquals(1,getCeilValue(new int[]{2,5,8,10},3));
        assertEquals(2,getCeilValue(new int[]{2,5,8,10},6));
        assertEquals(3,getCeilValue(new int[]{2,5,8,10},9));
        assertEquals(0,getCeilValue(new int[]{2,2,5,8,10},1));
        assertEquals(1,getCeilValue(new int[]{1,2,2,5,8,10},1));
        assertEquals(0,getCeilValue(new int[]{2,3,4,5,6,7,8,9},1));
        assertEquals(2,getCeilValue(new int[]{2,2,3,3,4,4},2));
        assertEquals(0,getCeilValue(new int[]{3,3,3},2));
    }
}
