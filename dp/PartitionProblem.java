package dp;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/11/2017.
 */
public class PartitionProblem extends TestCase {

    public boolean getPartitionSum(int a[],int sum,int n)
    {
        if(sum==0)
            return true;
        if(n==0 && sum!=0)
            return false;

        if(a[n-1]>sum)
            return getPartitionSum(a,sum,n-1);

        return getPartitionSum(a,sum,n-1) || getPartitionSum(a,sum-a[n-1],n-1);
    }

    public boolean isPartitionPossible(int a[])
    {
        int sum=0;
        for (int i = 0; i < a.length; i++) {
            sum+=a[i];
        }
        if(sum%2!=0)
            return false;
        return getPartitionSum(a,sum/2,a.length);
    }

    public boolean isPartitionPossibleDP(int a[])
    {
        int sum=0;
        for (int i = 0; i < a.length; i++) {
            sum+=a[i];
        }
        if(sum%2!=0)
            return false;
        return getPartitionSumDP(a,sum/2);
    }

    public boolean getPartitionSumDP(int a[],int sum)
    {
        boolean sumDP[][]=new boolean[sum+1][a.length+1];

        for (int i = 0; i < sum+1; i++) {
            for (int j = 0; j < a.length+1; j++) {
                if((i==0) && (j==0)) sumDP[i][j]=true; //if total sum is 0 & total items are 0 then true
                else if(i==0) sumDP[i][j]=true; //sum is 0 then true
                else if(j==0) sumDP[i][j]=false; //sum not zero and items are zero then false
                else if(a[j-1]>i) sumDP[i][j]=sumDP[i][j-1];
                else {
                    sumDP[i][j]=(sumDP[i][j-1]) || (sumDP[i-a[j-1]][j-1]);
                }
            }
        }

        return sumDP[sum][a.length];
    }

    @Test
    public void testIsPartitionPossible()
    {
        int arr[] = {3, 1, 5, 9, 12};
        int arr1[] = {3, 1, 5, 9, 12,1};
        assertEquals(true,isPartitionPossible(arr));
        assertEquals(false,isPartitionPossible(arr1));
    }

    @Test
    public void testGetPartitionSumDP()
    {
        int arr[] = {3, 1, 5, 9, 12};
        int arr1[] = {3, 1, 5, 9, 12,1};
        assertEquals(true,isPartitionPossibleDP(arr));
        assertEquals(false,isPartitionPossibleDP(arr1));
    }

}
