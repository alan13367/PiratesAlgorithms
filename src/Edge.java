public class Edge {
    
    private int from;
    private int to;
    private float cost;

    /**
     * The Edge class constructor.
     * @param from the node from where the edge begins.
     * @param to the node where the edge ends.
     * @param cost the cost of the using the edge.
     */
    public Edge(int from, int to, float cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    /**
     * Getter for the started node
     * @return the id of the starting node
     */
    public int getFrom() {
        return from;
    }

    /**
     * Getter for the destination node
     * @return the id of the destination node
     */
    public int getTo() {
        return to;
    }

    /**
     * Getter for the cost of the edge
     * @return the float of the cost of the edge
     */
    public float getCost() {
        return cost;
    }
}
