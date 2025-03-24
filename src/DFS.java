import java.util.*;

public class DFS {
    public static boolean depthFirstSearch(Node start, String goal, Set<String> visited, List<String> path) {
        if (visited.contains(start.name)) return false;

        visited.add(start.name);
        path.add(start.name);
        System.out.println("Visito: " + start.name);

        if (start.name.equals(goal)) {
            System.out.println("Encontrado! Ruta: " + path);
            return true;
        }

        for (Edge edge : start.neighbors) {
            if (depthFirstSearch(edge.target, goal, visited, path)) {
                return true;
            }
        }

        path.remove(path.size() - 1);
        return false;
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

        depthFirstSearch(a, "E", new HashSet<>(), new ArrayList<>());
    }
}
