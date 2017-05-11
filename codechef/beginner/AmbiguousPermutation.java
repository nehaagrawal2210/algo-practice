package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by neha on 2/6/2017.
 */
public class AmbiguousPermutation {

    public static int[] getAmbiguousPermutation(int a[])
    {
        int[] inversePermutation=new int[a.length];
        for (int i = 0; i < a.length; i++) {
            inversePermutation[a[i]-1]=i+1;
        }
        return inversePermutation;
    }

    public static boolean checkEquality(int[] a,int[] k)
    {
        for (int i = 0; i < a.length; i++) {
            if(a[i]!=k[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len,i;
        StringTokenizer st;
        while ((len=Integer.parseInt(br.readLine()))!=0)
        {
            int a[]=new int[len];
            i=0;
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens())
                a[i++]=Integer.parseInt(st.nextToken());
            int k[]= getAmbiguousPermutation(a);
            if(checkEquality(a,k))
                System.out.println("ambiguous");
            else
                System.out.println("not ambiguous");
        }
    }
}
