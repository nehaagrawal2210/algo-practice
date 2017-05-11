package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by neagrawa on 5/7/17.
 */
public class DistributeCandies extends TestCase{
    public int distributeCandies(int[] candies) {
        Map<Integer,Integer> candieTypeCount = new HashMap<>();
        int sisterCandieCount=0, brotherCandieCount;
        for (int i : candies) {
            if(!candieTypeCount.containsKey(i)) sisterCandieCount++;
            candieTypeCount.put(i,candieTypeCount.getOrDefault(i,0)+1);
        }
        brotherCandieCount = candies.length - sisterCandieCount;
        if(sisterCandieCount > brotherCandieCount)
        sisterCandieCount = sisterCandieCount - ((sisterCandieCount-brotherCandieCount)/2);
        return sisterCandieCount;
    }

    @Test
    public void testDistributeCandies()
    {
        assertEquals(3,distributeCandies(new int[]{1,1,2,2,3,3}));
        assertEquals(2,distributeCandies(new int[]{1,1,2,3}));
        assertEquals(1,distributeCandies(new int[]{1,11}));
    }
}
