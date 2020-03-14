package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

//https://www.geeksforgeeks.org/maximum-unique-element-every-subarray-size-k/
public class UniqueElement {

    public static void main(String[] args) {
        int[] a = { 3, 3, 3, 4, 4, 2 };
        int k = 4;
        List<Integer> res = getUniqueMaxElementsInKSubarray(a, k);
        System.out.println("Arrays.toString(res.toArray()) = " + Arrays.toString(res.toArray()));
    }

    private static List<Integer> getUniqueMaxElementsInKSubarray(int[] a, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        TreeSet<Integer> elems = new TreeSet<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k - 1; i++) {
            count.put(a[i], count.getOrDefault(a[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                elems.add(entry.getKey());
            }
        }

        for (int i = k - 1, l2 = 0; i < a.length; i++, l2++) {
            count.put(a[i], count.getOrDefault(a[i], 0) + 1);
            if (count.get(a[i]) == 1) {
                elems.add(a[i]);
            } else {
                elems.remove(a[i]);
            }

            if (elems.isEmpty()) {
                res.add(-1);
            } else {
                res.add(elems.last());
            }

            int firstElemCount = count.get(a[l2]);
            count.put(a[l2], firstElemCount - 1);

            if (firstElemCount == 2) {
                elems.add(a[l2]);
            }
            if (firstElemCount == 1) {
                elems.remove(a[l2]);
            }

        }
        return res;
    }

}
