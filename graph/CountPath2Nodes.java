package graph;

import java.util.LinkedList;
import java.util.Queue;

import junit.framework.TestCase;

public class CountPath2Nodes extends TestCase {

    public void testCountPath() {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 4);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(3, 2);

        int s = 0, d = 4;
        System.out.println(countPath(g, s, d));
    }

    public int countPath(Graph graph, int src, int dest) {
        int path = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == dest) {
                path++;
            }
            for (int child : graph.adjacencyList[curr]) {
                queue.add(child);
            }
        }
        return path;
    }
}
