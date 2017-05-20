package leetcode;

import junit.framework.TestCase;

/**
 * Created by neagrawa on 5/19/17.
 */
public class NimGame extends TestCase {
    public boolean canWinNim(int n) {
        return n%4!=0;
    }

    public void testCanWinNim()
    {
        assertTrue(canWinNim(17));
    }
}
