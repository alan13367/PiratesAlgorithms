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
}
