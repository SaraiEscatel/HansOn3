import java.util.*;

public class BFS {
    public static void breadthFirstSearch(Node start, String goal) {
        Queue<NodeWrapper> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(new NodeWrapper(start, 0, new ArrayList<>()));
        visited.add(start.name);

        while (!queue.isEmpty()) {
            NodeWrapper current = queue.poll();
            System.out.println("Visito: " + current.node.name);

            if (current.node.name.equals(goal)) {
                System.out.println("Encontrado! Ruta: " + current.path);
                return;
            }

            for (Edge edge : current.node.neighbors) {
                if (!visited.contains(edge.target.name)) {
                    visited.add(edge.target.name);
                    queue.add(new NodeWrapper(edge.target, 0, current.path));
                }
            }
        }
    }

    public static void main(String[] args) {
        Node a = new Node("A", 0);
        Node b = new Node("B", 0);
        Node c = new Node("C", 0);
        Node d = new Node("D", 0);
        Node e = new Node("E", 0);
        Node f = new Node("F", 0);

        a.addNeighbor(b, 1);
        b.addNeighbor(c, 1);
        b.addNeighbor(f, 1);
        f.addNeighbor(d, 1);
        d.addNeighbor(e, 1);
        c.addNeighbor(e, 1);

        breadthFirstSearch(a, "E");
    }
}
