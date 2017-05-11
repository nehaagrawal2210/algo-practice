package com.codechef.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by neha on 2/6/2017.
 */
public class CielAndABProblem {
    public static void main(String[] args) throws IOException{
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st= new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            String res=Integer.toString(x-y);
            char c[]=res.toCharArray();
            if(c[0]=='9')
                c[0]-=1;
            else
                c[0]+=1;
            System.out.println(new String(c));
        }
    }
}
