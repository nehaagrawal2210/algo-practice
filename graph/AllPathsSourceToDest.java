package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import junit.framework.TestCase;

public class AllPathsSourceToDest extends TestCase {

    public void testAllPath(){
        Graph graph = new Graph(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(1,3);
        graph.addEdge(2,0);
        graph.addEdge(2,1);
        List<List<Integer>> paths = getAllPaths(graph, 2,3);
        System.out.println(Arrays.toString(paths.toArray()));
    }

    public List<List<Integer>> getAllPaths(Graph graph, int src, int dest) {
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        path.add(src);
        queue.add(path);

        while (!queue.isEmpty()) {
            path = queue.poll();
            int parent = path.get(path.size() - 1);
            if (parent == dest) {
                res.add(path);
            }

            for (int child : graph.adjacencyList[parent]) {
                if (!isVisited(child, path)) {
                    List<Integer> addPath = new ArrayList<>(path);
                    addPath.add(child);
                    queue.add(addPath);
                }
            }
        }
        return res;
    }

    private boolean isVisited(int x, List<Integer> path) {
        return path.contains(x);
    }
}
