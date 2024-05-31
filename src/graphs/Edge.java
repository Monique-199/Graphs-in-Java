package graphs;

public class Edge {
    private Vertex start;
    private Vertex end;
    private double weight;

    public Edge(Vertex startV, Vertex endV, double inputWeight) {
        this.start = startV;
        this.end = endV;
        this.weight = inputWeight;
    }

    public Vertex getStart() {
        return this.start;
    }

    public void setStart(Vertex start) {
        this.start = start;
    }

    public Vertex getEnd() {
        return this.end;
    }

    public void setEnd(Vertex end) {
        this.end = end;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
