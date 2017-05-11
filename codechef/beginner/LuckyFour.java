package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neha on 2/6/2017.
 */
public class LuckyFour {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int testCases= Integer.parseInt(br.readLine());

            int num,c;
            for (int i = 0; i < testCases; i++) {
                num=Integer.parseInt(br.readLine());
                c=0;
                while (num!=0)
                {
                    if(num%10 == 4)c++;
                    num/=10;
                }
                System.out.println(c);
            }
        }
}
