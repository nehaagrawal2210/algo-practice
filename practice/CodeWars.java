package practice;

public class CodeWars {
    public static void main(String[] args) {
        int a[] = { 5, 2, 3, 1, 4 };
        System.out.println(getCount(a,a.length,3));
    }

    private static int getCount(int[] arr, int n, int k) {
        int dp[][] = new int[k][n], sum = 0;
        int dpDec[][] = new int[k][n];

        // count of increasing sequence of size 1
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
            dpDec[0][i] = 1;
        }

        for (int l = 1; l < k; l++) {

            // for each increasing sequence of size 'l'
            // ending with element arr[i]
            for (int i = l; i < n; i++) {

                // count of increasing sequences of size 'l'
                // ending with element arr[i]
                dp[l][i] = 0;
                dpDec[l][i] = 0;
                for (int j = l - 1; j < i; j++) {
                    if (arr[j] < arr[i]) {
                        dp[l][i] += dp[l - 1][j];
                    } else {
                        dpDec[l][i] += dpDec[l - 1][j];
                    }
                }
            }
        }

        for (int i = k - 1; i < n; i++) {
            sum += dp[k - 1][i];
            sum += dpDec[k - 1][i];
        }

        return sum;
    }
}
