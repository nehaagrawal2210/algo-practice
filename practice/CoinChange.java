package practice;

import junit.framework.TestCase;

/**
 * Created by neagrawa on 6/4/17.
 */
public class CoinChange extends TestCase {
    public int getCoinChange(int[] coins,int value,int i)
    {
        if(value==0) return 1;
        if(value<0) return 0;
        if(i<0) return 0;
        if(coins[i]>value) return getCoinChange(coins,value,i-1);
        return getCoinChange(coins,value-coins[i],i)+getCoinChange(coins,value,i-1);
    }

    public int getCoinChange(int[] coins,int value)
    {
        int len = coins.length;
        int dp[][]  = new int[value+1][len+1];
        for (int i = 0; i < value + 1; i++) {
            for (int j = 0; j < len + 1; j++) {
                if(i==0) dp[i][j]=1;
                else if(j==0) dp[i][j]=0;
                else dp[i][j] = i-coins[j-1]>=0? dp[i-coins[j-1]][j]+dp[i][j-1]
                            : dp[i][j-1];
            }
        }
        return dp[value][len];
    }

    public int getMinCoins(int[] coins,int value)
    {
        int len = coins.length;
        int dp[]  = new int[value+1];
        dp[0]=0;
        for (int i = 1; i <= value; i++) {
            dp[i]=Integer.MAX_VALUE;
        }
        for (int i = 1; i < value+1; i++) {
            for (int j = 0; j < len; j++) {
                if(coins[j]<=i)
                {
                    int subRes = dp[i-coins[j]];
                    if(subRes!=Integer.MAX_VALUE && subRes+1<dp[i])
                        dp[i]=subRes+1;
                }
            }
        }
        return dp[value];
    }

    public void testGetCoinChange()
    {
        int arr[] = {1, 2, 3};
        int value = 4;
        int coins[] = {2, 5, 3, 6};
        System.out.println(getCoinChange(arr,value,2));
        System.out.println(getCoinChange(coins,10,3));
        System.out.println(getCoinChange(arr,value));
        System.out.println(getCoinChange(coins,10));
        System.out.println(getMinCoins(coins,13));
    }
}
