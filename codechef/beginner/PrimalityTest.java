package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by neha on 2/6/2017.
 */
public class PrimalityTest {

    public static boolean isPrime(int m)
    {
        if(m<2)
            return false;
        if(m==2)
            return true;
        if(m%2==0)
            return false;
        for (int i = 3; i*i <=m ; i+=2) {
            if(m%i==0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int testCases= Integer.parseInt(br.readLine());
            for (int i = 0; i < testCases; i++) {
                if(isPrime(Integer.parseInt(br.readLine())))
                    System.out.println("yes");
                else
                    System.out.println("no");
            }
    }
}
