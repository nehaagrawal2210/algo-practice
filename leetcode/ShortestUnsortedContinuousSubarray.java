package leetcode;

import junit.framework.TestCase;

/**
 * Created by neagrawa on 5/14/17.
 * https://leetcode.com/contest/leetcode-weekly-contest-32/problems/shortest-unsorted-continuous-subarray/
 */
public class ShortestUnsortedContinuousSubarray extends TestCase {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length==1) return 0;
        int right=nums.length-1,left=0;
        while (left<nums.length-1 && nums[left+1]>=nums[left]) left++;
        if(left == nums.length-1) return 0;
        while (right>0 && nums[right] >= nums[right-1]) right--;

        //now find max and min value in initial unsorted array
        int max = nums[left];
        int min = nums[left];
        for (int i = left ; i <= right ; i++) {
            if(nums[i]>max)max = nums[i];
            if(nums[i]<min)min = nums[i];
        }

        while (left>0 && nums[left-1]>min) left--;
        while (right<nums.length-1 && nums[right+1]<max) right++;

        return right-left+1;
    }

    public void testFindUnsortedSubarray()
    {
        assertEquals(5,findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));
        assertEquals(0,findUnsortedSubarray(new int[]{1,2,3,4}));
        assertEquals(2,findUnsortedSubarray(new int[]{2,1}));
        assertEquals(4,findUnsortedSubarray(new int[]{1,3,2,2,2}));
        assertEquals(2,findUnsortedSubarray(new int[]{1,3,2,4,5}));
        assertEquals(3,findUnsortedSubarray(new int[]{2,3,3,2,4}));
        assertEquals(4,findUnsortedSubarray(new int[]{1,3,5,2,4}));
    }
}
