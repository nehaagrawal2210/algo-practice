package practice1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Assert;

import junit.framework.TestCase;

//    https://www.geeksforgeeks.org/first-negative-integer-every-window-size-k/
public class FirstNegativeInteger extends TestCase {

    public void testFirstNegative() {
        int arr[] = { -8, 2, 3, -6, 10 }, k = 2;
        List<Integer> expectedOutput = Arrays.asList(-8, 0, -6, -6);
        List<Integer> actualOutput = firstNegative(arr, k);
        System.out.println("firstNegative(arr,k) = " + actualOutput);
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    public void testFirstNegative1() {
        int arr[] = { 12, -1, -7, 8, -15, 30, 16, 28 }, k = 3;
        List<Integer> expectedOutput = Arrays.asList(-1, -1, -7, -15, -15, 0);
        List<Integer> actualOutput = firstNegative(arr, k);
        System.out.println("firstNegative(arr,k) = " + actualOutput);
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    private List<Integer> firstNegative(int[] a, int k) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        int i;
        for (i = 0; i < k; i++) {
            if (a[i] < 0) {
                q.add(i);
            }
        }

        for (; i < a.length; i++) {
            res.add(q.isEmpty() ? 0 : a[q.peek()]);
            removeOutOfWindowElems(q, k, i);
            if (a[i] < 0) {
                q.add(i);
            }
        }
        res.add(q.isEmpty() ? 0 : a[q.peek()]);
        return res;
    }

    private void removeOutOfWindowElems(Queue<Integer> q, int windowSize, int currentIndex) {
        while (!q.isEmpty() && currentIndex - windowSize >= q.peek()) {
            q.poll();
        }
    }
}
