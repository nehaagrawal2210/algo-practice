package array;

/**
 * Created by neha on 1/19/2017.
 */
public class PrintClosestPair {

    public static void main(String[] args) {
        int arr[] =  {10, 22, 28, 29, 30, 40}, x = 54;
        printClosestSumPair(arr,x);
    }

    public static void printClosestSumPair(int a[],int x)
    {
        int left=0;
        int right=a.length-1;
        int res_left,res_right;
        res_left=left;
        res_right=right;

        int diff=Integer.MAX_VALUE;

        while (left<right)
        {
            int tempSum=a[left]+a[right];
            if(Math.abs(tempSum-x)<diff)
            {
                diff=Math.abs(tempSum-x);
                res_left=left;
                res_right=right;
            }
            if (tempSum>x)
            {
                right--;
            }
            else //(tempSum<x)
            {
                left++;
            }
        }

        System.out.println("Closest Pair = "+a[res_left]+" "+a[res_right]);
    }
}
