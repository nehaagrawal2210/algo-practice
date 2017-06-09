package practice;

import junit.framework.TestCase;

/**
 * Created by neagrawa on 6/3/17.
 */
public class LIS extends TestCase{
    class Max{
        int max;
    }
    public int getLIS(int[] a, int n, Max max)
    {
        if(n==1) return 1;
        int res, maxEndingHere = 1;
        for (int i = 1; i < n; i++) {
            res = getLIS(a,i,max);
            if(a[i-1]<a[n-1] && res+1>maxEndingHere)
                maxEndingHere = res+1;
        }
        if(max.max<maxEndingHere) max.max = maxEndingHere;
        return maxEndingHere;
    }

    public int getLIS(int[] a)
    {
        Max max = new Max();
        max.max =1;
        getLIS(a,a.length,max);
        return max.max;
    }

    public int lisLenDP(int[] a)
    {
        int i,j,max=0;
        int dp[] = new int[a.length];
        for (i = 0; i < a.length-1; i++) {
            dp[i]=1;
        }
        for (i = 1; i < a.length; i++) {
            for (j = 0; j < i; j++) {
                if(a[i]>a[j] && dp[i]<dp[j]+1)
                    dp[i]=dp[j]+1;
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public String getLISString(int[] a)
    {
        String max="";
        boolean ischanged;
        String lis[] = new String[a.length];
        for (int i = 0; i < a.length; i++) {
            lis[i]=""+a[i];
        }
        for (int i = 1; i < a.length; i++) {
            ischanged = false;
            for (int j = 0; j < i; j++) {
                if(a[i]>a[j] && lis[i].length()<lis[j].length()+1)
                {
                    lis[i]= lis[j];
                    ischanged = true;
                }
            }
            if(ischanged) lis[i]+=" "+a[i];
            if(max.length()<lis[i].length()) max = lis[i];
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(lis[i]);
        }
        return max;
    }

    public void testLIS()
    {
        int[] a = { 10, 22, 9, 33, 21, 50, 41, 60 };
        System.out.println(getLIS(a));
        System.out.println(lisLenDP(a));
        System.out.println("LIS= "+getLISString(a));
    }
}
