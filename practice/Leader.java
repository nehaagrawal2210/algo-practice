package practice;

import junit.framework.TestCase;

/**
 * Created by neagrawa on 5/28/17.
 */
public class Leader extends TestCase {
    public void printLeader(int[] a)
    {
        int prevLargest = Integer.MIN_VALUE;
        for (int i = a.length-1; i >=0; i--) {
            if(a[i]>prevLargest)
            {
                System.out.println(a[i]);
                prevLargest = a[i];
            }
        }
    }

    public void testP()
    {
        int[] a={16, 17, 4, 3, 5, 2};
        printLeader(a);
    }
}
