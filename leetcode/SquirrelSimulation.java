package leetcode;

import junit.framework.TestCase;

/**
 * Created by neagrawa on 5/12/17.
 * https://leetcode.com/articles/squirrel-simulation/
 */
public class SquirrelSimulation extends TestCase {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {

        int savingDistance = Integer.MIN_VALUE; //we have to maxmimise the saving
        int totalDistance = 0; //total distance travelled by squirrel
        for (int[]nut : nuts) {
            totalDistance+=(getDistance(tree,nut)*2);
            savingDistance = Math.max(savingDistance,getDistance(nut,tree) - getDistance(nut,squirrel));
        }
        return totalDistance - savingDistance;
    }

    /**
     * Distance between two positions
     * @param a Indexes of first pos
     * @param b Indexes of second pos
     * @return Distance between the passed positions
     */
    public int getDistance(int[] a, int[] b)
    {   
        return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
    }

    public void testGetMinDistance()
    {
        assertEquals(12,minDistance(5,7,new int[]{2,2},new int[]{4,4},new int[][]{{3,0},{2,5}}));
    }
}
