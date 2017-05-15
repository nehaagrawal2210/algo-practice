package leetcode;

import junit.framework.TestCase;

/**
 * Created by neagrawa on 5/14/17.
 */
public class DeleteOperationForTwoStrings extends TestCase {
    public int minDistance(String word1, String word2) {
        return minDistance(word1,word2,0,0,0);
    }

    public int minDistance(String word1,String word2,int index1, int index2, int dist)
    {
        if(index1 == word1.length() && index2 == word2.length()) return dist;
        if(index1 == word1.length()) return dist + word2.length()-index2;
        if(index2 == word2.length()) return dist + word1.length()-index1;
        if(word1.charAt(index1) == word2.charAt(index2))
            return minDistance(word1,word2,index1+1,index2+1,dist);
        //get dist count by deleting word1 character
        int dist1= minDistance(word1,word2,index1+1,index2,dist+1);
        int dist2= minDistance(word1,word2,index1,index2+1,dist+1);
        return Math.min(dist1,dist2);
    }

    public int minDist(String word1,String word2)
    {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i < word1.length()+1; i++) {
            for (int j = 0; j < word2.length()+1; j++) {
                if(i==0 || j==0) dp[i][j] = i+j;
                else if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+1;
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public void testMinDistance()
    {
        assertEquals(2,minDistance("sea","eat"));
        assertEquals(1,minDistance("b",""));

        assertEquals(2,minDist("sea","eat"));
        assertEquals(1,minDist("b",""));
    }
}
