package dp;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/14/2017.
 */
public class GameScore extends TestCase{
//    http://www.geeksforgeeks.org/count-number-ways-reach-given-score-game/
    public int getGameScoreRec(int score,int options[],int m)
    {
        if(score<0)
            return 0;
        if(score==0)
            return 1;
        if(m<=0 && score>0)
            return 0;
        return getGameScoreRec(score,options,m-1)+getGameScoreRec(score-options[m-1],options,m);
    }

    public int getGameScoreDP(int score,int options[],int m)
    {
        int x,y;
        int[][] scoreWays = new int[score+1][m+1];
        for (int i = 0; i < score + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if(i==0) scoreWays[i][j]=1;
                else if(j==0) scoreWays[i][j]=0;
                else {
                    x=scoreWays[i][j-1];
                    y=(i-options[j]>=0)?scoreWays[i-options[j]][j]:0;
                    scoreWays[i][j]=x+y;
                }
            }
        }
        return scoreWays[score][m];
    }

    @Test
    public void testGetGameScoreRec()
    {
        int score=20;
        int options[]={3,5,10};
        assertEquals(4,getGameScoreRec(score,options,options.length));
        assertEquals(2,getGameScoreRec(13,options,options.length));
    }

    @Test
    public void testGameScoreDP()
    {
        int score=20;
        int options[]={3,5,10};
        assertEquals(4,getGameScoreRec(score,options,options.length));
        assertEquals(2,getGameScoreRec(13,options,options.length));
    }
}
