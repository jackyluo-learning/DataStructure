package Graph;

import org.junit.Test;

import java.util.LinkedList;

abstract class Graph{
    public int vertices;
    public LinkedList<Integer>[] adjListArray; //创建一个元素是Integer的LinkedList数组

    public Graph(int v){
        this.vertices = v;
        adjListArray = new LinkedList[this.vertices];
        for (int i = 0; i<this.vertices; i++){
            adjListArray[i] = new LinkedList<>();
        }
    }

    abstract public void addEdge(int src, int dest);

    public void printGrapth() {
        for (int i = 0; i < this.vertices; i++) {
            System.out.print(i);
            for (Integer adj : this.adjListArray[i]) {
                System.out.print("->" + adj);
            }
            System.out.println('\n');
        }
    }
}

class BiGraph extends Graph{

    public BiGraph(int v){
        super(v);
    }

    public void addEdge(int src, int dest){
        this.adjListArray[src].add(dest);
        this.adjListArray[dest].add(src);
    }
}

class SiGraph extends Graph{

    public SiGraph(int v){
        super(v);
    }

    public void addEdge(int src, int dest){
        this.adjListArray[src].add(dest);
    }
}

public class Graphs {
    @Test
    public void test(){
        BiGraph graph = new BiGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.printGrapth();
    }
}
