package queue;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neha on 2/26/2017.
 */
//http://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
public class PetrolPumpTour extends TestCase{

    class PetrolPump{
        int petrol;
        int dist;

        PetrolPump(int petrol,int dist)
        {
            this.petrol= petrol;
            this.dist= dist;
        }
    }

    public int getStartingPoint(PetrolPump[] petrolPump)
    {
        int len = petrolPump.length,start=0;
        int currPetrol=0,totalPetrol=0,totalDist=0;
        for (int i = 0; i < len; i++) {
            totalDist+=petrolPump[i].dist;
            totalPetrol+=petrolPump[i].petrol;
            currPetrol+=petrolPump[i].petrol-petrolPump[i].dist;
            if(currPetrol<0) {
                start=i+1;
                currPetrol=0;
            }
        }
        if(totalDist>totalPetrol) return -1;
        return start;
    }

    @Test
    public void testGetStartingPoint()
    {
        int arr[][] = {{6, 4}, {3, 6}, {7, 7}};
        PetrolPump petrolPump[] = new PetrolPump[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j+=2) {
                petrolPump[i]= new PetrolPump(arr[i][j],arr[i][j+1]);
            }
        }

        assertEquals(-1,getStartingPoint(petrolPump));

        int arr1[][]= {{4, 6},{6, 5},{7, 3},{4, 10}};
        PetrolPump petrolPump1[] = new PetrolPump[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j+=2) {
                petrolPump1[i]= new PetrolPump(arr1[i][j],arr1[i][j+1]);
            }
        }

        assertEquals(1,getStartingPoint(petrolPump1));
    }
}
