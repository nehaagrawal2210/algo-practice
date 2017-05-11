package dp;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/10/2017.
 */
public class MaxSumIncreasingSubsequence extends TestCase{

    public int getMaxIncreasingSubsequenceSum(int a[])
    {
        int lisSum[]=new int[a.length];
        lisSum[0]=a[0];
        int maxSum=Integer.MIN_VALUE;

        for (int i = 1; i <a.length ; i++) {
            for (int j = 0; j < i; j++) {
                if((a[j]<a[i]) && lisSum[i]<lisSum[j]+a[i])
                {
                    lisSum[i]=lisSum[j]+a[i];
                    maxSum=Math.max(maxSum,lisSum[i]);
                }

            }
        }
        return maxSum;
    }

    public int getMaxIncreasingLen(int a[])
    {
        int tail[]=new int[a.length];
        tail[0]=a[0];
        int len=1;
        for (int i = 1; i < a.length; i++) {
            if(a[i]<tail[0]) //replace the last tail with smallest value
            tail[0]=a[i];
            else if(a[i]>tail[len-1]) //increasing the length of lis
                tail[len++]=a[i];
            else {
                //element lies in middle
                int ceilIndex=getCeilIndex(tail,0,len-1,a[i]);
                tail[ceilIndex]=a[i];
            }
        }
        System.out.println(len);
        return len;
    }

    public int getCeilIndex(int tail[],int l,int r,int key)
    {
        int m;
        while (r-l>1)
        {
            m=l+(r-l)/2;
            if(tail[m]>=key)
                r=m;
            else
                l=m;
        }
        return r;
    }

    @Test
    public void testGetMaxIncreasingSubsequenceSum()
    {
        int a[]={1,101,2,3,100,4,5};
        int maxSum=getMaxIncreasingSubsequenceSum(a);
        assertEquals(106,maxSum);
    }

    @Test
    public void testGetMaxIncreasingSum()
    {
        int a[]={1,101,2,3,100,4,5};
        int maxSum=getMaxIncreasingLen(a);
        assertEquals(5,maxSum);
    }
}
