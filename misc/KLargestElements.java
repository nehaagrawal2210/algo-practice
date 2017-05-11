package misc;

/**
 * Created by neha on 1/18/2017.
 */
public class KLargestElements {

    public static void main(String[] args) {
        int a[]={13,4,34,2,56,76,23};
        KLargestElements largestElements=new KLargestElements();
        largestElements.bubbleSort(a,3);
    }

    public void bubbleSort(int a[],int rank)
    {
        for (int i = 0; i < rank; i++) {
            for (int j = 0; j < a.length-i-1; j++) {
                if(a[j]>a[j+1])
                {
                    Util.swap(a,j+1,j);
                }
            }

        }
        //print last k elems
        for (int i = a.length-rank; i <a.length ; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }


}
