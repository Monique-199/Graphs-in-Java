package graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {
    public static void dijkstra(Graph graph, Vertex startVertex) {
        Map<Vertex, Double> distances = new HashMap<>();
        Map<Vertex, Vertex> previous = new HashMap<>();
        PriorityQueue<QueueObject<Vertex>> queue = new PriorityQueue<>();

        // Initialize all distances to infinity
        for (Vertex vertex : graph.getVertices()) {
            distances.put(vertex, Double.POSITIVE_INFINITY);
        }

        // Set the distance of the start vertex to 0
        distances.put(startVertex, 0.0);
        queue.offer(new QueueObject<>(startVertex, 0.0));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll().getData();

            for (Edge edge : currentVertex.getEdges()) {
                Vertex neighbor = edge.getEnd();
                double weight = edge.getWeight();
                double distanceToNeighbor = distances.get(currentVertex) + weight;

                if (distanceToNeighbor < distances.get(neighbor)) {
                    distances.put(neighbor, distanceToNeighbor);
                    previous.put(neighbor, currentVertex);
                    queue.offer(new QueueObject<>(neighbor, distanceToNeighbor));
                }
            }
        }

        // Print the shortest distances
        for (Map.Entry<Vertex, Double> entry : distances.entrySet()) {
            System.out.println("Distance from " + startVertex.getData() + " to " + entry.getKey().getData() + ": " + entry.getValue());
        }

        // Print the shortest paths
        for (Map.Entry<Vertex, Vertex> entry : previous.entrySet()) {
            Vertex target = entry.getKey();
            System.out.print("Shortest path to " + target.getData() + ": ");
            printShortestPath(target, previous);
            System.out.println();
        }
    }

    private static void printShortestPath(Vertex target, Map<Vertex, Vertex> previous) {
        if (previous.get(target) == null) {
            System.out.print(target.getData());
        } else {
            printShortestPath(previous.get(target), previous);
            System.out.print(" -> " + target.getData());
        }
    }

    public static void main(String[] args) {
        Graph testGraph = new Graph(true, true);
        Vertex a = testGraph.addVertex("A");
        Vertex b = testGraph.addVertex("B");
        Vertex c = testGraph.addVertex("C");
        Vertex d = testGraph.addVertex("D");
        Vertex e = testGraph.addVertex("E");
        Vertex f = testGraph.addVertex("F");
        Vertex g = testGraph.addVertex("G");

        testGraph.addEdge(a, c, 1000);
        testGraph.addEdge(a, b, 3);
        testGraph.addEdge(a, d, 4);
        testGraph.addEdge(d, e, 8);
        testGraph.addEdge(e, b, -2); // Changed to negative weight
        testGraph.addEdge(e, f, 10);
        testGraph.addEdge(b, g, 9);
        testGraph.addEdge(e, g, -50); // Changed to negative weight
        // Directly use the testGraph and startVertex
        Vertex startVertex = a;
        dijkstra(testGraph, startVertex);
    }
}
       
