package dp;

/**
 * Created by neha on 2/1/2017.
 */
public class Knapsack {

    public static int knapsack01Rec(int val[],int w[],int totalW,int n)
    {
        if(n==0 || totalW==0)
            return 0;

        if(w[n-1]>totalW)
            return knapsack01Rec(val,w,totalW,n-1);

        return  Math.max(knapsack01Rec(val,w,totalW,n-1) //excluding nth item
                ,knapsack01Rec(val,w,totalW-w[n-1],n-1)+val[n-1]); //including nth item
    }

    public static int knapsack01DP(int val[],int w[],int totalW,int n)
    {
        int k[][]= new int[n+1][totalW+1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < totalW + 1; j++) {
                if(i==0 || j==0) //total wt is 0 or items are 0 base case
                    k[i][j]=0;
                else if(w[i-1]<=j)
                    k[i][j]=Math.max(k[i-1][j],k[i-1][j-w[i-1]]+val[i-1]);
                else
                    k[i][j]=k[i-1][j];
            }
        }
        return k[n][totalW];
    }

    public static void main(String[] args) {
        int val[] = {6, 1, 12};
        int wt[] = {1, 2, 3};
        int  W = 5;
        System.out.println(knapsack01Rec(val,wt,W,3));
        System.out.println(knapsack01DP(val,wt,W,3));
    }
}
