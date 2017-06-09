package dp;

import java.util.ArrayList;

/**
 * Created by neha on 1/20/2017.
 */
public class LongestIncreasingSubsequence {


    public int lis(int a[])
    {
        int n=a.length,max=0;
        int l[]=new int[n];

        for (int i = 0; i < n; i++) {
            l[i]=1;
        }

        for (int i = 0; i <n; i++) {
            for (int j = 0; j < i; j++) {
                if(a[j]<a[i] && l[i]<l[j]+1)
                {
                    l[i]=l[j]+1;
                }
            }
            max = Math.max(max,l[i]);
        }
        return max;
    }


    //dynamic programming n2 approach
    public void printLISAsString(int a[])
    {
        String lis[]= new String[a.length];

        //initialize lis
        for (int i = 0; i < a.length; i++) {
            lis[i]="";
        }

        lis[0]=Integer.toString(a[0]);

        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if(a[j]<a[i] && lis[i].length()<lis[j].length()+1)
                    lis[i]=lis[j];
            }
            lis[i]+=" "+a[i];
        }

        int max=0;
        //pick max of all lengths
        for (int i = 1; i < a.length; i++) {
            if(lis[i].length()>lis[max].length())
                max=i;
        }
        System.out.println(lis[max]);
    }

    //dynamic programming n2 approach
    public void printLIS(int a[])
    {
        ArrayList<ArrayList<Integer>> l=new ArrayList<ArrayList<Integer>>();

        //initialize lis
        for (int i = 0; i < a.length; i++) {
            l.add(i,new ArrayList<>());
        }
        l.get(0).add(a[0]);
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if(a[j]<a[i] &&  l.get(i).size() <l.get(j).size()+1)
                {
                    l.remove(i);
                    //make a copy of the list and add here as change in one list should not affect other
                    l.add(i,new ArrayList<Integer>(l.get(j)));
                }
            }
            l.get(i).add(a[i]);
        }

        int max=0;
        //pick max of all lengths
        for (int i = 1; i < a.length; i++) {
            if(l.get(i).size()>l.get(max).size())
                max=i;
        }
        System.out.println(l.get(max));
    }

//    ------------------------------------------------------------------------------------------------------
//    -----------------------  nlogn approach  -------------------------------------------------------------
//    ------------------------------------------------------------------------------------------------------

    //find ceiling of a data
    public int getCeilIndex(int a[], int l, int r, int key)
    {
        while (r-l>1)
        {
            int m= l+(r-l)/2;
            if(a[m]>=key)
                r=m;
            else
                l=m;
        }
        return r;
    }

    public int getCeilIndex(int a[],int[] tailIndices,int l,int r,int key)
    {
        while (r-l>1)
        {
            int m=l+(r-l)/2;
            if(a[tailIndices[m]]>=key)
                r=m;
            else
                l=m;
        }
        return r;
    }

    public int lisLength(int a[])
    {
        int tail[]=new int[a.length];
        tail[0]=a[0];
        int len=1;

        for (int i = 1; i < a.length; i++) {
            if(a[i]<tail[0]) {
                tail[0]=a[i]; //new smallest value
            }
            else if(a[i]>tail[len-1]) {
                tail[len++]=a[i]; //new largest value
            }
            else
            {
                //replace existing list
                tail[getCeilIndex(tail,0,len-1,a[i])]=a[i];
            }
        }
        return len;
    }

    public void printLisLogn(int a[])
    {
        int[] tailIndices=new int[a.length];
        int[] prevIndices=new int[a.length];

        for (int i = 0; i < a.length; i++) {
            prevIndices[i]=-1;
        }

        //add first active list i.e first element here
        tailIndices[0]=0;
        int len=1;
        for (int i = 1; i < a.length; i++) {
            if(a[i]<a[tailIndices[0]])
            {
                //replace with new value
                tailIndices[0]=i;
            }
            else if(a[i]>a[tailIndices[len-1]])
            {
                prevIndices[i]=tailIndices[len-1];
                tailIndices[len++]=i;
            }
            else
            {
                int ceilValIndex=getCeilIndex(a,tailIndices,-1,len-1,a[i]);
                prevIndices[i]=tailIndices[ceilValIndex-1];
                tailIndices[ceilValIndex]=i;
            }

        }
        System.out.println("LIS is");
        for (int i = tailIndices[len-1]; i>=0 ; i=prevIndices[i]) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }


//    ------------------------------------------------------------------------------------------------------
//    ------------------------------------------------------------------------------------------------------
//    ------------------------------------------------------------------------------------------------------


    // Driver program to test the functions above
    public static void main(String args[])
    {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};
        int z[]={3, 2, 6, 4, 5, 1};
        int s[]={2,4,5,6,7,8,11,15};
        int k[]={11,22,33,1,2,3,4,5};


//        System.out.println("List A----------------");
//        System.out.println("Length of LIS is " + new LongestIncreasingSubsequence().lis( arr ));
//        new LongestIncreasingSubsequence().printLISAsString(arr);
//        new LongestIncreasingSubsequence().printLIS(arr);
//        System.out.println("Length of LIS is " + new LongestIncreasingSubsequence().lisLength( arr ));
//        new LongestIncreasingSubsequence().printLisLogn(arr);
//
//        System.out.println("List Z----------------");
//        System.out.println("Length of LIS is " + new LongestIncreasingSubsequence().lis( z ));
//        new LongestIncreasingSubsequence().printLISAsString(z);
//        new LongestIncreasingSubsequence().printLIS(z);
//        System.out.println("Length of LIS is " + new LongestIncreasingSubsequence().lisLength( z ));
//        new LongestIncreasingSubsequence().printLisLogn(z);
//
//        System.out.println("List S----------------");
//        System.out.println("Length of LIS is " + new LongestIncreasingSubsequence().lis( s ));
//        new LongestIncreasingSubsequence().printLISAsString(s);
//        new LongestIncreasingSubsequence().printLIS(s);
//        System.out.println("Length of LIS is " + new LongestIncreasingSubsequence().lisLength( s ));
//        new LongestIncreasingSubsequence().printLisLogn(s);

        System.out.println("List K----------------");
        System.out.println("Length of LIS is " + new LongestIncreasingSubsequence().lis( k ));
        new LongestIncreasingSubsequence().printLISAsString(k);
        new LongestIncreasingSubsequence().printLIS(k);
        System.out.println("Length of LIS is " + new LongestIncreasingSubsequence().lisLength( k ));
        new LongestIncreasingSubsequence().printLisLogn(arr);
    }
}
