package practice;

import java.util.Arrays;

public class CountInversion {

    private static int countInversion(int[] a, int low, int high) {
        if (low > high) {
            return 0;
        }

        int mid = low + (high - low) / 2;
        int lInv = countInversion(a, low, mid);
        int rInv = countInversion(a, mid + 1, high);
        return lInv + rInv + mergeInvCount(a, low, mid, high);
    }

    private static int mergeInvCount(int[] a, int low, int mid, int high) {
        int size1 = mid - low + 1;
        int size2 = high - mid;
        int left[] = Arrays.copyOfRange(a, low, mid + 1);
        int right[] = Arrays.copyOfRange(a, mid + 1, high);

        int l = 0, r = 0, i = low;
        int invCount = 0;
        while (l < size1 && r < size2) {
            if(left[l] < right[r]){
                a[i++] = left[l++];
            } else {
                a[i++] = right[r++];
                invCount+=(size1-l);
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
}
