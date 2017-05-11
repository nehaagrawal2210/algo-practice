package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by neha on 2/6/2017.
 */
public class ValidTriangles {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases= Integer.parseInt(br.readLine());
        StringTokenizer st;
        int x1,x2,x3;
        for (int i = 0; i < testCases; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            x3 = Integer.parseInt(st.nextToken());
            if(x1>0 && x2>0 && x3>0 && (x1+x2+x3)==180)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
