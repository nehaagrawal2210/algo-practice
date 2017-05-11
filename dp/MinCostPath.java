package dp;

/**
 * Created by neha on 1/31/2017.
 */
public class MinCostPath {

    public static  int getMinCostPathRec(int a[][],int m,int l)
    {
        if(m<0 || l<0)
            return Integer.MAX_VALUE;
        if(m==0 && l==0)
            return a[m][l];
        else
            return a[m][l]+Math.min(getMinCostPathRec(a,m-1,l-1),Math.min(getMinCostPathRec(a,m,l-1),getMinCostPathRec(a,m-1,l)));
    }

    public static int getMinCostPathDP(int cost[][],int m,int l)
    {
        int minCost[][]=new int[m+1][l+1];

        for (int i = 0; i <=m ; i++) {
            for (int j = 0; j <=l ; j++) {
                if(i==0 && j==0)
                    minCost[i][j]=cost[i][j]; // minCost[0][0]=a[0][0];
                else if(j==0) // first col initialize
                    minCost[i][j]=minCost[i-1][j]+cost[i][j];
                else if(i==0) //first row initialize
                    minCost[i][j]=minCost[i][j-1]+cost[i][j];

                // construct rest of the array
                else
                minCost[i][j]=Math.min(Math.min(minCost[i-1][j-1],minCost[i][j-1]),minCost[i-1][j])+cost[i][j];
            }
        }
        return minCost[m][l];
    }

    public static void main(String[] args) {
        int cost[][] = { {1, 2, 3},
            {4, 8, 2},
            {1, 5, 3} };
        System.out.println(getMinCostPathRec(cost,2,2));
        System.out.println(getMinCostPathDP(cost,2,2));
    }
}
