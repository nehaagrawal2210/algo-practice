package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neha on 2/6/2017.
 */
public class FindingSquareRoots {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases= Integer.parseInt(br.readLine());

        int m;
        for (int i = 0; i < testCases; i++) {
            m=Integer.parseInt(br.readLine());
            System.out.println((int) Math.sqrt(m));
        }
    }
}
