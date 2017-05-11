package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neha on 1/24/2017.
 */
public class Factorial {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases=Integer.parseInt(br.readLine());
        int input,c;
        while ((testCases--)!=0)
        {
            input=Integer.parseInt(br.readLine());
            c=0;
            for (int i = 5; input/i>=1 ; i*=5) {
                c=c+(input/i);
            }
            System.out.println(c);
        }
    }
}
