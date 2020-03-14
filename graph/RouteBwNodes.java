package graph;

import java.util.LinkedList;

public class RouteBwNodes {

    public static boolean doesRouteExist(Graph graph, Node one, Node two) {
        if (one == two) {
            return true;
        }

        for (Node node : graph.getNodes()) {
            node.setVisited(false);
        }

        LinkedList<Node> queue = new LinkedList();
        one.setVisited(true);
        queue.add(one);

        Node current;
        while (!queue.isEmpty()) {
            current = queue.poll();

            for (Node child : current.getChildren()) {
                if (!child.isVisited()) {
                    if (child == two) {
                        return true;
                    }
                    child.setVisited(true);
                    queue.add(child);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        graph.addNode(node0);
        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);
        graph.addNode(node4);
        graph.addNode(node5);
        graph.addNode(node6);

        graph.addEdge(node0, node1);
        graph.addEdge(node0, node4);
        graph.addEdge(node0, node5);

        graph.addEdge(node1, node3);
        graph.addEdge(node1, node4);

        graph.addEdge(node2, node1);

        graph.addEdge(node3, node2);
        graph.addEdge(node3, node4);

        System.out.println(doesRouteExist(graph, node0, node3));
        System.out.println(doesRouteExist(graph, node0, node6));
    }

}
