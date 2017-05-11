package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neha on 2/6/2017.
 */
public class Servant {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases= Integer.parseInt(br.readLine());
        int m;
        for (int i = 0; i < testCases; i++) {
            m=Integer.parseInt(br.readLine());
            if(m<10)
                System.out.println("What an obedient servant you are!");
            else
                System.out.println("-1");
        }
    }
}
