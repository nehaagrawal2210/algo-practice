package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by neha on 3/9/2017.
 */
public class SebiAndHighway {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases= Integer.parseInt(br.readLine());

        int S=0,SG=0,FG=0,D=0,T=0;
        double speed; //speed in kph
        for (int i = 0; i < testCases; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens())
            {
                S= Integer.parseInt(st.nextToken());
                SG= Integer.parseInt(st.nextToken());
                FG= Integer.parseInt(st.nextToken());
                D= Integer.parseInt(st.nextToken());
                T= Integer.parseInt(st.nextToken());
            }

            speed = S+ (180.0*D/T);
            if(Math.abs(SG-speed)<Math.abs(FG-speed))
                System.out.println("SEBI");
            else if(Math.abs(SG-speed)>Math.abs(FG-speed))System.out.println("FATHER");
            else System.out.println("DRAW");
        }

    }
}
