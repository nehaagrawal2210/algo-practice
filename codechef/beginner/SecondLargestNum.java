package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by neha on 2/6/2017.
 */
public class SecondLargestNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases= Integer.parseInt(br.readLine());
        StringTokenizer st;
        int x,y,z;
        for (int i = 0; i < testCases; i++) {
            st = new StringTokenizer(br.readLine());
            x=Integer.parseInt(st.nextToken());
            y=Integer.parseInt(st.nextToken());
            z=Integer.parseInt(st.nextToken());

            if(x>y)
            {
                if(x<z)
                    System.out.println(x); // z largest
                else
                    System.out.println(Math.max(y,z));
            }
            else {
                if(y<z) //z largest
                    System.out.println(y);
                else
                    System.out.println(Math.max(x,z));
            }
        }
    }
}
