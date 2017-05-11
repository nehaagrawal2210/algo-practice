package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by neha on 1/23/2017.
 */
public class QuentinTarantino {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases= Integer.parseInt(br.readLine());

        for (int i = 0; i < testCases; i++) {
            int len=Integer.parseInt(br.readLine());
            int a[]=new int[len];

            StringTokenizer st = new StringTokenizer(br.readLine());

            int sum=0;
            boolean linearOrder=true;

            for (int j = 0; j < len; j++) {
                a[j]=Integer.parseInt(st.nextToken());
                sum+=a[j];
                if(j!=0 && a[j]!=a[j-1]+1)
                    linearOrder=false;
            }

            if(sum!=(len*(len+1)/2) || linearOrder)
                System.out.println("no");
            else
                System.out.println("yes");

        }
    }
}
