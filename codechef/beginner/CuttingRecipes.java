package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by neha on 2/6/2017.
 */
public class CuttingRecipes {

    public static int getGCD(int a[])
    {
        int gcd=a[0];
        for (int i = 1; i < a.length; i++) {
            gcd=getGCD(gcd,a[i]);
        }
        return gcd;
    }

    public static int getGCD(int a,int m)
    {
        if(m==0)
            return a;
        return getGCD(m,a%m);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases= Integer.parseInt(br.readLine());
        StringTokenizer st;

        int a[];
        int gcd;
        for (int i = 0; i < testCases; i++) {
            st = new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            a=new int[n];
            for (int j = 0; j < n; j++) {
                a[j]=Integer.parseInt(st.nextToken());
            }
            gcd= getGCD(a);
            for (int j = 0; j < n; j++) {
                System.out.print(a[j]/gcd+" ");
            }
            System.out.println();
        }
    }
}
