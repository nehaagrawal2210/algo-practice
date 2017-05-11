package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by neha on 1/24/2017.
 */
public class LeadGame {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases=Integer.parseInt(br.readLine());

        int playerNo=0,lead=0,sum1=0,sum2=0;
        for (int i = 0; i < testCases; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int player1Score=Integer.parseInt(st.nextToken());
            int player2Score=Integer.parseInt(st.nextToken());

            sum1+=player1Score;
            sum2+=player2Score;

            int leadVal=Math.abs(sum1-sum2);
            if(leadVal>lead)
            {
                lead=leadVal;
                playerNo=(sum1>sum2)?1:2;
            }
        }
        System.out.println(playerNo+" "+lead);
    }
}
