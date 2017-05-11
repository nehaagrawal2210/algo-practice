package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by neha on 1/24/2017.
 */
public class SmallFactorial {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases=Integer.parseInt(br.readLine());

        int input;
        BigInteger a[]=new BigInteger[101];
        for (int i = 0; i < 101; i++) {
            a[i]=BigInteger.ZERO;
        }
        for (int i = 0; i < testCases; i++) {
            input=Integer.parseInt(br.readLine());
            System.out.println(calFactorial(input,a));
        }

    }

    public static BigInteger calFactorial(int n,BigInteger a[])
    {
        if(!a[n].equals(BigInteger.ZERO))
            return a[n];
        BigInteger fact=BigInteger.ONE;
        for (int i = 2; i <=n ; i++) {
            fact=fact.multiply(BigInteger.valueOf(i));
        }
        a[n]=fact;
        return a[n];
    }
}
