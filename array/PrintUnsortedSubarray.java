package array;

/**
 * Created by neha on 1/16/2017.
 */
public class PrintUnsortedSubarray {

    public static void printUnsorted(int a[])
    {
        int start,min,max,i,len=a.length,end;

        for (start=0;start<len-1;start++)
        {
            if(a[start]>a[start+1])
                break;
        }

        if(start==(len-1))
        {
            System.out.println("The array is sorted\r");
            return;
        }
        for(end=len-1;end>0;end--)
        {
            if(a[end-1]>a[end])
                break;
        }

        //now we have the initial subarray which is not sorted,
        // now we need to check if the array is really sorted

        max=a[start];
        min=a[start];

        //find max and min values in the array
        for (i=start+1;i<=end;i++)
        {
            if(a[i]>max)
                max=a[i];
            if(a[i]<min)
                min=a[i];
        }

        for (i=0;i<start;i++)
        {
            if(a[i]>min)
            {
                start=i;
                break;
            }
        }

        for (i=end+1;i<len;i++)
        {
            if(a[i]<max)
            {
                end=i;
                break;
            }
        }

        System.out.println("The unsorted subarray is:");
        for (i=start;i<=end;i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int a[]={10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
        int z[]={0, 1, 15, 25, 6, 7, 30, 40, 50};
        int s[]={1,2,3,4,5,6,7,8,9,10};
        int k[]={5,4,3,2,1};
        printUnsorted(a);
        printUnsorted(z);
        printUnsorted(s);
        printUnsorted(k);
    }
}
