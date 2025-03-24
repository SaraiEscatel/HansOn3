import java.util.*;

class Node {
    String name;
    int heuristic;  // Para Greedy Best-First Search y A*
    List<Edge> neighbors;

    public Node(String name, int heuristic) {
        this.name = name;
        this.heuristic = heuristic;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(Node target, int cost) {
        this.neighbors.add(new Edge(target, cost));
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

class NodeWrapper {
    Node node;
    int cost;
    List<String> path;

    public NodeWrapper(Node node, int cost, List<String> path) {
        this.node = node;
        this.cost = cost;
        this.path = new ArrayList<>(path);
        this.path.add(node.name);
    }
}
