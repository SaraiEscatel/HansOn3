import java.util.*;

public class FristSearch {
    public static void greedyBestFirstSearch(Node start, String goal) {
        PriorityQueue<NodeWrapper> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.node.heuristic));
        Set<String> visited = new HashSet<>();

        queue.add(new NodeWrapper(start, 0, new ArrayList<>()));

        while (!queue.isEmpty()) {
            NodeWrapper current = queue.poll();
            System.out.println("Visito: " + current.node.name);

            if (current.node.name.equals(goal)) {
                System.out.println("Encontrado! Ruta: " + current.path);
                return;
            }

            visited.add(current.node.name);

            for (Edge edge : current.node.neighbors) {
                if (!visited.contains(edge.target.name)) {
                    queue.add(new NodeWrapper(edge.target, 0, current.path));
                }
            }
        }
    }

    public static void main(String[] args) {
        Node a = new Node("A", 3);
        Node b = new Node("B", 2);
        Node c = new Node("C", 1);
        Node d = new Node("D", 4);
        Node e = new Node("E", 0);
        Node f = new Node("F", 2);

        a.addNeighbor(b, 1);
        b.addNeighbor(c, 1);
        b.addNeighbor(f, 1);
        f.addNeighbor(d, 1);
        d.addNeighbor(e, 1);
        c.addNeighbor(e, 1);

        greedyBestFirstSearch(a, "E");
    }
}
