package dp;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/20/2017.
 */
public class VoteMachineCount extends TestCase{
//    http://www.geeksforgeeks.org/check-people-can-vote-two-machines/
    public boolean canVote(int a[],int totalTime)
    {
        int sum=0;
        for (int i = 0; i < a.length; i++) {
            sum+=a[i];
        }
        if(sum<=totalTime)
            return true;
        int dp[][] = new int[totalTime+1][a.length+1];

        for (int i = 0; i < totalTime + 1; i++) {
            for (int j = 0; j < a.length + 1; j++) {
                if((i==0) || (j==0)) //0 time, 0 people
                 dp[i][j]=0;
                else if(a[j-1]>i) //cant be used,leave it
                dp[i][j]= dp[i][j-1];
                else dp[i][j]= Math.max(dp[i][j-1], dp[i-a[j-1]][j-1]+a[j-1]);
            }
        }
        return (sum-dp[totalTime][a.length]<=totalTime);
    }

    @Test
    public void testCanVote()
    {
        int x = 4;
        int a[] = {2, 4, 2};
        assertTrue(canVote(a,x));
    }
}
