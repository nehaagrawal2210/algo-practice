package leetcode;

import junit.framework.TestCase;

/**
 * Created by neagrawa on 5/19/17.
 */
public class SingleElementInASortedArray extends TestCase {
    public int singleNonDuplicate(int[] nums) {
        int left=0,right=nums.length-1,mid;
        while (left<right)
        {
            mid= left+ (right-left)/2 ;
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1])
                return nums[mid];
            else if(mid%2==0 && nums[mid]==nums[mid+1])
                left=mid+1;
            else if(mid%2==1 && nums[mid]==nums[mid-1])
                left=mid+1;
            else right = mid-1;
        }
        return nums[left];
    }

    public void testGetSingleNonDuplicate()
    {
        assertEquals(2,singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
        assertEquals(10,singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
        assertEquals(2,singleNonDuplicate(new int[]{1,1,2}));
    }
}
