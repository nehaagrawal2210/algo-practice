package array;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by neha on 2/21/2017.
 */
public class FrequencySort {

    class Elem implements Comparable{
        int count;
        int index;
        int val;

        public Elem(int data, int index,int val) {
            this.count = data;
            this.index = index;
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Elem)) return false;

            Elem elem = (Elem) o;

            if (count != elem.count) return false;
            if (index != elem.index) return false;
            return val == elem.val;

        }

        @Override
        public String toString() {
            return "Elem{" +
                    "count=" + count +
                    ", index=" + index +
                    ", val=" + val +
                    '}';
        }

        @Override
        public int hashCode() {
            int result = count;
            result = 31 * result + index;
            result = 31 * result + val;
            return result;
        }

        @Override
        public int compareTo(Object o) {
            if (!(o instanceof Elem)) return -1;
            Elem elem = (Elem) o;
            if(count!=elem.count)  return elem.count-count;
            return index-elem.index ;
        }
    }

    public void sortByFrequency(int[] a)
    {
        Map<Integer,Elem> countMap = new HashMap<>();
        Elem elem;
        for (int i = 0; i < a.length; i++) {
            if(countMap.containsKey(a[i]))
            {
                elem = countMap.get(a[i]);
                elem.count= elem.count+1;
                countMap.remove(a[i]);
                countMap.put(a[i],elem);
            }
            else{
                countMap.put(a[i],new Elem(1,i,a[i]));
            }
        }
        List<Elem> elemValues= countMap.values().stream().collect(Collectors.toList());
        Collections.sort(elemValues);
        System.out.println(elemValues.toString());
    }

    @Test
    public void testSortFrequency()
    {
        int arr[] = {2, 5, 2, 8, 5, 6, 8, 8};
        sortByFrequency(arr);
    }
}
