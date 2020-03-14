package practice1;

public class SortedMedian {

    public double median(int[] a, int s1, int e1, int[] b, int s2, int e2) {
        int n1 = e1 - s1 + 1;
        int n2 = e2 - s2 + 1;
        if (n1 == 0 && n2 == 0) {
            return Integer.MIN_VALUE;
        }
        if (n1 == 0) {
            return median(b, s2, e2);
        }
        if (n2 == 0) {
            return median(a, s1, e1);
        }
        if (n1 + n2 <= 4) {
            //total of 4 elements we can sort and find median now
            int[] merged = merge(a,s1,e1,b,s2,e2);
            int size = merged.length;
            if((size&1) == 0){
                return (merged[size/2]+merged[size/2-1])/2.0;
            }
            return merged[size/2];
        }

        double m1 = median(a, s1, e1);
        double m2 = median(b, s2, e2);

        if (m1 == m2) {
            return m1;
        }

        if (m1 < m2) {
            if ((n1 & 1) == 0) {
                return median(a, s1 + n1 / 2 - 1, e1, b, s2, s2 + n2 / 2);
            }
            return median(a, s1 + n1 / 2, e1, b, s2, s2 + n2 / 2);
        }
        if ((n2 & 1) == 0) {
            return median(a, s1, s1 + n1 / 2, b, s2 + n2 / 2 - 1, e2);
        }
        return median(a, s1, s1 + n1 / 2, b, s2 + n2 / 2, e2);
    }

    private int[] merge(int[] a, int s1, int e1, int[] b, int s2, int e2) {
        int n1 = e1 - s1 + 1;
        int n2 = e2 - s2 + 1;
        int[] merged = new int[e1 - s1 + 1 + e2 - s2 + 1];
        int index = 0;
        int left = s1, right = s2;
        while (left < n1 && right < n2) {
            if(a[left]<b[right]){
                merged[index++] = a[left++];
            } else{
                merged[index++] = b[right++];
            }
        }
        while(left<n1){
            merged[index++] = a[left++];
        }
        while(right<n2){
            merged[index++] = b[right++];
        }
        return merged;
    }

    private double median(int[] a, int s, int e) {
        int n = e - s + 1;
        if ((n & 1) == 0) {
            return (a[s + n / 2] + a[s + n / 2 - 1]) / 2.0;
        }
        return a[s + n / 2];
    }

    public static void main(String[] args) {
        int[] a = {1,2};
        int[] b = {1,2,3};
        System.out.println(new SortedMedian().median(a, 0, a.length - 1, b, 0, b.length - 1));
    }
}
