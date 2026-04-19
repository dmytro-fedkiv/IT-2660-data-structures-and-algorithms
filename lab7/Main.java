import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
  public static void main(String[] args) {
    // 1. Define the vertices (buildings) based on the campus map
    List<String> vertices = Arrays.asList(
        "Liberal Arts",
        "Student Services",
        "Health Careers & Sciences",
        "Health Technologies Center",
        "Recreation Center",
        "Technology Learning Center",
        "Business & Technology",
        "Theatre");

    // 2. Define Edges
    List<Edge> edges = new ArrayList<>();

    edges.add(new Edge(1, 0));
    edges.add(new Edge(0, 1));

    edges.add(new Edge(1, 2));
    edges.add(new Edge(2, 1));

    edges.add(new Edge(1, 4));
    edges.add(new Edge(4, 1));

    edges.add(new Edge(1, 5));
    edges.add(new Edge(5, 1));

    edges.add(new Edge(1, 6));
    edges.add(new Edge(6, 1));

    edges.add(new Edge(0, 7));
    edges.add(new Edge(7, 0));

    edges.add(new Edge(6, 7));
    edges.add(new Edge(7, 6));

    edges.add(new Edge(2, 3));
    edges.add(new Edge(3, 2));

    edges.add(new Edge(2, 4));
    edges.add(new Edge(4, 2));

    // 3. Create the graph (name "graph") using the vertices and edges
    UnweightedGraph<String> graph = new UnweightedGraph<>(vertices, edges);

    // 4. Perform a depth-first search (name "dfs")(DFS) starting from the "Business
    // & Technology" building
    UnweightedGraph<String>.SearchTree dfs = graph.dfs(6);

    // 5. Retrieve and print the search order of the DFS traversal
    for (int i : dfs.getSearchOrder()) {
      System.out.print("[" + i + ": " + graph.getVertex(i) + "] ");
    }

    System.out.println('\n');

    // 6. Print the parent-child relationships for each vertex during the DFS
    // traversal
    for (int i = 0; i < graph.getSize(); i++) {
      int parent = dfs.getParent(i);

      if (parent == -1)
        System.out.println("[" + graph.getVertex(i) + "]");
      else
        System.out.println("[" + graph.getVertex(parent) + " -> " + graph.getVertex(i) + "]");
    }

    System.out.println();

    // 7. Call the printPath method (assuming this method exists in the
    // UnweightedGraph class)
    dfs.printPath(3);
    System.out.println();

    dfs.printPath(1);
    System.out.println();

    dfs.printPath(4);
    System.out.println('\n');

    // 8. Call printTree() to print the entire DFS tree (assuming this method exists
    // in the UnweightedGraph class)
    dfs.printTree();
  }
}