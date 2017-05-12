package leetcode;

import junit.framework.TestCase;

/**
 * Created by neagrawa on 5/12/17.
 * https://leetcode.com/problems/target-sum/#/description
 */
public class TargetSum extends TestCase{
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums,S,nums.length-1);
    }

    public int findTargetSumWays(int[] nums, int S,int curIndex)
    {
        if(curIndex < 0)
        {
            return S==0 ? 1 : 0; //all the elems used and sum became 0 that means S was reached
        }
        int count=0;
        //take current element as -ve
        count+=findTargetSumWays(nums,S+nums[curIndex],curIndex-1);
        //take current element as +ve
        count+=findTargetSumWays(nums,S-nums[curIndex],curIndex-1);
        return count;
    }

    public void testFindTargetSumWays()
    {
        assertEquals(5,findTargetSumWays(new int[]{1,1,1,1,1},3));
    }
}
