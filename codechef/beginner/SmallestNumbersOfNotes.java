package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neha on 2/6/2017.
 */
public class SmallestNumbersOfNotes {

    public static int getNotesCount(int price)
    {
        int a[]={1,2,5,10,50,100};
        int count=0;
        for (int i = a.length-1;  (i>=0 && price!=0) ; i--) {
            while (price/a[i]!=0)
            {
                count=count+(price/a[i]);
                price=price%a[i];
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases= Integer.parseInt(br.readLine());

        int m;
        for (int i = 0; i < testCases; i++) {
            m = Integer.parseInt(br.readLine());
            System.out.println(getNotesCount(m));
        }
    }
}
