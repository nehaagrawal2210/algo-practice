package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neha on 2/1/2017.
 */
public class SumOfDigits {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases= Integer.parseInt(br.readLine());

        for (int i = 0; i < testCases; i++) {
            System.out.println(getSum(Integer.parseInt(br.readLine())));
        }
    }

    public static int getSum(int m)
    {
        int sum=0;
        while (m!=0)
        {
            sum+=(m%10);
            m/=10;
        }
        return sum;
    }
}
