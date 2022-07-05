package Graph;

import org.junit.Test;

import java.util.LinkedList;

public class GraphTraverse {
    public LinkedList BFS(Graph graph, int start){
        LinkedList<Integer> resultList =  new LinkedList<>();
        boolean[] visited = new boolean[graph.vertices];
        visited[start] = true;
        LinkedList<Integer> waitqueue = new LinkedList<>();
        waitqueue.add(start);
        while(!waitqueue.isEmpty()){
            start = waitqueue.remove();
            resultList.add(start);
            for(Integer adj:graph.adjListArray[start]){
                if(!visited[adj]){
                    waitqueue.add(adj);
                    visited[adj] = true;
                }
            }
        }
        return resultList;
    }

    public LinkedList DFS(Graph graph, int start){
        boolean[] visited = new boolean[graph.vertices];
        LinkedList<Integer> result = new LinkedList<>();
        return DFSImpl(graph, start, visited, result);
    }

    public LinkedList DFSImpl(Graph g, int start, boolean[] visited, LinkedList<Integer> result){
        visited[start] = true;
        result.add(start);
        for (Integer adj:g.adjListArray[start]){
            if(!visited[adj]){
                result = DFSImpl(g, adj, visited, result);
            }
        }
        return result;
    }

    @Test
    public void test(){
        Graph siGraph = new SiGraph(4);

        siGraph.addEdge(0, 1);
        siGraph.addEdge(0, 2);
        siGraph.addEdge(1, 2);
        siGraph.addEdge(2, 0);
        siGraph.addEdge(2, 3);
        siGraph.addEdge(3, 3);
        siGraph.printGraph();
        System.out.println("Breath First Search: "+BFS(siGraph, 0));
        System.out.println("Depth First Search: "+DFS(siGraph, 0));

    }
}
