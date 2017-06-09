package practice;

import junit.framework.TestCase;

/**
 * Created by neagrawa on 6/4/17.
 */
public class CuttingRod extends TestCase{
    public int cutRod(int[] price, int n)
    {
        if(n<=0) return 0;
        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            maxVal = Math.max(maxVal, price[i]+cutRod(price,n-i-1));
        }
        return maxVal;
    }

    public int cutRodDP(int[] price)
    {
        int n = price.length;
        int val[] = new int[n+1];
        val[0]=0;
        for (int rodLen = 1; rodLen <=n ; rodLen++) {
            int maxVal = Integer.MIN_VALUE;
            for (int j = 0; j < rodLen; j++) {
                maxVal = Math.max(maxVal,price[j]+val[rodLen-j-1]);
            }
            val[rodLen]=maxVal;
        }
        return val[n];
    }

    public void testCutRod()
    {
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(arr,arr.length));
        System.out.println(cutRodDP(arr));
    }
}
