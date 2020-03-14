package practice1;

import java.util.Random;

public class OrderStatistics {

    public int findRankElement(int[] a, int p, int q, int rank) {
        if (rank > 0 && rank <= q - p + 1) {
            int r = randPartition(a, p, q);
            int currRank = r - p + 1;
            if (currRank == rank) {
                return a[r];
            } else if (currRank < rank) {
                return findRankElement(a, r + 1, q, rank - currRank);
            }
            return findRankElement(a, p, r - 1, rank);
        }
        return Integer.MIN_VALUE;
    }

    private int randPartition(int[] a, int p, int r) {
        int randomIndex = getRandomIndex(p, r);
        swap(a, p, randomIndex);
        int pivot = a[p], i = p;
        for (int j = p + 1; j <= r; j++) {
            if (a[j] < pivot) {
                swap(a, i + 1, j);
                i++;
            }
        }
        swap(a, p, i);
        return i;
    }

    private int getRandomIndex(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    private void swap(int[] a, int p, int q) {
        int temp = a[p];
        a[p] = a[q];
        a[q] = temp;
    }

    public static void main(String[] args) {

        int[] a = {6, 10, 13, 5, 8, 3, 2, 11};
//        2,3,5,6,8,10,11,13
        OrderStatistics os = new OrderStatistics();
        int element = os.findRankElement(a, 0, a.length - 1, 5);
        System.out.println("Element: " + element);
    }
}
