package dp;

/**
 * Created by neha on 2/1/2017.
 */
public class CoinChange {

    public static int getCoinChangeRec(int s[],int m,int n)
    {
        if (n==0)
            return 1;
        if(n<0)
            return 0;
        if(m<=0 && n>0)
            return 0;
        return getCoinChangeRec(s,m-1,n)+getCoinChangeRec(s,m,n-s[m-1]);
    }

    public static int getCoinChangeDP(int s[],int m,int n)
    {
        int coinChange[][]=new int[n+1][m];
        int x,y;

        //n=0 case
        for (int i = 0; i < m; i++) {
            coinChange[0][i]=1;
        }

        for (int i = 1 ; i <=n; i++) {
            for (int j = 0; j < m; j++) {

                //solutions including s[j]
                x=(i-s[j]>=0)?coinChange[i-s[j]][j]:0;
                //solutions excluding s[j]
                y=(j>0)?coinChange[i][j-1]:0;
                coinChange[i][j]=x+y;
            }
        }
        return coinChange[n][m-1];
    }

    public static int getCoinChangeDPSpaceOpt(int s[],int m,int n)
    {
        int coinChange[]=new int[n+1];
        coinChange[0]=1; //base case n=0

        for (int i = 0; i < m; i++) {
            for (int j = s[i]; j <= n; j++) {
                coinChange[j]+=coinChange[j-s[i]];
            }
        }
        return coinChange[n];
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        System.out.println(getCoinChangeRec(arr,3,4));
        System.out.println(getCoinChangeDP(arr,3,4));
        System.out.println(getCoinChangeDPSpaceOpt(arr,3,4));
    }
}
