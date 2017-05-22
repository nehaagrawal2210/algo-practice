package leetcode;

import junit.framework.TestCase;

/**
 * Created by neagrawa on 5/21/17.
 */
public class ValidSquare extends TestCase {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        //take p1 as one corner, find dist of all points from this corner
        int dist2=findDistBetweenTwoPoints(p1,p2);
        int dist3=findDistBetweenTwoPoints(p1,p3);
        int dist4=findDistBetweenTwoPoints(p1,p4);
        if(dist2==0 || dist3==0 || dist4==0) return false;
        //3 possibilites
        if(dist2==dist3 && 2*dist2 == dist4)
        {
            return isSquare(p4,p2,p3);
        }
        else if(dist2==dist4 && 2*dist2 == dist3)
        {
            return isSquare(p3,p2,p4);
        }
        else if(dist4==dist3 && 2*dist3==dist2)
        {
            return isSquare(p2,p3,p4);
        }
        return false;
    }

    public boolean isSquare(int[]p1,int[]p2,int[]p3)
    {
         return findDistBetweenTwoPoints(p1,p2) == findDistBetweenTwoPoints(p1,p3);
    }

    public int findDistBetweenTwoPoints(int[] p1,int[] p2)
    {
        return (p2[0]-p1[0]) * (p2[0]-p1[0]) + (p2[1]-p1[1]) * (p2[1]-p1[1]);
    }

    public void testSquare()
    {
        assertTrue(validSquare(new int[]{0,0},new int[]{1,1},new int[]{1,0},new int[]{0,1}));
    }
}
