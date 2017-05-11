package array;

/**
 * Created by neha on 1/11/2017.
 */
public class MaxContiguousSubarray {

    public static void main(String args[])
    {
        int a[]= {-2, -5, 6, -2, -3, 1, 5, -6};
        int z[]= {2, 3, 4, 5, 7};
        int h[]= {-3, -10, -9, -8, -1};
        MaxContiguousSubarray array = new MaxContiguousSubarray();
        System.out.println("Naive Sum for A = "+array.naiveSum(a));
        System.out.println("Naive Sum for Z = "+array.naiveSum(z));
        System.out.println("Naive Sum for H = "+array.naiveSum(h));

        System.out.println();

        System.out.println("DivideNConquer Sum for A = "+array.divideNConquer(a,0,7));
        System.out.println("DivideNConquer Sum for Z = "+array.divideNConquer(z,0,4));
        System.out.println("DivideNConquer Sum for H = "+array.divideNConquer(h,0,4));

        System.out.println();

        System.out.println("Kadane Sum for A = "+array.kadaneMethod(a));
        System.out.println("Kadane Sum for Z = "+array.kadaneMethod(z));
        System.out.println("Kadane Sum for H = "+array.kadaneMethod(h));

        System.out.println();

        System.out.println("Kadane Sum for A = "+array.maxSubArraySum(a));
        System.out.println("Kadane Sum for Z = "+array.maxSubArraySum(z));
        System.out.println("Kadane Sum for H = "+array.maxSubArraySum(h));

    }

    public int naiveSum(int a[])
    {
        int len = a.length;
        int maxSum=a[0];
        for (int i=0;i<len;i++)
        {
            int currSum=0;
            for (int j=i;j<len;j++)
            {
                currSum+=a[j];
                if(currSum>maxSum)
                {
                    maxSum =currSum;
                }
            }
        }
        return maxSum;
    }

    public int divideNConquer(int a[],int low,int high)
    {
        if(low==high)
            return a[low];
        int mid = (low+high)/2;
        int leftSum = divideNConquer(a,low,mid);
        int rightSum = divideNConquer(a,mid+1,high);
        int crossOverSum = calculateCrossOverSum(a,low,mid,high);
        return Math.max(crossOverSum,Math.max(leftSum,rightSum));
    }

    public int calculateCrossOverSum(int a[],int low,int mid,int high)
    {
        int sum=0,leftSum=Integer.MIN_VALUE,rightSum=Integer.MIN_VALUE;
        for (int i=mid;i>=low;i--)
        {
            sum+=a[i];
            if(sum>leftSum)
            {
                leftSum=sum;
            }
        }
        sum=0;
        for (int i=mid+1;i<=high;i++)
        {
            sum+=a[i];
            if(sum>rightSum)
            {
                rightSum=sum;
            }
        }
        return leftSum+rightSum;
    }

    public int kadaneMethod(int a[])
    {
        int maxSoFar=Integer.MIN_VALUE,maxEndingHere=0,start=0,end=0,s=0;
        for (int i=0;i<a.length;i++)
        {
            maxEndingHere+=a[i];
            if(maxSoFar<maxEndingHere)
            {
                maxSoFar=maxEndingHere;
                start=s;
                end=i;
            }
            if(maxEndingHere<0)
            {
                maxEndingHere=0;
                s=i+1;
            }
        }
        System.out.println("Start subarray= "+start+" End Subarray= "+end);
        return maxSoFar;
    }

    public int kadane(int a[])
    {
        int maxEndingHere=0,maxSoFar=Integer.MIN_VALUE,start=0,end=0,s=0;
        for (int i = 0; i < a.length; i++) {
            maxEndingHere+=a[i];
            if(maxSoFar<maxEndingHere)
            {
                maxSoFar = maxEndingHere;
                start=s;
                end = i;
            }
            if(maxEndingHere<0)
            {
                maxEndingHere = 0;
                s = i+1;
            }
        }
        System.out.println("Start= "+start+" End= "+end);
        return maxSoFar;
    }

    int maxSubArraySum(int a[])
    {
        int max_so_far = a[0];
        int curr_max = a[0];
        int start=0,end=0,s=0;

        for (int i = 1; i < a.length; i++)
        {
            if(curr_max+a[i]>a[i])
            {
                curr_max=curr_max+a[i];
            }
            else
            {
                curr_max=a[i];
                s=i;
            }

            if(max_so_far<curr_max)
            {
                max_so_far=curr_max;
                start=s;
                end=i;
            }
//            curr_max = Math.max(a[i], curr_max+a[i]);
//            max_so_far = Math.max(max_so_far, curr_max);
        }
        System.out.println("Start subarray= "+start+" End Subarray= "+end);
        return max_so_far;
    }

}
