package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neha on 1/23/2017.
 */
public class LISDigit {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases= Integer.parseInt(br.readLine());

        String lisArrayStr;
        for (int i = 0; i < testCases; i++) {
            br.readLine();
            lisArrayStr=br.readLine();
            System.out.println(lisArrayStr.replaceAll(" ",""));
        }
    }
}
