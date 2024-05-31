package graphs;

import java.util.ArrayList;

public class Vertex implements Comparable<Vertex> {
    private String data;
    private ArrayList<Edge> edges;

    public Vertex(String inputData) {
        this.data = inputData;
        this.edges = new ArrayList<Edge>();
    }

    public void addEdge(Vertex endVertex, double weight) {
        this.edges.add(new Edge(this, endVertex, weight));
    }

    public void removeEdge(Vertex endVertex) {
        this.edges.removeIf(edge -> edge.getEnd().equals(endVertex));
    }

    public String getData() {
        return this.data;
    }

    public ArrayList<Edge> getEdges() {
        return this.edges;
    }

    public void print(boolean showWeight) {
        String message = this.data + " --> ";
        for (Edge edge : edges) {
            message += edge.getEnd().getData();
            if (showWeight) {
                message += "(" + edge.getWeight() + ")";
            }
            message += ", ";
        }
        // Remove the trailing comma and space
        if (message.endsWith(", ")) {
            message = message.substring(0, message.length() - 2);
        }
        System.out.println(message);
    }

    @Override
    public int compareTo(Vertex other) {
        return this.data.compareTo(other.data);
    }
}
