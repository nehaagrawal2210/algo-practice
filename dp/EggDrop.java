package dp;

/**
 * Created by neha on 2/1/2017.
 */
public class EggDrop {

    public static int getMinTrialRec(int eggs,int floors)
    {
        if(eggs==1)
            return floors;
        if(floors==0 || floors==1)
            return floors;
        int result=Integer.MAX_VALUE,trials;
        for (int i = 1; i <= floors; i++) {
            trials=Math.max(getMinTrialRec(eggs-1,i-1),getMinTrialRec(eggs,floors-i));
            if(trials<result)
                result=trials;
        }
        return result+1;
    }

    public static int getMinTrialDP(int eggs,int floors)
    {
        int eggTrials[][]=new int[eggs+1][floors+1];
        int result;

        for (int i = 0; i < eggs + 1; i++) {
            for (int j = 0; j < floors + 1; j++) {
                if(j==0 || j==1)
                    eggTrials[i][j]=j;
                else if(i==0)
                    eggTrials[i][j]=0; //for 0 eggs 0 trials
                else if(i==1) //only 1 egg & j floors then j trials are required
                    eggTrials[i][j]= j;
                else
                {
                    eggTrials[i][j]=Integer.MAX_VALUE;
                    for (int k = 1; k <=j; k++) {
                        result=1+Math.max(eggTrials[i-1][k-1],eggTrials[i][j-k]);
                        if(result<eggTrials[i][j])
                            eggTrials[i][j]=result;
                    }
                }
            }
        }
        return eggTrials[eggs][floors];
    }

    public static void main(String[] args) {
        System.out.println(getMinTrialRec(2,10));
        System.out.println(getMinTrialDP(2,10));
    }
}
