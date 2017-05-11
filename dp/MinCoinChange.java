package dp;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/13/2017.
 */
public class MinCoinChange extends TestCase{

    public static int getCoinChangeRec(int coins[],int n,int totalVal)
    {
        if(totalVal==0)
            return 0;
        if(n==0)
            return Integer.MAX_VALUE;
        if(coins[n-1]>totalVal)
            return getCoinChangeRec(coins,n-1,totalVal);
        int subRes1=getCoinChangeRec(coins,n-1,totalVal); //excluding last coin
        int subRes2=getCoinChangeRec(coins,n-1,totalVal-coins[n-1]); //including last coin

        if(subRes2!=Integer.MAX_VALUE && subRes2+1<subRes1)
            return subRes2+1;
        return subRes1;
    }

    public static int getCoinChangeRecDP(int coins[],int n,int totalVal)
    {
        int coinChange[][]=new int[n+1][totalVal+1];
        int res1,res2;
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < totalVal+1; j++) {
                if(j==0) coinChange[i][j]=0;
                else if(i==0) coinChange[i][j]=Integer.MAX_VALUE;
                else if(coins[i-1]<=j){
                    res1=coinChange[i-1][j]; //excluding last coin
                    res2=coinChange[i-1][j-coins[i-1]];
                    if(res2!=Integer.MAX_VALUE && res2+1<res1)
                        coinChange[i][j]=res2;
                    else coinChange[i][j]=res1;
                }
                else {
                    coinChange[i][j]=coinChange[i-1][j];
                }
            }
        }
        return coinChange[n][totalVal];
    }

    @Test
    public void testGetCoinChangeRec()
    {
        int coins[] =  {9, 6, 5, 1,1};
        int val = 11;
        int minCoins=getCoinChangeRec(coins,coins.length,val);
        int minCoinsDP=getCoinChangeRec(coins,coins.length,val);
        System.out.println(minCoins+" "+minCoinsDP);
        assertEquals(2,minCoins);
        assertEquals(2,minCoinsDP);
    }
}
