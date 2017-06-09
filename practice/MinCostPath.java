package practice;

import junit.framework.TestCase;

/**
 * Created by neagrawa on 6/4/17.
 */
public class MinCostPath extends TestCase{
    public int getMinCostPath(int[][] a, int m,int n)
    {
        if(n<0 || m<0) return Integer.MAX_VALUE;
        else if(m==0 && n==0) return a[m][n];
        else return a[m][n]+  Math.min(getMinCostPath(a,m-1,n),Math.min(getMinCostPath(a,m,n-1),getMinCostPath(a,
                    m-1,n-1)));
    }

    public int getMinCostPathDP(int[][] cost,int m,int n)
    {
        int dp[][]=new int[m][n];
        for (int i = 0; i <m; i++) {
            for (int j = 0; j <n; j++) {
                if(i==0 && j==0) dp[i][j]= cost[i][j];
                else if(i==0) dp[i][j]=dp[i][j-1]+cost[i][j];
                else if(j==0) dp[i][j]=dp[i-1][j]+cost[i][j];
                else dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+cost[i][j];
            }
        }
        return dp[m-1][n-1];
    }

    public int getMaxCostPath(int[][] a,int m,int n)
    {
        if(n<0 || m<0) return Integer.MIN_VALUE;
        else if(m==0 && n==0) return a[m][n];
        else return
            a[m][n]+ Math.max(getMaxCostPath(a,m-1,n),
                    Math.max(getMaxCostPath(a,m,n-1),getMaxCostPath(a,m-1,n-1)));
    }

    public int getMaxCostPath(int[][] a)
    {
        int m = a.length;
        int n=a[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0 && j==0) dp[i][j]=a[i][j];
                else if(i==0) dp[i][j]=dp[i][j-1]+a[i][j];
                else if(j==0) dp[i][j]=dp[i-1][j]+a[i][j];
                else dp[i][j] = Math.max(dp[i-1][j],Math.max(dp[i][j-1],dp[i-1][j-1]))+a[i][j];
            }
        }
        return dp[m-1][n-1];
    }

    public void testGetMinCostPath()
    {
        int cost[][] = { {1, 2, 3},
                         {4, 8, 2},
                         {1, 5, 3} };
        System.out.println(getMinCostPath(cost,2,2));
        System.out.println(getMinCostPathDP(cost,3,3));
        System.out.println(getMaxCostPath(cost,2,2));
        System.out.println(getMaxCostPath(cost));
    }
}
