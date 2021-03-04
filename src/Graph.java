import java.util.ArrayList;

public class Graph {
    private ArrayList<Node> nodes;
    private int[] dict;
    private float[][] aMatrix;

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
}
