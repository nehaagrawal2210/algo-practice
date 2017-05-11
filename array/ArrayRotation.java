package array;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by neha on 2/21/2017.
 */
public class ArrayRotation extends TestCase{

    public void jugglingLeftRotation(int a[],int d)
    {
        int l = a.length,temp,j,k=0;
        int gcdVal = gcd(l,d);
        for (int i = 0; i < gcdVal; i++) {
            temp = a[i]; //save first value
            for (j = i; ; j=k) {
                k=j+d;
                if(k>=l) k-=l;
                if(k==i) break;
                a[j]=a[k];
            }
            a[j]=temp;
        }
    }

    public void reversalRotation(int[] a,int d)
    {
        reverseArray(a,0,d-1);
        reverseArray(a,d,a.length-1);
        reverseArray(a,0,a.length-1);
    }

    public void reverseArray(int[] a,int start, int end)
    {
        int left = start, right = end,temp;
        while (left<right)
        {
            temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
    }

    public int gcd(int a,int m)
    {
        if(m==0)
            return a;
        return gcd(m,a%m);
    }

    @Test
    public void testJugglingLeftRotation()
    {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int arr1[] = {3, 4, 5, 6, 7, 1, 2};
        jugglingLeftRotation(arr, 2); //arr will change
        System.out.println(Arrays.toString(arr));
        assertTrue(Arrays.equals(arr1,arr));
    }

    @Test
    public void testReversalRotation()
    {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int arr1[] = {3, 4, 5, 6, 7, 1, 2};
        reversalRotation(arr,2);
        System.out.println(Arrays.toString(arr));
        assertTrue(Arrays.equals(arr1,arr));
    }
}
