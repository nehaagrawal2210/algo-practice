package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neha on 3/9/2017.
 */
//https://www.codechef.com/problems/PALL01
public class TheBlockGame {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases= Integer.parseInt(br.readLine());
        String m;
        for (int i = 0; i < testCases; i++) {
            m= br.readLine();
            if(isPalindrome(m))
                System.out.println("wins");
            else System.out.println("losses");
        }
    }

    public static boolean isPalindrome(String m)
    {
        int start=0, end = m.length()-1;
        while (start<end)
        {
            if(m.charAt(start)!= m.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
