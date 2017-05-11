package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by neha on 2/6/2017.
 */
public class TheSmallestPair {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases= Integer.parseInt(br.readLine());
        StringTokenizer st;

        int l,min,smin;
        int[] a;
        for (int i = 0; i < testCases; i++) {
            l  = Integer.parseInt(br.readLine());
            a  = new int[l];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < l; j++) {
                a[j]=Integer.parseInt(st.nextToken());
            }
            min = Integer.MAX_VALUE;
            smin = Integer.MAX_VALUE;
            for (int j = 0; j < l; j++) {
                if(a[j]<min)
                {
                    smin=min;
                    min=a[j];
                }
                else if(a[j]<smin)
                    smin=a[j];
            }
            System.out.println(min+smin);
        }
    }
}
