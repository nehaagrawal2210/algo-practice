package graph;

import org.junit.Test;

import junit.framework.TestCase;

public class KCores extends TestCase {

    private boolean dfs(Graph graph, int src, boolean[] visited, int[] degree, int k) {

        visited[src] = true;
        for (int i : graph.adjacencyList[src]) {
            if (degree[src] < k) {
                degree[i]--;
            }
            if (!visited[i]) {
                if (dfs(graph, i, visited, degree, k)) {
                    degree[src]--;
                }
            }
        }
        return degree[src] < k;
    }

    private int fillDegreeAndMinDegreeVertex(Graph graph, int[] degree) {
        int mindeg = Integer.MAX_VALUE;
        int startvertex = 0;

        // Store degrees of all vertices
        for (int i = 0; i < graph.SIZE; i++)
        {
            degree[i] = graph.adjacencyList[i].size();

            if (degree[i] < mindeg)
            {
                mindeg = degree[i];
                startvertex = i;
            }
        }
        return startvertex;
    }

    public void printKCores(Graph graph, int k) {
        boolean[] visited = new boolean[graph.SIZE];
        int[] degree = new int[graph.SIZE];
        int minDegVertex = fillDegreeAndMinDegreeVertex(graph, degree);
        dfs(graph, minDegVertex, visited, degree, k);

        for (int i = 0; i < graph.SIZE; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited, degree, k);
            }
        }

        // print k cores
        for (int i = 0; i < graph.SIZE; i++) {
            if (degree[i] >= k) {
                System.out.print(i + "->");
                for (int j : graph.adjacencyList[i]) {
                    if (degree[j] >= k) {
                        System.out.print(j + ", ");
                    }
                }
                System.out.println( );
            }

        }
    }

    @Test
    public void test3KCores() {
        // Create a graph given in the above diagram
        int k = 3;
        Graph g1 = new Graph(9);
        g1.addBidirectionalEdge(0, 1);
        g1.addBidirectionalEdge(0, 2);
        g1.addBidirectionalEdge(1, 2);
        g1.addBidirectionalEdge(1, 5);
        g1.addBidirectionalEdge(2, 3);
        g1.addBidirectionalEdge(2, 4);
        g1.addBidirectionalEdge(2, 5);
        g1.addBidirectionalEdge(2, 6);
        g1.addBidirectionalEdge(3, 4);
        g1.addBidirectionalEdge(3, 6);
        g1.addBidirectionalEdge(3, 7);
        g1.addBidirectionalEdge(4, 6);
        g1.addBidirectionalEdge(4, 7);
        g1.addBidirectionalEdge(5, 6);
        g1.addBidirectionalEdge(5, 8);
        g1.addBidirectionalEdge(6, 7);
        g1.addBidirectionalEdge(6, 8);
        printKCores(g1, k);
    }

    @Test
    public void test0KCores() {
        int k=3;
        Graph g2 = new Graph(13);
        g2.addBidirectionalEdge(0, 1);
        g2.addBidirectionalEdge(0, 2);
        g2.addBidirectionalEdge(0, 3);
        g2.addBidirectionalEdge(1, 4);
        g2.addBidirectionalEdge(1, 5);
        g2.addBidirectionalEdge(1, 6);
        g2.addBidirectionalEdge(2, 7);
        g2.addBidirectionalEdge(2, 8);
        g2.addBidirectionalEdge(2, 9);
        g2.addBidirectionalEdge(3, 10);
        g2.addBidirectionalEdge(3, 11);
        g2.addBidirectionalEdge(3, 12);
        printKCores(g2, k);
    }

}
