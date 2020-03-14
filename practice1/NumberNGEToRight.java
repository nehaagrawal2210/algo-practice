package practice1;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Test;

import junit.framework.TestCase;

public class NumberNGEToRight extends TestCase {

    @Test
    public void testRightNGE() {
        int a[] = { 3, 4, 2, 7, 5, 8, 10, 6 };
        int[] output = ngeNumber(a);
        System.out.println(Arrays.toString(output));
    }

    private int[] ngeNumber(int[] a) {
        int n = a.length;
        StringBuilder sb = new StringBuilder("abc");
        sb.substring(0,3);
        int[] next = getNge(a);
        int[] dp = new int[n];
        Arrays.fill(dp, 0);

        for (int i = n - 2; i >= 0; i--) {
            if (next[i] != -1) {
                dp[i] = dp[next[i]] + 1;
            }
        }
        return dp;
    }

    private int[] getNge(int[] a) {
        int[] res = new int[a.length];
        Stack


                <Integer> stack = new Stack<>();
        for (int i = a.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && a[stack.peek()] <= a[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return res;
    }
}
