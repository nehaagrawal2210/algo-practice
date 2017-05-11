package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by neha on 2/6/2017.
 */
public class SnapeAndLadder {

    public static void getLadderSize(double base,double ls)
    {
        double maxSize=Math.sqrt(base*base+ls*ls);
        double minSize=Math.sqrt(ls*ls - base*base);
        System.out.print(minSize+" "+maxSize);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases= Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < testCases; i++) {
            st = new StringTokenizer(br.readLine());
            getLadderSize(Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()));
            System.out.println();
        }
    }
}
