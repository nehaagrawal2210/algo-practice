package array;

import misc.Sorting;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by neha on 1/18/2017.
 */
public class printSumPair {

//    http://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/

    public static void main(String[] args) {
        int a[]={3,13,4,7,10};
        int z[]={3,13,4,7,10};
        System.out.println(sortingMethod(a,13));
        System.out.println(hashMethod(z,13));
    }

    public static boolean hashMethod(int a[],int x)
    {
        Map<Integer,Boolean> map= new HashMap<Integer,Boolean>();
        for (int i = 0; i < a.length; i++) {
            int temp=x-a[i];
            if(map.containsKey(temp))
            {
                System.out.println(a[i]+" "+temp);
                return true;
            }
            else
                map.put(a[i],true);
        }
        return false;
    }

    public static boolean sortingMethod(int a[],int x)
    {
        Sorting s = new Sorting();
        s.quickSort(a,0,a.length-1);

        int left=0;
        int right=a.length-1;

        while (left<right)
        {
            if(a[left]+a[right]==x) {
                System.out.println(a[left]+" "+a[right]);
                return true;
            }
            else if(a[left]+a[right]<x)
                left++;
            else
                right--;
        }
        return false;
    }
}
