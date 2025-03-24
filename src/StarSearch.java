import java.util.*;

public class StarSearch {
    static class NodeWrapper {
        Node node;
        int cost;
        List<String> path; // Guardar el camino recorrido

        public NodeWrapper(Node node, int cost, List<String> path) {
            this.node = node;
            this.cost = cost;
            this.path = new ArrayList<>(path);
            this.path.add(node.name);
        }
    }

    public static void StarSearch(Node start, String goal) {
        PriorityQueue<NodeWrapper> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost + n.node.heuristic));
        Map<String, Integer> gCost = new HashMap<>();
        gCost.put(start.name, 0);

        queue.add(new NodeWrapper(start, 0, new ArrayList<>()));

        while (!queue.isEmpty()) {
            NodeWrapper current = queue.poll();
            System.out.println("Visito: " + current.node.name);

            if (current.node.name.equals(goal)) {
                System.out.println("Encontrado! Ruta: " + current.path);
                return;
            }

            for (Edge edge : current.node.neighbors) {
                int newCost = gCost.get(current.node.name) + edge.cost;
                if (!gCost.containsKey(edge.target.name) || newCost < gCost.get(edge.target.name)) {
                    gCost.put(edge.target.name, newCost);
                    queue.add(new NodeWrapper(edge.target, newCost, current.path));
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
        f.addNeighbor(d, 2);
        d.addNeighbor(e, 1);
        c.addNeighbor(e, 1);

        StarSearch(a, "E");
    }
}
