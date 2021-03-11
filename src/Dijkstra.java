import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dijkstra {
    private Graph graph;
    private float finalCost;
    private List<Node> walk;

    /**
     * Baseline constructor
     * @param graph The graph that the dijkstra algorithm will run on
     */
    public Dijkstra(Graph graph) {
        this.graph = graph;
        finalCost = Float.MAX_VALUE;
    }

    /**
     * Public method to abstract the user from having to input node objects
     * @param start id of the starting node
     * @param end id of ending node
     * @return the set of jumps which will occur between start and end
     * @throws IndexOutOfBoundsException this will be thrown when the start and end are not connected
     */
    public List<Node> findShortestPath(int start, int end) throws IndexOutOfBoundsException{
        Node n1 = graph.getNodes().get(graph.getIndex(start));
        Node n2 = graph.getNodes().get(graph.getIndex(end));
        return dij(n1,n2);
    }

    /**
     * Actual implementation of the shortest path algorithm
     * @param start node where the algorithm is meant to start from
     * @param end node where the algortihm is meant to stop
     * @return the set of jumps which will occur between the start node and end node
     * @throws IndexOutOfBoundsException thiss will be thrown when the start and end are not connected
     */
    private List<Node> dij(Node start, Node end) throws IndexOutOfBoundsException{
        int count = 0;
        finalCost = Float.MAX_VALUE;
        walk = new ArrayList<>();
        float[] d = new float[graph.getNodes().size()];
        Arrays.fill(d, Float.MAX_VALUE);
        boolean[] visited = new boolean[graph.getNodes().size()];
        Arrays.fill(visited, false);

        d[graph.getIndex(start.getId())] = 0;
        Node curr = start;
        //walk.add(start);
        while(!allVisited(visited) && !visited[graph.getIndex(end.getId())]){
            for(Node adj : graph.getNeighbours(curr.getId())){
                if(!visited[graph.getIndex(adj.getId())]){
                    float cost = d[graph.getIndex(curr.getId())] + graph.getCost(curr.getId(), adj.getId());

                    if(d[graph.getIndex(adj.getId())] > cost){
                        d[graph.getIndex(adj.getId())] = cost;
                    }

                }
            }
            walk.add(curr);
            count++;
            visited[graph.getIndex(curr.getId())] = true;
            if(!allVisited(visited)){
                curr = findMin(d, visited);
            }
        }
        finalCost = d[graph.getIndex(walk.get(walk.size() - 1).getId())];
        return walk;
    }

    /**
     * Checks that all the booleans in the array are true
     * @param in a boolean array
     * @return false when there is a single false in the array, true otherwise
     */
    private boolean allVisited(boolean[] in){
        for(boolean bool : in){
            if(!bool){
                return false;
            }
        }
        return true;
    }

    /**
     * Finds the minimum cost node that hasn't been visited prioritizing non dangerous ones
     * @param in array of costs to each node in the graph
     * @param vis boolean array which contains the info to which nodes have been visited or not
     * @return the node with the minimum cost which complies to the requirements previously stated
     * @throws IndexOutOfBoundsException if it cant find a connected node with a cost
     */
    private Node findMin(float[] in, boolean[] vis) throws IndexOutOfBoundsException{
        float min = Float.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < in.length; i++){
            if(min > in[i] && !vis[i] && graph.getNodes().get(i).getSafe()){
                min = in[i];
                index = i;
            }
        }
        if(index == -1){
            for (int i = 0; i < in.length; i++){
                if(min > in[i] && !vis[i]){
                    min = in[i];
                    index = i;
                }
            }
        }
        return graph.getNodes().get(index);
    }

    /**
     * Gets the cost of the last set of jumps from the start node to the end (if it was reachable)
     * @return the cost from start to end
     */
    public float getFinalCost() {
        return finalCost;
    }

    /**
     * Gets the last known walk, should be used when start and end were not connected to get the shortest path before it crashed
     * @return a set of jumps
     */
    public List<Node> getWalk() {
        return walk;
    }
}
