package graph;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

//https://www.geeksforgeeks.org/delete-edge-minimize-subtree-sum-difference/
public class DeleteEdgeMinSubtreeDiff extends TestCase {

    class GraphNode {
        int name;
        int weight;

        public GraphNode(int name, int weight) {
            this.name = name;
            this.weight = weight;
        }
    }

    List<GraphNode>[] adj;
    int SIZE;

    public void addEdge(GraphNode node1, GraphNode node2) {
        adj[node1.name].add(node2);
    }

    private void dfs(int src, int parent, int totalSum, List<GraphNode>[] graph,
            int[] subTreeSum, int[] res) {
        int sum = subTreeSum[src];

        for (GraphNode child : graph[src]) {
            if (child.name != parent) {
                dfs(child.name, src, totalSum, graph, subTreeSum, res);
                sum += subTreeSum[child.name];
            }
        }

        subTreeSum[src] = sum;
        if (src != 0 && Math.abs(totalSum - 2 * sum) < res[0]) {
            res[0] = Math.abs(totalSum - 2 * sum);
        }
    }

    private int getMinSubtreeDiff(List<GraphNode>[] adj) {
        int[] subTreeSum = new int[SIZE];
        int totalSum = 0;

        for (int i = 0; i < SIZE; i++) {
            subTreeSum[i] = adj[i].get(0).weight;
            totalSum += subTreeSum[i];
        }

        int[] res = new int[1];
        res[0] = Integer.MAX_VALUE;
        dfs(0, -1, totalSum, adj, subTreeSum, res);
        return res[0];
    }

    private int getMinSubtreeDiff(int vertex[], int edges[][]) {
        SIZE = vertex.length;
        adj = new List[SIZE];
        for (int i = 0; i < SIZE; i++) {
            adj[i] = new ArrayList<>();
            GraphNode node = new GraphNode(i, vertex[i]);
            addEdge(node, node);
        }

        for (int i = 0; i < SIZE; i++) {

        }
    }

}
