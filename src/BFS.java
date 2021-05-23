import java.util.LinkedList;
/**
 * bfs algorithm applied to searching a specific node.
 *
 * @version 2.0 23 May 2021
 */
public class BFS {

    /**
     * Searches through all the nodes with the BFS algorithm and displays the ones that are not safe.
     * @param graph The graph where the nodes are.
     * @param nodeID The ID of the node we are checking.
     */
    public LinkedList bfsAlgorithm(Graph graph, int nodeID) {
        boolean[] visited = new boolean[graph.getNodes().size()];
        LinkedList<String> result = new LinkedList<>();
        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(nodeID);
        visited[graph.getIndex(nodeID)] = true;
        while (queue.size() != 0) {
            nodeID = queue.poll();
            if(!graph.getNodes().get(graph.getIndex(nodeID)).getSafe()) {
                result.add(graph.getNodes().get(graph.getIndex(nodeID)).getName()); //for testing:  + graph.getNodes().get(graph.getIndex(nodeID)).getSafe()
            }
            for(Node neighbour: graph.getNeighbours(nodeID)) {
                if(!visited[graph.getIndex(neighbour.getId())]) {
                    queue.add(neighbour.getId());
                    visited[graph.getIndex(neighbour.getId())] = true;
                }
            }
        }
        return result;

    }
}
