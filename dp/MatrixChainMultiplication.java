package dp;

/**
 * Created by neha on 2/1/2017.
 */
public class MatrixChainMultiplication {

    public static int getMultiplicationCountRec(int m[], int i, int j)
    {
        if(i==j)
            return 0;
        int min=Integer.MAX_VALUE,count;

        for (int k = i; k < j; k++) {
            count= getMultiplicationCountRec(m,i,k)+ getMultiplicationCountRec(m,k+1,j)+m[i-1]*m[k]*m[j];
            if(count<min)
                min=count;
        }
        return min;
    }

    public static int getMatrixMulCount(int m[],int n)
    {
        int[][] mul=new int[n][n];
        int i,j,q;

        for (i = 0; i < n; i++) {
            mul[i][i]=0;
        }
        for (int L = 2; L < n; L++) {
            for (i = 1; i < n-L+1; i++) {
                j=i+L-1;
                mul[i][j]=Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    q= mul[i][k]+mul[k+1][j]+m[i-1]*m[k]*m[j];
                    if(q<mul[i][j])
                        mul[i][j]=q;
                }
            }
        }
        return mul[1][n-1];
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        System.out.println(getMultiplicationCountRec(arr,1,3));
        int mCount=getMatrixMulCount(arr,4);
        System.out.println(mCount);
    }
}
