package practice;

import junit.framework.TestCase;

/**
 * Created by neagrawa on 5/27/17.
 * Median of two sorted arrays
 */
public class Median extends TestCase{
    public float getMedian(int[] a,int[] b)
    {
        return getMedian(a,0,a.length-1,b,0,a.length-1);
    }

    public float getMedian(int[] a,int s1,int e1, int[] b,int s2, int e2)
    {
        int n = e1-s1+1;
        if(n<=0) return -1;
        if(n == 1) return (a[s1]+b[s2])/2.0f;
        if(n == 2)
            return (Math.max(a[s1],b[s2])+Math.min(a[e1],b[e2]))/2.0f;
        float m1= getMedian(a,s1,e1);
        float m2 = getMedian(b,s2,e2);

        if(m1 == m2) return m1;

        //median in val[0..m1] & b[m2..e2]
        if(m1>m2)
        {
            if(n%2==0) return getMedian(a,s1,s1+n/2-1,b,s2+n/2-1,e2);
           return getMedian(a,s1,s1+n/2,b,s2+n/2,e2);
        }
        if(n%2==0) return getMedian(a,s1+n/2-1,e1,b,s2,s2+n/2-1);
        return getMedian(a,s1+n/2,e1,b,s2,s2+n/2);
    }

    public float getMedian(int[] a,int s,int e)
    {
        int n = e-s+1;
        if(n%2==0)
            return (a[s+n/2]+a[s+n/2-1])/2.0f;
        return a[s+n/2];
    }

    public void testM()
    {
        int[] a1 = new int[]{1, 3, 5, 7, 9};
        int[] a2 = new int[]{2, 4, 6, 8, 10};
        assertEquals(5.5,getMedian(a1,a2),0.001);
    }
}
