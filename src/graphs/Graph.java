package graphs;

import java.util.ArrayList;

public class Graph {
    private ArrayList<Vertex> vertices;
    private boolean isWeighted;
    private boolean isDirected;

    public Graph(boolean inputIsWeighted, boolean inputIsDirected) {
        this.vertices = new ArrayList<Vertex>();
        this.isWeighted = inputIsWeighted;
        this.isDirected = inputIsDirected;
    }

    public ArrayList<Vertex> getVertices() {
        return this.vertices;
    }

    public void setVertices(ArrayList<Vertex> vertices) {
        this.vertices = vertices;
    }

    public boolean isWeighted() {
        return this.isWeighted;
    }

    public void setWeighted(boolean isWeighted) {
        this.isWeighted = isWeighted;
    }

    public boolean isDirected() {
        return this.isDirected;
    }

    public void setDirected(boolean isDirected) {
        this.isDirected = isDirected;
    }

    public Vertex getVertexByValue(String value) {
        for (Vertex v : this.vertices) {
            if (v.getData().equals(value)) { // Use .equals() for string comparison
                return v;
            }
        }
        return null;
    }

    public void print() {
        for (Vertex v : this.vertices) {
            v.print(isWeighted);
        }
    }

    public Vertex addVertex(String data) {
        Vertex newVertex = new Vertex(data);
        this.vertices.add(newVertex);
        return newVertex;
    }

    public void addEdge(Vertex vertex1, Vertex vertex2, double weight) {
        if (!this.isWeighted) {
            weight = 1.0;
        }
        vertex1.addEdge(vertex2, weight);
        if (!this.isDirected) {
            vertex2.addEdge(vertex1, weight);
        }
    }

    public void removeEdge(Vertex vertex1, Vertex vertex2) {
        vertex1.removeEdge(vertex2);
        if (!this.isDirected) {
            vertex2.removeEdge(vertex1);
        }
    }

    public void removeVertex(Vertex vertex) {
        this.vertices.remove(vertex);
        for (Vertex v : this.vertices) {
            v.removeEdge(vertex);
        }
    }

    public static void main(String[] args) {
        Graph busNetwork = new Graph(true, true);
        Vertex cliftStation = busNetwork.addVertex("Clift");
        Vertex capetown = busNetwork.addVertex("CapeTown");

        busNetwork.addEdge(cliftStation, capetown, 10000);
        busNetwork.print();
    }
}
