package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by neha on 2/6/2017.
 */
public class SumsInTriangle {

    public static long getSum(int[][] a,int n)
    {
        for (int i = n-2; i >=0 ; i--) {
            for (int j = 0; j <= i; j++) {
                a[i][j]=Math.max(a[i+1][j],a[i+1][j+1])+a[i][j];
            }
        }
        return a[0][0];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases= Integer.parseInt(br.readLine());
        StringTokenizer st;

        int a[][];
        for (int i = 0; i < testCases; i++) {
            int l=Integer.parseInt(br.readLine());
            a=new int[l][];

            for (int j = 0; j < l; j++) {
                st = new StringTokenizer(br.readLine());
                a[j]=new int[j+1];
                for (int k = 0; k <= j; k++) {
                    a[j][k]=Integer.parseInt(st.nextToken());
                }
            }

            System.out.println(getSum(a,l));
        }
    }
}
