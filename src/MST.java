import java.util.ArrayList;
import java.util.List;

/**
 * Class to implement the Minimum Spanning Tree algorithm to the Graphs data structure
 * @author Alan Beltran
 * @version 2.0 8 March 2021
 */
public class MST {
    /**Integer array of fathers*/
    private int[] fathers;

    /**
     * Constructor of the MST class
     * @param fathers integer array with the number of nodes
     */
    public MST(int[] fathers){
        this.fathers = fathers;
    }

    /**
     * Function that intialises the fathers integer array
     * @param numnode integer that number of nodes in the graph
     */
    public void setFathers(int numnode) {
        for(int i=0;i<numnode;i++){
            fathers[i]=i;
        }
    }

    /**
     * Finds the representative of the set
     * that x is an element of
     * @param x integer indicating the node
     * @return integer that
     */
    private int find(int x){
        if(fathers[x]==x){
            return x;
        }
        return find(fathers[x]);
    }

    /**
     * Unites both the sets of the integers given
     * @param x first root
     * @param y second root
     */
    private void unite(int x, int y){
        int fx = find(x);
        int fy = find(y);
        fathers[fx] = fy;
    }

    /**
     * Actual implementation of the Minimum Spanning Tree
     * @param graph Graph in which you desire to get the MST from
     * @return It will return an ArrayList of the Edges the form the MST
     */
    public ArrayList<Edge> mst (Graph graph){

        ArrayList<Edge> result = new ArrayList<>();
        ArrayList<Edge> edges = graph.getEdges();


        int nodesnum = graph.getNodes().size();
        setFathers(nodesnum);

        while(!edges.isEmpty() && !isMST(result,nodesnum)){
            Edge edge = edges.get(0);
            edges.remove(edge);

            if(find(graph.getIndex(edge.getFrom())) != find(graph.getIndex(edge.getTo()))){
                unite(graph.getIndex(edge.getFrom()),graph.getIndex(edge.getTo()));
                result.add(edge);
            }
        }

        return result;
    }

    /**
     * Function that will check if the given list of edges is alredy an MST
     * @param edges list of the edges that are forming the MST
     * @param nodesnum number of nodes that the graph contain
     * @return either if its true of false based on the condition
     */
    private boolean isMST (ArrayList<Edge> edges, int nodesnum){
        if(edges.size() == nodesnum-1){
            return true;
        }
        return false;
    }

}
