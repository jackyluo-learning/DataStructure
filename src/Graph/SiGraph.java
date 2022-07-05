package Graph;

public class SiGraph extends Graph {

    public SiGraph(int v) {
        super(v);
    }

    public void addEdge(int src, int dest) {
        this.adjListArray[src].add(dest);
    }
}
