import java.util.*;

class Node {
    String name;
    int heuristic;
    List<Edge> neighbors;

    public Node(String name, int heuristic) {
        this.name = name;
        this.heuristic = heuristic;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(Node node, int cost) {
        neighbors.add(new Edge(node, cost));
    }
}

class Edge {
    Node target;
    int cost;

    public Edge(Node target, int cost) {
        this.target = target;
        this.cost = cost;
    }
}
