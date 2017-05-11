package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neha on 1/23/2017.
 */
public class LifeUivAndEverything {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase;
        while (true){
            testCase= Integer.parseInt(br.readLine());
            if(testCase==42)
                break;
            System.out.println(testCase);
        }
    }
}
