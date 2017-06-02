package array;

import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by neagrawa on 6/2/17.
 */
public class ZeroSumSubarray extends TestCase {
    public boolean hasZeroSumSubarray(int[] a)
    {
        Map<Integer,Integer> sumMap = new HashMap<>();
        int currRunningSum = a[0];
        for (int i = 1; i < a.length; i++) {
            if(currRunningSum ==0 || sumMap.containsKey(currRunningSum)) {
                System.out.println("Index= "+(i-1));
                return true;
            }
            sumMap.put(currRunningSum, i-1);
            currRunningSum+=a[i];
        }
        return false;
    }

    public static int zeroSumSubarrayCount(int[] a) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int currRunningSum = a[0];
        int subarrayCount = 0;
        for (int i = 1; i < a.length; i++) {
            if (currRunningSum == 0 || sumMap.containsKey(currRunningSum)) {
                subarrayCount++;
            }
            sumMap.put(currRunningSum, i-1);
            currRunningSum+=a[i];
        }
        return subarrayCount;
    }

    class Range{
        int start;
        int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        @Override public String toString() {
            return "("+ start + "," + end + ")";
        }
    }

    public List<Range> printZeroSumSubarrays(int[] a)
    {
        Map<Integer,List<Integer>> sumMap = new HashMap<>();
        List<Range> indexes = new ArrayList<>();

        int currRunningSum = 0;
        for (int i = 0; i < a.length; i++) {
            currRunningSum+=a[i];
            if(currRunningSum == 0){
                indexes.add(new Range(0,i));
            }

            if(sumMap.containsKey(currRunningSum)){
                List<Integer> list = sumMap.get(currRunningSum);
                Iterator<Integer> itr = list.iterator();
                while (itr.hasNext()){
                    indexes.add(new Range(itr.next()+1,i));
                }
                sumMap.get(currRunningSum).add(i);
            }
            else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                sumMap.put(currRunningSum,list);
            }
        }
        return indexes;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCases; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }
            System.out.println(zeroSumSubarrayCount(a));
        }
    }

    public void testHasZeroSumSubarray()
    {
        int[] a ={1, 4, -2, -2, 5, -4, 3};
        assertTrue(hasZeroSumSubarray(a));
        int[] b={4, 2, -3, 1, 6};
        assertTrue(hasZeroSumSubarray(b));
        int[] c={4, 2, 0, 1, 6};
        assertTrue(hasZeroSumSubarray(c));
        int[] d={-3, 2, 3, 1, 6};
        assertFalse(hasZeroSumSubarray(d));
        int arr[] = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        List<Range> indexes = printZeroSumSubarrays(arr);
        for (Range in: indexes) {
            System.out.println(in.toString());
        }
    }
}
