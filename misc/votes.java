package misc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by neha on 1/16/2017.
 */
public class votes {

    /*
 * Complete the function below.
 */

    public static String electionWinner(String[] votes) {

        Map<String,Integer> m1=new HashMap<>();

        for(int i=0;i<votes.length;i++)
        {
            if(m1.containsKey(votes[i]))
            {
                Integer voteCount= m1.get(votes[i]);
                voteCount++;
                m1.put(votes[i],voteCount);
            }
            else
            {
                //first vote
                m1.put(votes[i],1);
            }
        }

        String winnerCandidate="";
        int winningVoteCount=0;
        for(Map.Entry<String,Integer> entry:m1.entrySet())
        {
            int currentVoteCount=entry.getValue();
            String currentCandidate=entry.getKey();
            if(currentVoteCount>winningVoteCount)
            {
                winningVoteCount=currentVoteCount;
                winnerCandidate=currentCandidate;
            }
            else if(currentVoteCount==winningVoteCount && currentCandidate.compareTo(winnerCandidate)>0)
            {
                winnerCandidate=currentCandidate;
            }
        }
        return winnerCandidate;
    }

    public static void main(String[] args) {

        String votes[]={"Alex","Michael","Michael","Alex","Alex","Michael"};
        String votes1[]={"Michael","Alex","Alex"};
        System.out.println(electionWinner(votes1));
    }

}
