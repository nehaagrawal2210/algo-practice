package dp;

/**
 * Created by neha on 1/31/2017.
 */
public class EditDist {

    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";

        System.out.println(editDistRec( str1 , str2 , str1.length(), str2.length()));
        System.out.println(editDistRecDP( str1 , str2 , str1.length(), str2.length()));
    }

    public static int editDistRec(String s1, String s2, int m, int n)
    {
        if(m==0)
            return n;
        if(n==0)
            return m;
        if(s1.charAt(m-1)==s2.charAt(n-1))
        {
            //recur for reduced length
            return editDistRec(s1,s2,m-1,n-1);
        }
        else return 1+Math.min(Math.min(editDistRec(s1,s2,m,n-1), editDistRec(s1,s2,m-1,n)), editDistRec(s1,s2,m-1,n-1));
    }

    public static int editDistRecDP(String s1, String s2, int m, int n )
    {
        int dist[][]=new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if(i==0 || j==0)
                    dist[i][j]=i+j;
                else if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    //nothing to do
                    dist[i][j]=dist[i-1][j-1];
                }
                else {
                    dist[i][j]=1+Math.min(Math.min(dist[i-1][j],dist[i][j-1]),dist[i-1][j-1]);
                }
            }
        }
        return dist[m][n];
    }
}
