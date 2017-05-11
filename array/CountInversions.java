package array;

/**
 * Created by neha on 1/12/2017.
 */
public class CountInversions {

    public static void main(String[] args) {
        int a[] = {1, 20, 6, 4, 5};
        int z[]={2, 4, 1, 3, 5};
        CountInversions c = new CountInversions();
        System.out.println("Count Inversions A Naive= "+c.naive(a));
        System.out.println("Count Inversions Z Naive= "+c.naive(z));
        System.out.println();
        System.out.println("Count Inversions A Merge= "+c.mergeSortNCountInversions(a,0,a.length-1));
        System.out.println("Count Inversions Z Merge= "+c.mergeSortNCountInversions(z,0,z.length-1));
    }

    public int naive(int a[])
    {
        int inv=0;
        for(int i=0;i<a.length;i++)
        {
            for (int j=i+1;j<a.length;j++)
            {
                if(a[i]>a[j])
                    inv++;
            }
        }
        return inv;
    }

    public int mergeSortNCountInversions(int a[],int left,int right)
    {
        int mid,inversionCount=0;
        if(right>left)
        {
            mid=(left+right)/2;
            inversionCount+=mergeSortNCountInversions(a,left,mid);
            inversionCount+=mergeSortNCountInversions(a,mid+1,right);
            inversionCount+=merge(a,left,mid,right);
        }
        return inversionCount;
    }

    public int merge(int a[],int left,int mid,int right)
    {
        int size1=mid-left+1;
        int size2=right-mid;
        int inversionCount=0;

        int l[]=new int[size1];
        int r[]=new int[size2];

        for (int i=0;i<size1;i++)
            l[i]=a[left+i];
        for (int i=0;i<size2;i++)
            r[i]=a[i+mid+1];

        int k=left,i=0,j=0;

        while (i<size1 && j<size2)
        {
            if(l[i]<r[j])
                a[k++]=l[i++];
            else
            {
                a[k++]=r[j++];
                //count inversions here as left side is smaller than right
                inversionCount+=(size1-i);
            }

        }
        while (i<size1)
            a[k++]=l[i++];
        while (j<size2)
            a[k++]=r[j++];
        return inversionCount;
    }
}
