package dp;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/14/2017.
 */
public class SubsetSum extends TestCase{
//    http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
    public boolean getSubsetSum(int a[],int sum)
    {
        int length=a.length;
        boolean sumDP[][]=new boolean[sum+1][length+1];
        for (int i = 0; i < sum + 1; i++) {
            for (int j = 0; j < length+1; j++) {
                if (i == 0) sumDP[i][j] = true;
                else if (j == 0) sumDP[i][j] = false;
                else {
                    sumDP[i][j] = sumDP[i][j - 1];
                    if (a[j-1] <= i) sumDP[i][j] = sumDP[i][j] || sumDP[i - a[j-1]][j-1];
                }
            }
        }
        for (int i = 0; i < sum + 1; i++) {
            for (int j = 0; j < length + 1; j++) {
                System.out.print(sumDP[i][j]+"    ");
            }
            System.out.println();
        }
        return sumDP[sum][length];
    }

    @Test
    public void testGetSubsetSum()
    {
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        assertEquals(true,getSubsetSum(set,sum));
    }
}
