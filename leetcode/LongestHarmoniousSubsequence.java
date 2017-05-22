package leetcode;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by neagrawa on 5/21/17.
 */
public class LongestHarmoniousSubsequence extends TestCase {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> count = new HashMap<>();
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int curCount= count.getOrDefault(nums[i],0)+1;
            int nextCount = count.getOrDefault(nums[i]+1,0);
            int prevCount = count.getOrDefault(nums[i]-1,0);
            count.put(nums[i],curCount);
            if(nextCount!=0) maxLen = Math.max(maxLen,curCount+nextCount);
            if(prevCount!=0) maxLen = Math.max(maxLen,curCount+prevCount);
        }
        return maxLen;
    }

    public void testFindLHS()
    {
        int[] nums ={1,3,2,2,5,2,3,7};
        assertEquals(5,findLHS(nums));
    }
}
