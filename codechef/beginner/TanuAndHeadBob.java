package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neha on 2/6/2017.
 */
public class TanuAndHeadBob {

    public static void detect(String gestures)
    {
        for (int i = 0; i < gestures.length(); i++) {
            switch (gestures.charAt(i))
            {
                case 'I':
                    System.out.println("INDIAN");
                    return;
                case 'Y':
                    System.out.println("NOT INDIAN");
                    return;
            }
        }
        System.out.println("NOT SURE");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases= Integer.parseInt(br.readLine());
        for (int i = 0; i < testCases; i++) {
            br.readLine();
            detect(br.readLine());
        }
    }
}
