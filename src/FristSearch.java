import java.util.*;

public class FristSearch {

    public static void greedyBestFristSearch(Node start, String goal){
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.heuristic));
        Set<String> visited = new HashSet<>();

        queue.add(start);

        while (!queue.isEmpty()){
            Node current = queue.poll();
            System.out.println("Visitar: " + current.name);

            if (current.name.equals(goal)){
                System.out.println("Encontrado!");
                return;
            }

            visited.add(current.name);

            for (Edge edge : current.neighbors){
                if (!visited.contains(edge.target.name)){
                    queue.add(edge.target);
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

        greedyBestFristSearch(a, "E");
    }

}
