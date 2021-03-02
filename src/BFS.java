import java.util.LinkedList;

public class BFS {

    /**
     * Searches through all the nodes with the BFS algorithm and displays the ones that are not safe.
     * @param graph The graph where the nodes are.
     * @param node The ID of the node we are checking.
     */
    public LinkedList bfsAlgorithm(Graph graph, int node) {
        boolean[] visited = new boolean[graph.getNodes().size()];
        LinkedList<String> result = new LinkedList<>();
        LinkedList<Integer> queue = new LinkedList<>();

        int index = graph.getIndex(node);
        queue.add(index);
        visited[index] = true;
        while (queue.size() != 0) {
            node = queue.poll();
            if(!graph.getNodes().get(index).getSafe()) {
                result.add(graph.getNodes().get(index).getName());
            }
            for(int i = 0; i < graph.getNeighbours(node).size(); i++) {
                if(!visited[graph.getIndex(graph.getNeighbours(node).get(i).getId())]) {
                    int j = graph.getNeighbours(node).get(i).getId();
                    queue.add(j);
                    visited[j] = true;
                }
            }
        }
        return result;

    }
}
