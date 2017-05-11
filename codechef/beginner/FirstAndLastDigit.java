package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neha on 2/6/2017.
 */
public class FirstAndLastDigit {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases= Integer.parseInt(br.readLine());

        String num;
        for (int i = 0; i < testCases; i++) {
            num=br.readLine();
            System.out.println((num.charAt(0)-'0')+(num.charAt(num.length()-1)-'0'));
        }
    }
}
