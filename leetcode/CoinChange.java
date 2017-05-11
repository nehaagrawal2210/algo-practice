package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neagrawa on 5/11/17.
 * https://leetcode.com/problems/coin-change/#/description
 */
public class CoinChange extends TestCase{
    public int coinChange(int[] coins, int amount) {
        int coinsCount = coinChangeRec(coins,amount,coins.length-1,0);
        if(coinsCount == Integer.MAX_VALUE) return -1;
        return coinsCount;
    }

    public int coinChangeRec(int[] coins, int amount, int i, int coinCount)
    {
        if(amount == 0) return coinCount;
        if(i<0) return Integer.MAX_VALUE;
        if(coins[i]>amount) return coinChangeRec(coins,amount,i-1,coinCount);
        //exclude current coin
        int exCoinCount = coinChangeRec(coins,amount,i-1,coinCount);
        //include current coin
        int inCoinCount = coinChangeRec(coins,amount-coins[i],i,coinCount+1);
        return Math.min(exCoinCount,inCoinCount);
    }

    public int coinChangeDP(int[] coins, int amount)
    {
        int[][] dp = new int[coins.length+1][amount+1];
        for (int i = 0; i <= amount; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0]=0;
            for (int j = 1; j <= amount; j++) {
                if(coins[i-1]<=j)
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-coins[i-1]] == Integer.MAX_VALUE
                            ? Integer.MAX_VALUE : dp[i][j-coins[i-1]] +1);
                else
                    dp[i][j]= dp[i-1][j];
            }
        }
        return dp[coins.length][amount] == Integer.MAX_VALUE ? -1 : dp[coins.length][amount];
    }

    public int coinChangeDPMethod2(int[] coins, int amount)
    {
        int[]dp = new int[amount+1];
        for (int i = 0; i < amount+1; i++) dp[i] = amount+1;
        dp[0]=0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(coins[j]<=i)
                dp[i] = Math.min(dp[i], //without current coin as previously calculated value for this amount
                                 dp[i-coins[j]] + 1 //with current coin, increase coin count by 1 as we are using current coin
                                );
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    @Test
    public void testCoinChange()
    {
        assertEquals(3, coinChange(new int[]{1,2,5},11));
        assertEquals(3, coinChangeDP(new int[]{1,2,5},11));
        assertEquals(-1, coinChangeDP(new int[]{2},3));
        assertEquals(3, coinChangeDPMethod2(new int[]{1,2,5},11));
    }
}
