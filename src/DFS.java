import java.util.*;

public class DFS {

    public static void depthFristSearch(Node start, String goal, Set<String> visited) {
        if (visited.contains(start.name)) return;

        System.out.println("Visitar: " + start.name);
        visited.add(start.name);

        if (start.name.equals(goal)){
            System.out.println("Encontrado!");
            return;
        }

        for (Edge edge: start.neighbors){
            depthFristSearch(edge.target, goal, visited);
        }
    }

    public static  void main(String[] args){

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

        depthFristSearch(a, "E", new HashSet<>());
    }


}
