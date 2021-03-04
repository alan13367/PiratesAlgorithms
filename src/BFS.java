import java.util.LinkedList;

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

        int index = graph.getIndex(nodeID);
        queue.add(index);
        visited[index] = true;
        while (queue.size() != 0) {
            index = queue.poll();
            if(!graph.getNodes().get(index).getSafe()) {
                result.add(graph.getNodes().get(index).getName());
            }
            for(Node neighbour: graph.getNeighbours(index)) {
                if(!visited[graph.getIndex(neighbour.getId())]) {
                    queue.add(neighbour.getId());
                    visited[graph.getIndex(neighbour.getId())] = true;
                }
            }
        }
        return result;

    }
}
