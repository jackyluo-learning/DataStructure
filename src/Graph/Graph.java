package Graph;

import java.util.LinkedList;

abstract public class Graph{
    protected int vertices;
    protected LinkedList<Integer>[] adjListArray; //创建一个元素是Integer的LinkedList数组

    public Graph(int v){
        this.vertices = v;
        adjListArray = new LinkedList[this.vertices];
        for (int i = 0; i<this.vertices; i++){
            adjListArray[i] = new LinkedList<>();
        }
    }

    abstract public void addEdge(int src, int dest);

    public void printGraph() {
        for (int i = 0; i < this.vertices; i++) {
            System.out.print(i);
            for (Integer adj : this.adjListArray[i]) {
                System.out.print("->" + adj);
            }
            System.out.println('\n');
        }
    }
}

