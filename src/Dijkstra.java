import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Dijkstra {
    private Graph graph;

    public Dijkstra(Graph graph) {
        this.graph = graph;
    }

    public List<Node> findShortestPath(int start, int end){
        Node n1 = graph.getNodes().get(graph.getIndex(start));
        Node n2 = graph.getNodes().get(graph.getIndex(end));
        return dij(n1,n2);
    }

    private List<Node> dij(Node start, Node end){
        List<Node> walk = new LinkedList<>();
        List<float[]> costs = new ArrayList<>();
        float[] d = new float[graph.getNodes().size()];
        Arrays.fill(d, Float.MAX_VALUE);
        boolean[] visited = new boolean[graph.getNodes().size()];
        Arrays.fill(visited, false);

        d[graph.getIndex(start.getId())] = 0;
        //dunno if i need to do this
        //visited[graph.getIndex(start.getId())] = true;
        Node curr = start;
        while(!allVisited(visited) && !visited[graph.getIndex(end.getId())]){
            for(Node adj : graph.getNeighbours(curr.getId())){
                if(!visited[graph.getIndex(adj.getId())]){
                    float cost = d[graph.getIndex(curr.getId())] + graph.getCost(curr.getId(), adj.getId());

                    if(d[graph.getIndex(adj.getId())] > cost){
                        d[graph.getIndex(adj.getId())] = cost;
                        //walk.add(graph.getIndex(adj.getId()), curr);
                        costs.add(d);
                    }

                }
            }
            visited[graph.getIndex(curr.getId())] = true;
            curr = findMin(d, visited);

        }
        for (int i = 0; i < visited.length; i++){
            if(visited[i]){
                walk.add(graph.getNodes().get(i));
            }
        }
        return walk;
    }

    private boolean allVisited(boolean[] in){
        for(boolean bool : in){
            if(!bool){
                return false;
            }
        }
        return true;
    }

    private Node findMin(float[] in, boolean[] vis){
        float min = Float.MAX_VALUE;
        int index = 0;

        for (int i = 0; i < in.length; i++){
            if(min > in[i] && !vis[i]){
                min = in[i];
                index = i;
            }
        }
        return graph.getNodes().get(index);
    }
}
