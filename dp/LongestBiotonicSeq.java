package dp;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/10/2017.
 */
//http://www.geeksforgeeks.org/dynamic-programming-set-15-longest-bitonic-subsequence/
public class LongestBiotonicSeq extends TestCase{

    public int getLBS(int a[])
    {
        int l=a.length;
        //find lis
        int[] lis=new int[l];
        int[] lds=new int[l];

//        LIS initialization
        for (int i = 0; i < l; i++) {
            lis[i]=1;
            lds[i]=1;
        }

//      LIS calculation
        for (int i = 1; i < l; i++) {
            for (int j = 0; j < i; j++) {
                if ((a[j]<a[i]) && lis[i]<lis[j]+1)
                    lis[i]=lis[j]+1;
            }
        }

//      LDS calculation
        for (int i = l-2; i >=0 ; i--) {
            for (int j = l-1; j >=0 ; j--) {
                if((a[j]<a[i]) && lds[i]<lds[j]+1)
                    lds[i]=lds[j]+1;
            }
        }

//        calculate LBS
        int maxL=Integer.MIN_VALUE;
        for (int i = 0; i < l; i++) {
            maxL=Math.max(maxL,lis[i]+lds[i]-1);
        }

        return maxL;
    }

    @Test
    public void testGetLBS(){
        int a1[]={1, 11, 2, 10, 4, 5, 2, 1};
        int a2[]={12, 11, 40, 5, 3, 1};
        int a3[]={80, 60, 30, 40, 20, 10};
        int a4[]={1,5,2,8,9,11,3,0,5,6};

        assertEquals(6,getLBS(a1));
        assertEquals(5,getLBS(a2));
        assertEquals(5,getLBS(a3));
        assertEquals(7,getLBS(a4));
    }
}
