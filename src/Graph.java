import java.util.ArrayList;

public class Graph {
    private ArrayList<Node> nodes;
    private int[] dict;
    private float[][] aMatrix;
    private ArrayList<Edge> edges;

    /**
     * The Graph constructor.
     * @param nodes an arraylist of all the nodes inside the graph.
     * @param dict a int array that has all the conversions from node id to index in the adjacency matrix
     */
    public Graph(ArrayList<Node> nodes, int[] dict) {
        this.nodes = nodes;
        this.dict = dict;
    }

    /**
     * The Edges list Getter
     * @return an arraylist of all the edges of the graphs ordered from less to more weight
     */
    public ArrayList<Edge> getEdges() {
        return edges;
    }



    /**
     * Getter of the nodes
     * @return returns the nodes of the graph.
     */
    public ArrayList<Node> getNodes() {
        return nodes;
    }

    /**
     * Gets the index of an id for the adjacency matrix
     * @param id the id of the consulted node
     * @return the index of the node
     */
    public int getIndex(int id){
        return dict[id];
    }

    /**
     * To set the adjacency matrix
     * @param aMatrix the matrix with all the costs
     */
    public void setaMatrix(float[][] aMatrix) {
        this.aMatrix = aMatrix;
    }

    /**
     * Getter to get the cost of an edge between two nodes
     * @param from the id of the starting node
     * @param to the id of the destination node
     * @return the cost to go between the nodes
     */
    public float getCost(int from, int to){
        return aMatrix[getIndex(from)][getIndex(to)];
    }

    /**
     * Finds all nodes connected to specified id
     * @param id the id to center the search from
     * @return an array list of all the neighbours
     */
    public ArrayList<Node> getNeighbours(int id){
        int index = getIndex(id);
        ArrayList<Node> out = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            if(aMatrix[index][i] != 0.0f){
                out.add(nodes.get(i));
            }
        }
        return out;
    }

    public void setEdges (ArrayList<Edge> edges) {
        this.edges = edges;
    }

    /**
     * The function from a starting node does a DFS for the interest points in the graph.
     * @param start integer that indicates the starting node for the search
     */
    public void dfs(int start){

        boolean visited[] = new boolean[nodes.size()];

        dfsRecursive(start, visited);

    }
    /**
     * Check if a given node exists in a graph by looking at its ID
     * @param originNodeId the id that represents the node we are looking for
     * @return a boolean to know if the node exists or not inside our graph
     */
    public boolean ifNodeExists (int originNodeId) {
        boolean found = false;
        for (int i = 0; i < nodes.size() && !found; i++) {
            if (nodes.get(i).getId() == originNodeId) {
                found = true;
            }
        }
        return found;
    }

    /**
     * This function recursively calls itself in order to check wether the current node we are exploring is an interest
     * and based on it move into their neighbours to keep exploring using Depth-First Search.
     * @param current Integer that refers to the id of the node we are currently exploring
     * @param visited Boolean array that has n positions that indicates us if we have visited or not the node
     */
    private void dfsRecursive(int current, boolean[] visited){
        int index = getIndex(current);
        visited[index] = true;
        if(nodes.get(index).getSafe()){
            System.out.println("Id: " + current + " Name: " + nodes.get(index).getName());
        }
        for(Node neighbour: getNeighbours(current)){
            if(!visited[getIndex(neighbour.getId())] && neighbour.getSafe()){
                dfsRecursive(neighbour.getId(),visited);
            }
        }
    }



}
