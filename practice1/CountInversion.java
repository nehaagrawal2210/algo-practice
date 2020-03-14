package practice1;

import java.util.Arrays;

public class CountInversion {

    private int size2;

    public int naive(int[] a) {

        int invCount = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    invCount++;
                }
            }
        }
        return invCount;
    }

    public int mergeInvCount(int[] a, int low, int high) {
        int invCount = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            invCount += mergeInvCount(a, low, mid);
            invCount += mergeInvCount(a, mid + 1, high);
            invCount += mergeInvCount(a, low, mid, high);
        }
        return invCount;
    }

    public int mergeInvCount(int[] a, int low, int mid, int high) {
        int size1 = mid - low + 1;
        int size2 = high - mid;

        int[] left = Arrays.copyOfRange(a, low, mid + 1);
        int[] right = Arrays.copyOfRange(a, mid + 1, high + 1);

        int l = 0, r = 0, i = low;
        int invCount = 0;
        while (l < size1 && r < size2) {
            if (left[l] < right[r]) {
                a[i++] = left[l++];
            } else {
                a[i++] = right[r++];
                invCount += (size1 - l);
            }
        }
        while (l < size1) {
            a[i++] = left[l++];
        }
        while (r < size2) {
            a[i++] = right[r++];
        }
        return invCount;
    }


    public static void main(String[] args) {
        CountInversion cv = new CountInversion();
        int[] a = {1, 20, 6, 4, 5};
        System.out.println(cv.naive(a));
        System.out.println(cv.mergeInvCount(a, 0, a.length - 1));
    }
}
