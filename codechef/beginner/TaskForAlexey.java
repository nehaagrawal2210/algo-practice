package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by neha on 1/23/2017.
 */
public class TaskForAlexey {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases= Integer.parseInt(br.readLine());

        for (int i = 0; i < testCases; i++) {
            int len=Integer.parseInt(br.readLine());
            long a[]=new long[len];

            StringTokenizer st = new StringTokenizer(br.readLine());

            Long res=Long.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                a[j] = Long.parseLong(st.nextToken());
            }

            for (int j = 0; j < len; j++) {
                for (int k = j+1; k < len; k++) {
                    res=Math.min(res,lcm(a[j],a[k]));
                }
            }
            System.out.println(res);
        }
    }

    public static long gcd(long a,long b)
    {
        if(b==0) return a;
        long gcdVal=gcd(b,a%b);
        return gcdVal;
    }

    public static long lcm(long a,long b)
    {
        long lcm=a*(b/gcd(a,b));
        return lcm;
    }
}
