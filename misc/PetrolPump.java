package misc;

/**
 * Created by neha on 12/29/2016.
 */
public class PetrolPump {

    int petrol;
    int distanceToNextPump;

    public static int getStartPoint(PetrolPump[] petrolPump)
    {
        int start = 0, currEnd = 0,nextEnd = 1;
        int length = petrolPump.length;
        int currentPetrol = petrolPump[start].petrol;
        if(!isSolutionPossible(petrolPump))
            return -1;
        while(start!= currEnd || currEnd == 0)
        {
            if(currentPetrol-petrolPump[currEnd].distanceToNextPump>=0) {
                currentPetrol = currentPetrol-petrolPump[currEnd].distanceToNextPump+petrolPump[nextEnd].petrol;
                currEnd = nextEnd;
                nextEnd = (nextEnd + 1) % length;
            }
            else
            {
                start = nextEnd;
                nextEnd = (start + 1) % length;
                currentPetrol = petrolPump[start].petrol;
            }
        }
        return start;
    }

    public static boolean isSolutionPossible(PetrolPump[] petrolPumps)
    {
        int petrolSum=0,distSum=0;
        for(int i= 0;i<petrolPumps.length;i++)
        {
            petrolSum+=petrolPumps[i].petrol;
            distSum += petrolPumps[i].distanceToNextPump;
        }
        if(petrolSum>distSum)
            return true;
        return false;
    }

    public static void main(String args[])
    {
        PetrolPump pump[] = new PetrolPump[3];
        pump[0] = new PetrolPump();
        pump[0].petrol  =6;
        pump[1] = new PetrolPump();
        pump[0].distanceToNextPump =4;
        pump[1].petrol  =3;
        pump[1].distanceToNextPump =6;
        pump[2] = new PetrolPump();
        pump[2].petrol  =7;
        pump[2].distanceToNextPump =3;

        int pos = getStartPoint(pump);
        System.out.print("Start pos is "+pos);
    }
}
