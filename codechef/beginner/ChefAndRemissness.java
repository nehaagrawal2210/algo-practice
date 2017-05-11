package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by neha on 2/6/2017.
 */
public class ChefAndRemissness {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases= Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < testCases; i++) {
            st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            System.out.println(Math.max(a,m)+" "+(a+m));
        }
    }
}
