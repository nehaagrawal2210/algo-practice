package misc;

/**
 * Created by neha on 1/18/2017.
 */
public class Util {

    /**
     * Method to swap two elements in the array
     * @param a array in which swap has to be performed
     * @param i swap location 1
     * @param j swap location 2
     */
    public static void swap(int a[],int i,int j)
    {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    /**
     * Merge two arrays and return the result
     * @param a First Array to be merged
     * @param m Second Array to be merged
     */
    public int[] merge(int a[],int m[])
    {
        int result[]=new int[a.length+m.length];
        int aIndex=0,mIndex=0,resultIndex=0;

        while (aIndex<a.length && mIndex<m.length)
        {
            result[resultIndex++]=(a[aIndex]<=m[mIndex])?a[aIndex++]:m[mIndex++];
        }

        while (aIndex<a.length)
        {
            result[resultIndex++]=a[aIndex]++;
        }
        while (mIndex<m.length)
        {
            result[resultIndex++]=m[mIndex++];
        }
        return result;
    }

    public int getMaxIndex(int a[])
    {
        int max=0;
        for (int i = 1 ; i < a.length; i++) {
            if(a[i]>a[max])
                max=i;
        }
        return max;
    }

}
