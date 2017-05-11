package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by neha on 1/31/2017.
 */
public class NothingInCommon {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases=Integer.parseInt(br.readLine());

        for (int i = 0; i < testCases; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a1=Integer.parseInt(st.nextToken());
            int a2=Integer.parseInt(st.nextToken());

            int a[]=new int[a1];
            int m[]=new int[a2];

            //first array numbers
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < a1; j++) {
                a[j]=Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < a1; j++) {
                m[j]=Integer.parseInt(st.nextToken());
            }

            System.out.println(getCount(a,m));
        }

    }

    public static int getCount(int a[],int m[])
    {
        int i=0,j=0;
        int a1=a.length;
        int a2=m.length;

        int count=0;

        while (i<a1 && j<a2)
        {
          if(a[i]==m[j])
          {
              count++;
              i++;
              j++;
          }
          else if(a[i]<m[j])
              i++;
          else
              j++;
        }
        return count;
    }
}
