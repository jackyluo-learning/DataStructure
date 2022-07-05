package Graph;

public class BiGraph extends Graph {

    public BiGraph(int v) {
        super(v);
    }

    public void addEdge(int src, int dest) {
        this.adjListArray[src].add(dest);
        this.adjListArray[dest].add(src);
    }
}
