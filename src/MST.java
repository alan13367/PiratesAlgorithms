import java.util.Arrays;

public class MST {

    public Graph mst (Graph graph,int origin){
        int size = getGraphSize(graph);

        float[][] mtx;
        mtx = new float[size][size];
        for(float[] row : mtx){
            Arrays.fill(row, 0.0f);
        }

        Graph mst = new Graph();
        mst.addNode(graph.getNodes().get(graph.getIndex(origin)));
        while (mst.getNodes().size() != size){


        }


        return mst;
    }

    private int getGraphSize(Graph graph){
        return graph.getNodes().size();
    }

}
