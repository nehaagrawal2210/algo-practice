package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neagrawa on 5/9/17.
 */
public class CoinChange2 extends TestCase{
    public int getCoinChangeRec(int[] coins, int N, int i)
    {
        if(N == 0) return 1;
        if(i<0) return 0;
        int ways = 0;

        //if ith value is less than value of N ignore it
        if(coins[i]>N) ways += getCoinChangeRec(coins,N,i-1);
        else{
           //include ith element
            ways += getCoinChangeRec(coins,N-coins[i],i);
            //exclude ith element
            ways += getCoinChangeRec(coins,N,i-1);
        }
        return ways;
    }

    public int getCoinChangeDP(int[] coins, int N)
    {
        int[][] dp = new int[coins.length+1][N+1];
        dp[0][0]=1;

        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= N; j++) {
                    dp[i][j] = dp[i-1][j] + (j>=coins[i]?dp[i][j-coins[i]]:0);
            }
        }

        return dp[coins.length][N];
    }

    @Test
    public void testGetCoinChange()
    {
        System.out.println(getCoinChangeRec(new int[]{1,2,3},4,2));
        System.out.println(getCoinChangeDP(new int[]{1,2,3},4));
    }
}
