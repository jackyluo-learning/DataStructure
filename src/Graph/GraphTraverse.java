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
        Graph g = new SiGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.printGrapth();
        System.out.println("Breath First Search: "+BFS(g, 2));
        System.out.println("Depth First Search: "+DFS(g, 0));
    }
}
