package misc;

/**
 * Created by neha on 1/18/2017.
 */
public class CountOnes {

    public static void main(String[] args) {
        int a[]={1,1,1,0,0};
        int m[]={1,1,1,1,1,1,1,1};
        int k[]={0,0,0,0};
        System.out.println(returnLastOccurence(a,0,a.length-1));
        System.out.println(returnLastOccurence(m,0,m.length-1));
        System.out.println(returnLastOccurence(k,0,k.length-1));
    }

    public static int returnLastOccurence(int a[],int low,int high)
    {
        if(low<=high)
        {
            int mid=low+(high-low)/2;
            if((mid==high || a[mid+1]==0) && a[mid]==1)
                return mid+1;
            if(a[mid]==1)
                return returnLastOccurence(a,mid+1,high);
            return returnLastOccurence(a,low,mid-1);
        }
        return 0;
    }
}
