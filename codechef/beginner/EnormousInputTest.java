package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by neha on 1/24/2017.
 */
public class EnormousInputTest {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        int c=0;
        for (int i = 0; i < n; i++) {
            int t=Integer.parseInt(br.readLine());
            if(t%k==0)
                c++;
        }
        System.out.println(c);
    }
}
