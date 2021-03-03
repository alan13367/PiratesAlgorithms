public class DfsAlgorithm {
    /**
     * The function from a starting node does a DFS for the interest points in the graph.
     * @param start integer that indicates the starting node for the search
     * @param graph the graph we want to explore
     */
    public void dfs(int start, Graph graph){

        boolean visited[] = new boolean[graph.getNodes().size()];

        dfsRecursive(start, visited, graph);

    }
    /**
     * This function recursively calls itself in order to check wether the current node we are exploring is an interest
     * and based on it move into their neighbours to keep exploring using Depth-First Search.
     * @param current Integer that refers to the id of the node we are currently exploring
     * @param visited Boolean array that has n positions that indicates us if we have visited or not the node
     * @param graph the graph we want to explore
     */
    private void dfsRecursive(int current, boolean[] visited,Graph graph){
        int index = graph.getIndex(current);
        visited[index] = true;
        if(graph.getNodes().get(index).getSafe()){
            System.out.println("Id: " + current + " Name: " + graph.getNodes().get(index).getName());
        }
        for(Node neighbour: graph.getNeighbours(current)){
            if(!visited[graph.getIndex(neighbour.getId())] && neighbour.getSafe()){
                dfsRecursive(neighbour.getId(),visited,graph);
            }
        }
    }

}
