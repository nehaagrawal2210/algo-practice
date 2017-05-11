package com.codechef.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by neha on 1/24/2017.
 */
public class TurboSort {

    public void mergeSort(int a[],int l,int r)
    {
        if(l<r)
        {
            int mid = (l+r)/2;
            mergeSort(a,l,mid);
            mergeSort(a,mid+1,r);
            merge(a,l,mid,r);
        }
    }

    public void merge(int a[],int low, int mid, int high)
    {
        //copy elements into temp arrays
        int size1 = mid-low+1;
        int size2 = high-mid;

        int l[]=new int[size1];
        int r[]=new int[size2];

        for (int i=0;i<size1;i++)
            l[i]=a[low+i];
        for (int i=0;i<size2;i++)
            r[i]=a[mid+i+1];

        int k=low,i=0,j=0;

        while (i<size1 && j<size2)
        {
            if (l[i]<r[j])
            {
                a[k++]=l[i++];
            }
            else {
                a[k++]=r[j++];
            }
        }
        while (i<size1)
        {
            a[k++]=l[i++];
        }
        while (j<size2)
        {
            a[k++]=r[j++];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases=Integer.parseInt(br.readLine());

        int a[]=new int[testCases];
        for (int i = 0; i < testCases; i++) {
            a[i]=Integer.parseInt(br.readLine());
        }

        new TurboSort().mergeSort(a,0,testCases-1);
        for (int i = 0; i < testCases; i++) {
            System.out.println(a[i]);
        }
    }
}
