package misc;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/16/2017.
 */
public class WineGlasses extends TestCase{
//    http://www.geeksforgeeks.org/find-water-in-a-glass/

    public float fillWater(int row,float wine)
    {
        float glasses[]=new float[row*(row+1)/2];
        int index=0;
        glasses[0]=wine; //all water in first glass
        for (int i = 1; i <= row && wine!=0.0; i++) { //rows
                for (int j = 0; j < i; j++,index++) { //glasses
                wine= glasses[index];
                if(wine>=1.0f)
                {
                    glasses[index]= (wine>=1.0f)?1.0f:wine;
                    wine-=1;
                }
                else {
                    glasses[index]=wine;
                    wine=0;
                }
                //distribute wine in the glasses in this row
                glasses[index+i]+=(wine/2);
                glasses[index+i+1]+=(wine/2);
            }
        }
        return glasses[(row*(row+1)/2)-1];
    }

    @Test
    public void testFilWater()
    {

    }
}
