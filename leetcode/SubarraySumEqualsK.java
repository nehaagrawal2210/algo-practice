package leetcode;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Created by neagrawa on 5/1/17.
 */
public class SubarraySumEqualsK extends TestCase {
    public int getSubarraySum(int[] nums, int k) {
        if (nums.length == 1 && nums[0] != k)
            return 0;
        if (k < 0) {
            k *= -1;
            for (int i = 0; i < nums.length; i++) {
                nums[i] *= -1;
            }
        }
        int subArraySumCount = 0;
        for (int endSumIndex = 0, startSumIndex = 0, partialSum = 0; endSumIndex < nums.length; endSumIndex++) {
            partialSum += nums[endSumIndex];
            while (partialSum > k && startSumIndex <= endSumIndex)
                partialSum -= nums[startSumIndex++];
            if (partialSum == k)
                subArraySumCount++;
        }
        return subArraySumCount;
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSumMap = new HashMap<>();
        int partialSum = 0, subArraySumCount = 0;
        preSumMap.put(0, 1); // if presum is asked to be zero then we can add one to the combinations
        for (int i = 0; i < nums.length; i++) {
            partialSum += nums[i];
            subArraySumCount += preSumMap.getOrDefault(partialSum - k, 0);
            preSumMap.put(partialSum, preSumMap.getOrDefault(partialSum, 0) + 1);
        }
        return subArraySumCount;
    }

    @Test
    public void testSubarraySum() {
        int nums[] = { 1, 2, 1, 2, 1 };
        assertEquals(4, subarraySum(nums, 3));
        assertEquals(2, subarraySum(new int[] { 1, 1, 1 }, 2));
        assertEquals(0, subarraySum(new int[] { 1 }, 0));
        assertEquals(2, subarraySum(new int[] { 1, -1, 1 }, 0));
        assertEquals(2, subarraySum(new int[] { 1, 2, 3 }, 3));
        assertEquals(1, subarraySum(new int[] { -1, -3, 5 }, 1));
    }
}
