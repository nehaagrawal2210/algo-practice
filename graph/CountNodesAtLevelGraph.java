package graph;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Assert;

import junit.framework.TestCase;

public class CountNodesAtLevelGraph extends TestCase {

    public void testCountNodes() {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 5);

        int level = 2;
        Assert.assertEquals(3, countNodesAtLevel(g, level, 0));
    }

    public int countNodesAtLevel(Graph graph, int level, int src) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.SIZE];
        int[] graphLevel = new int[graph.SIZE];
        queue.add(src);
        graphLevel[src] = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            visited[curr] = true;

            for (Integer child : graph.adjacencyList[curr]) {
                if (!visited[child]) {
                    graphLevel[child] = graphLevel[curr] + 1;
                    queue.add(child);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < graph.SIZE; i++) {
            if (graphLevel[i] == level) {
                count++;
            }
        }
        return count;
    }
}
