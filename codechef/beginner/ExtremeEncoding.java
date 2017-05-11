package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neha on 1/23/2017.
 */
public class ExtremeEncoding {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases= Integer.parseInt(br.readLine());

        for (int i = 0; i < testCases; i++) {
            int len=Integer.parseInt(br.readLine());
            int a[]=new int[len];
            int b[]=new int[len];

            //read all the values
            for (int j = 0; j < len; j++) {
                a[j]=Integer.parseInt(br.readLine());
            }

            for (int j = 0; j < len; j++) {
                b[j]=a[j]>>16;
                a[j]=a[j]-(b[j]<<16);
            }

            System.out.println("Case "+(i+1)+":");
            for (int j = 0; j < len; j++) {
                System.out.print(a[j]+" ");
            }
            System.out.println();
            for (int j = 0; j < len; j++) {
                System.out.print(b[j]+" ");
            }
        }
    }
}
