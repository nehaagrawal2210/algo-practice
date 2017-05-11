package dp;

/**
 * Created by neha on 2/1/2017.
 */
public class BinomialCoefficient {

    public static int getCoefficientRec(int n,int k)
    {
        if(k==0 || k==n)
            return 1;
        return getCoefficientRec(n-1,k-1)+getCoefficientRec(n-1,k);
    }

    public static int getCoefficientDP(int n,int k)
    {
        int coefficient[][]=new int[n+1][k+1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j <= Math.min(i,k); j++) {
                if(j==0 || j==i)
                    coefficient[i][j]=1;
                else
                {
                    coefficient[i][j]=coefficient[i-1][j-1]+coefficient[i-1][j];
                }
            }
        }
        return coefficient[n][k];
    }

    public static void main(String[] args) {
        int n = 5, k = 2;
        System.out.println(getCoefficientRec(n,k));
        System.out.println(getCoefficientDP(n,k));
    }
}
