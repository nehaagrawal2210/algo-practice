package practice;

import junit.framework.TestCase;

/**
 * Created by neagrawa on 6/4/17.
 */
public class Knapsack extends TestCase {
    public int knapSack(int[] val,int[] w,int W,int n)
    {
        if(n==0 || W==0) return 0;
        if(w[n-1]>W) return knapSack(val,w,W,n-1);
        return Math.max(knapSack(val,w,W,n-1),val[n-1]+knapSack(val,w,W-w[n-1],n-1));
    }

    public int knapSackDP(int[] val,int[] w,int W)
    {
        int n = val.length;
        int[][] dp = new int[W+1][n+1];
        for (int i = 0; i < W+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if(i==0 || j==0) dp[i][j]=0;
                else dp[i][j]= i-w[j-1]>=0 ? Math.max(val[j-1]+dp[i-w[j-1]][j-1],dp[i][j-1])
                        : dp[i][j-1];
            }
        }
        return dp[W][n];
    }

    public void testKnapsasck()
    {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;
        int n = val.length;
        System.out.println(knapSack(val,wt,W,n));
        System.out.println(knapSackDP(val,wt,W));
    }
}
