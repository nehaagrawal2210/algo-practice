package misc;

/**
 * Created by neha on 1/16/2017.
 */
//http://www.geeksforgeeks.org/find-k-closest-elements-given-value/
public class KClosest {

    public static void main(String[] args) {

        KClosest ob = new KClosest();
        int arr[] = {12, 16, 22, 30, 35, 39, 42,
                45, 48, 50, 53, 55, 56
        };
        int x = 35, k = 4;
        ob.printKClosest(arr,x,k);
    }

    public int findCrossover(int a[],int low,int high,int x)
    {
        int len=a.length;

        //base cases
        //all elements larger
        if(a[low]>=x)
            return low;
        //all elements smaller
        if(a[high]<=x)
            return high;

        //find the mid
        int mid=(high+low)/2;

        if(a[mid]<=x && a[mid+1]>x)
            return mid;

        if(a[mid]<x)
            return findCrossover(a,mid+1,high,x);
        return findCrossover(a,low,mid-1,x);
    }

    public void printKClosest(int a[],int x,int k)
    {
        int crossOverPoint=findCrossover(a,0,a.length-1,x);
        int r=crossOverPoint+1;
        int count=0;

        if(a[crossOverPoint]==x)
            crossOverPoint--;

        while (crossOverPoint>=0 && r<a.length && count<k)
        {
            if(x-a[crossOverPoint] < a[r]-x)
                System.out.print(a[crossOverPoint--]+" ");
            else
                System.out.print(a[r++]+" ");
            count++;
        }

        while (count<k && crossOverPoint>=0) {
            System.out.print(a[crossOverPoint--] + " ");
            count++;
        }

        while (count<k && r<a.length){
            System.out.print(a[r++]);
            count++;
        }
    }

}
