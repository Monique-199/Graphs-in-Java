package graphs;

import java.util.ArrayList;
import graphs.Vertex;

public class GraphTraverser {

    public static void depthFirstTraversal(Vertex start, ArrayList<Vertex> visitedVertices) {
        System.out.println(start.getData());

        for (Edge e : start.getEdges()) {
            Vertex neighbor = e.getEnd();
            if (!visitedVertices.contains(neighbor)) {
                visitedVertices.add(neighbor); // Mark the neighbor as visited before recursing
                depthFirstTraversal(neighbor, visitedVertices);
            }
        }

        // Mark the current vertex as visited after exploring its neighbors
        visitedVertices.add(start);
    }

    // Breadth First Search Algorithm
    public static void breadthFirstTraversal(Vertex start) {
        Queue<Vertex> visitQueue = new Queue<>();
        ArrayList<Vertex> visitedVertices = new ArrayList<>(); // Create a new list for BFS

        visitQueue.enqueue(start);
        visitedVertices.add(start); // Mark the starting vertex as visited

        while (!visitQueue.isEmpty()) {
            Vertex current = visitQueue.dequeue();
            System.out.println(current.getData());

            for (Edge e : current.getEdges()) {
                Vertex neighbor = e.getEnd();
                if (!visitedVertices.contains(neighbor)) {
                    visitedVertices.add(neighbor);
                    visitQueue.enqueue(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        TestGraph testgraph = new TestGraph();
        Vertex startingVertex = testgraph.getStartingVertex();

        if (startingVertex != null) {
            ArrayList<Vertex> visitedVerticesDFS = new ArrayList<>();

            System.out.println("DFS");
            depthFirstTraversal(startingVertex, visitedVerticesDFS);

            System.out.println("BFS");
            breadthFirstTraversal(startingVertex);
        } else {
            System.out.println("No starting vertex found.");
        }
    }
}