package leetcode;

import junit.framework.TestCase;

import java.util.Arrays;

/**
 * Created by neagrawa on 5/12/17.
 * https://leetcode.com/problems/target-sum/#/description
 */
public class TargetSum extends TestCase{
    public int findTargetSumWays(int[] nums, int S) {
        int[][] memo = new int[nums.length][2001];
        for(int[] m:memo) Arrays.fill(m,Integer.MIN_VALUE);
        return findTargetSumWays(nums,S,nums.length-1,memo);
    }

    public int findTargetSumWays(int[] nums, int S,int curIndex,int[][] memo)
    {
        if(curIndex < 0)
        {
            return S==0 ? 1 : 0; //all the elems used and sum became 0 that means S was reached
        }
        if(memo[curIndex][S+1000]!=Integer.MIN_VALUE)
            return memo[curIndex][S+1000];
        int count=0;
        //take current element as -ve
        count+=findTargetSumWays(nums,S+nums[curIndex],curIndex-1,memo);
        //take current element as +ve
        count+=findTargetSumWays(nums,S-nums[curIndex],curIndex-1,memo);
        memo[curIndex][S+1000] = count;
        return memo[curIndex][S+1000];
    }

    public int findTargetSumWaysDP(int[] nums, int S)
    {
        int sum=0;
        for (int n:nums) sum+=n;
        if(sum<S || (sum+S)%2>0) return 0;
        /*sum(P) - sum(N) = target
        sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
        2 * sum(P) = target + sum(nums), hence sum(P) = (target+sum(nums))/2*/
        return getTargetSumWaysDP(nums,(S+sum)>>1);
    }

    public int getTargetSumWaysDP(int[] nums, int target)
    {
        int dp[]= new int[target+1];
        dp[0]=1;
        for(int n:nums)
        {
            for (int i = target; i >=n ; i--)
                dp[i] += dp[i-n];
        }
        return dp[target];
    }

    public void testFindTargetSumWays()
    {
        assertEquals(5,findTargetSumWays(new int[]{1,1,1,1,1},3));
        System.out.println(findTargetSumWaysDP(new int[]{1,1,1,1,1},3));
    }
}
