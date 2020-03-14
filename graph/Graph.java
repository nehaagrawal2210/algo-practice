package graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Graph {
    int SIZE;
    Set<Integer>[] adjacencyList;

    public Graph(int size) {
        SIZE = size;

        adjacencyList = new HashSet[SIZE];

        for (int i = 0; i < SIZE; i++) {
            adjacencyList[i] = new HashSet<>();
        }
    }

    public void addEdge(int src, int dest) {
        Set<Integer> srcList = adjacencyList[src];
        srcList.add(dest);
    }

    public void addBidirectionalEdge(int src, int dest) {
        Set<Integer> srcList = adjacencyList[src];
        srcList.add(dest);
        Set<Integer> destList = adjacencyList[dest];
        destList.add(src);
    }

    public void printGraph() {

        int index = 0;
        for (Set<Integer> adj : adjacencyList) {
            System.out.println(index++ + "->" + Arrays.toString(adj.toArray()));
        }
        System.out.println();
    }

    private void dfs(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> iterator = adjacencyList[v].iterator();
        while (iterator.hasNext()) {
            int n = iterator.next();
            if (!visited[n]) {
                dfs(n, visited);
            }
        }
    }

    public int getMother() {
        boolean[] visited = new boolean[SIZE];
        Arrays.fill(visited, false);
        int v = 0;

        for (int i = 0; i < SIZE; i++) {
            if (!visited[i]) {
                dfs(i, visited);
                v = i;
            }
        }

        Arrays.fill(visited, false);
        dfs(v, visited);
        for (int i = 0; i < SIZE; i++) {
            if (!visited[i]) {
                return -1;
            }
        }
        return v;
    }

    public void dfs(int src) {
        boolean[] visited = new boolean[SIZE];
        dfs(src, visited);

        for (int i = 0; i < SIZE; i++) {
            if (!visited[i]) {
                dfs(i, visited);
            }
        }
        System.out.println();
    }

    public void bfs(int src) {
        boolean[] visited = new boolean[SIZE];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            visited[curr] = true;
            System.out.print(curr + " ");
            Iterator<Integer> adj = adjacencyList[curr].iterator();
            while (adj.hasNext()) {
                int n = adj.next();
                if (!visited[n]) {
                    queue.add(n);
                }
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.printGraph();
        g.bfs(2);
        g.dfs(2);

        g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(4, 1);
        g.addEdge(6, 4);
        g.addEdge(5, 6);
        g.addEdge(5, 2);
        g.addEdge(6, 0);

        g.printGraph();
        g.bfs(1);
        System.out.println("g.getMother() = " + g.getMother());
    }
}
