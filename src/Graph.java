import java.util.ArrayList;

public class Graph {
    private ArrayList<Node> nodes;
    private ArrayList<Edge> edges;

    /**
     * The Graph constructor.
     * @param nodes an arraylist of all the nodes inside the graph.
     * @param edges an arraylist of all the edges inside the graph.
     */
    public Graph(ArrayList<Node> nodes, ArrayList<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }
}
