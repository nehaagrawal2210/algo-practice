package practice;

import junit.framework.TestCase;

/**
 * Created by neagrawa on 6/10/17.
 */
public class Celebrity extends TestCase {
    public int getCelebrity(boolean[][] knows){
        int r = knows.length, c = knows[0].length;
        if(r == 1) return r;
        int celebrity = 0;
        for (int other = 1; other < r; other++) {
            if(knows[celebrity][other]){
                celebrity = other;
            }
        }
        for (int i = 0; i < r; i++) {
            if(i!=celebrity && (knows[celebrity][i] || !knows[i][celebrity]))
                return -1;
        }
        return celebrity;
    }

    public void testCelebrity()
    {
        boolean  MATRIX[][] = {{false, false, true, false},
        {false, false, true, false},
        {false, false, false, false},
        {false, false, true, false}};
        System.out.println(getCelebrity(MATRIX));
    }
}
