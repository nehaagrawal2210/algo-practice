package misc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by neha on 1/23/2017.
 */
public class CoinBreak {


    public static long coinBreak(long coinValue, HashMap<Long, Long> a) {

        if (coinValue <= 0)
            return Long.valueOf(0);

        if (a.containsKey(coinValue))
            return a.get(coinValue);
        else
            a.put(coinValue, Math.max(coinValue,
                    coinBreak(coinValue / 2, a) + coinBreak(coinValue / 3, a) + coinBreak(coinValue / 4, a)));
        return a.get(coinValue);
    }

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        long[] coinValue = new long[10];
        HashMap<Long, Long> a = new HashMap<>();

        int i = 0;
        while (in.hasNextLong()) {
            coinValue[i++] = in.nextLong();
        }

        for (int j = 0; j <i; j++) {
            System.out.println(coinBreak(coinValue[j],a));
        }

    }

}
