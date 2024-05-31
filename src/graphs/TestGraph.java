package graphs;

public class TestGraph {
    private Graph testGraph;

    public TestGraph() {
        this.testGraph = new Graph(false, true);
        Vertex startNode = this.testGraph.addVertex("v0.0.0");
        Vertex v1 = this.testGraph.addVertex("v1.0.0");
        Vertex v2 = this.testGraph.addVertex("v2.0.0");

        Vertex v11 = this.testGraph.addVertex("v1.1.0");
        Vertex v21 = this.testGraph.addVertex("v1.2.0");
        Vertex v31 = this.testGraph.addVertex("v1.3.0"); // Added v31 back
        Vertex v111 = this.testGraph.addVertex("v1.1.1");
        Vertex v112 = this.testGraph.addVertex("v1.1.2");
        Vertex v121 = this.testGraph.addVertex("v1.2.1");
        Vertex v211 = this.testGraph.addVertex("v2.1.1");

        // Since the graph is not weighted, the weights can be ignored (i.e., set to 0)
        this.testGraph.addEdge(startNode, v1, 0);
        this.testGraph.addEdge(startNode, v2, 0);
        this.testGraph.addEdge(v1, v11, 0);
        this.testGraph.addEdge(v1, v21, 0);
        this.testGraph.addEdge(v1, v31, 0); // Added back the edge to v31
        this.testGraph.addEdge(v11, v111, 0);
        this.testGraph.addEdge(v11, v112, 0);
        this.testGraph.addEdge(v21, v121, 0);
        this.testGraph.addEdge(v21, v211, 0);

        // Create a cycle
        this.testGraph.addEdge(v211, v2, 0);
    }

    public Vertex getStartingVertex() {
        if (!this.testGraph.getVertices().isEmpty()) {
            return this.testGraph.getVertices().get(0);
        }
        return null;
    }

    public Graph getGraph() {
        return this.testGraph;
    }

    public static void main(String[] args) {
        TestGraph testGraphInstance = new TestGraph();
        Graph graph = testGraphInstance.getGraph();
        Vertex startVertex = testGraphInstance.getStartingVertex();
        
        if (startVertex != null) {
            Dijkstra.dijkstra(graph, startVertex);
        } else {
            System.out.println("No starting vertex found.");
        }
    }
}
