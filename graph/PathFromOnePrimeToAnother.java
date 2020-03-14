package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import junit.framework.TestCase;

public class PathFromOnePrimeToAnother extends TestCase {

    private List<Integer> sieve(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        List<Integer> primes = new ArrayList<>();

        for (int p = 2; p * p < n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }

        for (int i = 1000; i <= n; i++) {
            if (prime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    public List<Integer> getNumberPath(int num1, int num2) {
        List<Integer> primes = sieve(9999);
        Graph graph = new Graph(primes.size());

        // create graph between numbers differing by single digit only.
        for (int i = 0; i < primes.size(); i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                if (isDifferenceOfSingleDigit(primes.get(i), primes.get(j))) {
                    graph.addBidirectionalEdge(i, j);
                }
            }
        }

        int src = 0, dest = 0;
        for (int i = 0; i < primes.size(); i++) {
            if (primes.get(i) == num1) {
                src = i;
            } else if (primes.get(i) == num2) {
                dest = i;
            }
        }

        // find source and destination
        System.out.println(bfs(graph, src, dest));
//        List<Integer> primeIndexes = bfs(graph, src, dest);
        List<Integer> numberPath = new ArrayList<>();
//        for (int index : primeIndexes) {
//            numberPath.add(primes.get(index));
//        }
        return numberPath;
    }

    private int bfs(Graph graph, int src, int dest) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        int[] level = new int[graph.SIZE];
        level[src] = 1;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            Iterator<Integer> iterator = graph.adjacencyList[curr].iterator();
            while (iterator.hasNext()){
                int next = iterator.next();
                if(level[next]==0){
                    level[next] = level[curr]+1;
                    queue.add(next);
                }
                if(next == dest){
                    return level[next]-1;
                }
            }
        }
        return 0;
    }

    private boolean isDifferenceOfSingleDigit(int num1, int num2) {
        // To compare the digits
        char[] s1 = String.valueOf(num1).toCharArray();
        char[] s2 = String.valueOf(num2).toCharArray();
        int c = 0;
        if (s1[0] != s2[0])
            c++;
        if (s1[1] != s2[1])
            c++;
        if (s1[2] != s2[2])
            c++;
        if (s1[3] != s2[3])
            c++;

        // If the numbers differ only by a single
        // digit return true else false
        return (c == 1);
    }

    public void testNumberPath() {
        int num1 = 1033, num2 = 8179;
        System.out.println(Arrays.toString(getNumberPath(num1, num2).toArray()));
    }
}
