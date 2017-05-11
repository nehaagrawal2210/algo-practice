package hackerrank;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by neagrawa on 5/10/17.
 */
public class SherlockAndCost extends TestCase{
    public static int getMaxCost(int b[])
    {
        int[][] dp = new int[b.length+1][2]; //1 for choosing 1 other for choosing b[i]
        for (int i = 0; i <= b.length; i++) {
            dp[i+1][0] =  Math.max(dp[i][0],)      //choose 1 for b[i]

        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCases; i++) {
            int len = Integer.parseInt(br.readLine());
            int b[] = new int[len];
            StringTokenizer st= new StringTokenizer(br.readLine());
            for (int j = 0; j < len; j++) {
                b[j]= Integer.parseInt(st.nextToken());
            }
            System.out.println(getMaxCost(b));
        }

    }

    @Test
    public void testGetMaxCost()
    {
//        assertEquals(36,getMaxCost(new int[]{10,1,10,1,10}));
//        assertEquals(6,getMaxCost(new int[]{2,4,3}));
        assertEquals(396,getMaxCost(new int[]{100,2,100,2,100}));
        System.out.println(getMaxCost(new int[]{100,2,100,2,100}));
        int[] a = {55,68,31,80,57,18,34,28,76,55};
        assertEquals(508,getMaxCost(a));
    }
}

1 12 1 1 17
