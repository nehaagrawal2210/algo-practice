package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neagrawa on 5/8/17.
 */
public class FindPaths extends TestCase {

    class PathCount{
        int pathCount;
    }
    public int findPaths(int m, int n, int N, int i, int j) {
        PathCount p = new PathCount();
        findPaths(m,n,N,i,j,p);
        return p.pathCount;
    }

    public void findPaths(int m, int n, int N, int i, int j,PathCount p) {
        if(i == m || j==n || i<0 || j<0) {
            p.pathCount++;
            return;
        }
        if(N == 0) return;//no moves left
        findPaths(m,n,N-1,i,j+1,p); //move right
        findPaths(m,n,N-1,i+1,j,p); //move down
        findPaths(m,n,N-1,i,j-1,p); //move left
        findPaths(m,n,N-1,i-1,j,p); //move up
    }

    public int findPaths1(int m, int n, int N, int i, int j) {
        int pathCount = 0;
        if(i == m || j==n || i<0 || j<0) return 1;
        if(N == 0) return pathCount;//no moves left
        pathCount+=findPaths1(m,n,N-1,i,j+1); //move right
        pathCount+=findPaths1(m,n,N-1,i+1,j); //move down
        pathCount+=findPaths1(m,n,N-1,i,j-1); //move left
        pathCount+=findPaths1(m,n,N-1,i-1,j); //move up
        return pathCount;
    }

    public int findPathsDP(int m, int n, int N, int i, int j) {
        long[][][] dp = new long[N+1][m][n];

        int limit = 1000000007;
        for (int moves = 1; moves <= N; moves++) {
            for (int k = 0; k < m; k++) {
                for (int l = 0; l < n; l++) {
                        dp[moves][k][l]+= k==0? 1: dp[moves-1][k-1][l]; //move up
                        dp[moves][k][l]+= l==0? 1: dp[moves-1][k][l-1]; //move left
                        dp[moves][k][l]+= k==m-1?1:dp[moves-1][k+1][l]; //move down
                        dp[moves][k][l]+= l==n-1?1:dp[moves-1][k][l+1]; //move right
                        dp[moves][k][l] %= limit;
                }
            }
        }
        return (int)dp[N][i][j];
    }

    public int findPathsDP1(int m, int n, int N, int i0, int j0) {
        long limit = 1000000007;
        long[][][] dp = new long[N + 1][m][n];
        for (int k = 1; k <= N; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[k][i][j] += i == 0     ? 1 : dp[k - 1][i - 1][j];
                    dp[k][i][j] += i == m - 1 ? 1 : dp[k - 1][i + 1][j];
                    dp[k][i][j] += j == 0     ? 1 : dp[k - 1][i][j - 1];
                    dp[k][i][j] += j == n - 1 ? 1 : dp[k - 1][i][j + 1];
                    dp[k][i][j] %= limit;
                }
            }
        }
        return (int)dp[N][i0][j0];
    }

    public void printArray(int[][] a)
    {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
        //now we need to convert this to DP

    @Test
    public void testFindPaths()
    {
//        int m=2,n=2,N=2,i=0,j=0;
        int m = 1, n = 3, N = 3, i = 0, j = 1;
      assertEquals(12,findPathsDP(    m,n,N,i,j));
//        findPathsDP(m,n,N,i,j);
    }
}
