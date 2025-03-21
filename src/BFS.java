import java.util.*;

public class BFS {

    public static void breadthFirstSearch(Node start, String goal){
        Queue<Node> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start.name);

        while (!queue.isEmpty()){
            Node current = queue.poll();
            System.out.println("Visitar: " + current.name);

            if (current.name.equals(goal)){
                System.out.println("Encondrado!");
                return;
            }

            for (Edge edge : current.neighbors){
                if (!visited.contains(edge.target.name)){
                    queue.add(edge.target);
                    visited.add(edge.target.name);
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
