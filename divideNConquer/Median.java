package divideNConquer;

/**
 * Created by neha on 1/11/2017.
 */
public class Median {

    public static void main(String[] args) {

        int[] a1 = new int[]{1, 3, 5, 7, 9};
        int[] a2 = new int[]{2, 4, 6, 8, 10};
        System.out.println("O(logn) -> "+getMedian(a1,a2));
    }

    public static float getMedian(int a[],int z[])
    {
        int n=a.length-1;
        return _getMedian(a,0,n,z,0,n);
    }

    public static float _getMedian(int a[],int s1,int e1,int z[],int s2,int e2)
    {
        int n=e1-s1+1;
        if(n<=0)
            return -1;
        if(n==1)
            return (a[s1]+z[s2])/2.0f;
        if(n==2)
            return (Math.max(a[s1],z[s2])+Math.min(a[e1],z[e2]))/2.0f;

        float m1=median(a,s1,e1);
        float m2=median(z,s2,e2);

        if(m1==m2)
            return m1;

        //m1>m2 median exists in a[0...m1] & z[m2....]
        if(m1>m2)
        {
            if(n%2==0)
            return _getMedian(a,s1,s1+(n/2)-1,z,s2+(n/2),e2);
            return _getMedian(a,s1,s1+(n/2),z,s2+(n/2),e2);
        }

        //m1<m2 median exists in a[m1....] & z[0....m2]
        if(n%2==0)
            return _getMedian(a,s1+(n/2),e1,z,s2,s2+(n/2)-1);
        return _getMedian(a,s1+(n/2),e1,z,s2,s2+(n/2));

    }

    public static float median(int a[],int s,int e)
    {
        int n=e-s+1;
        if(n%2==0)
            return (a[s+n/2]+a[s+n/2-1])/2.0f;
        else
            return a[s+n/2];
    }
}
