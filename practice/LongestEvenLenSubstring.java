package practice;

import junit.framework.TestCase;

/**
 * Created by neagrawa on 6/10/17.
 */
public class LongestEvenLenSubstring extends TestCase {
    public int getLen(String str) {
        int len = str.length();
        int l, r, lsum, rsum, maxLen = 0;
        for (int i = 0; i <= len - 2; i++) {
            l = i;
            r = i + 1;
            lsum = 0;
            rsum = 0;
            while (r < len && l >= 0) {
                lsum += Character.getNumericValue(str.charAt(l));
                rsum += Character.getNumericValue(str.charAt(r));
                if (lsum == rsum) {
                    maxLen = Math.max(maxLen, r - l + 1);
                }
                l--;
                r++;
            }
        }
        return maxLen;
    }

    public int getLenDP(String str) {

        int n = str.length(), maxLen = 0;
        int[][] sum = new int[n][n];
        for (int i =0; i<n; i++)
            sum[i][i] = str.charAt(i)-'0';
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                int k = len / 2;
                sum[i][j] = sum[i][j - k] + sum[j - k + 1][j];
                if (len % 2 == 0 && sum[i][j - k] == sum[j - k + 1][j] && len > maxLen) {
                    maxLen = len;
                }
            }
        }
        return maxLen;
    }

    public void testGetLen() {
        String str = "123123";
        assertEquals(6, getLen(str));
        assertEquals(6, getLenDP(str));
    }
}
