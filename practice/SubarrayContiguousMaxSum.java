package practice;

import junit.framework.TestCase;

/**
 * Created by neagrawa on 5/26/17.
 */
public class SubarrayContiguousMaxSum extends TestCase {
    public int maxSubarraySum(int[] num) {
        int s = 0, maxSoFar = 0, maxEndingHere = 0, start = 0, end = 0;
        for (int i = 0; i < num.length; i++) {
            maxEndingHere += num[i];
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
                s = i + 1;
            }
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                end = i;
                start = s;
            }
        }

        for (int i = start; i <= end; i++) {
            System.out.print(num[i] + ",");
        }
        System.out.println();
        return maxSoFar;
    }

    public void testMaxSubSum() {
        assertEquals(7, maxSubarraySum(new int[] { -2, -3, 4, -1, -2, 1, 5, -3 }));

    }
}
