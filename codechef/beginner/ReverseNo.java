package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neha on 2/6/2017.
 */
public class ReverseNo {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int testCases= Integer.parseInt(br.readLine());

            int num,reverse;
            for (int i = 0; i < testCases; i++) {
                num=Integer.parseInt(br.readLine());
                reverse=0;
                while (num!=0)
                {
                    reverse=(reverse*10)+(num%10);
                    num/=10;
                }
                System.out.println(reverse);
            }
        }
}

