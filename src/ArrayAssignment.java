import java.util.ArrayList;
import java.util.Arrays;

public class ArrayAssignment {
    /**
     * Returns an array to be able to know what id each node has in the matrix
     * @param nodes array list of the nodes that must be indexed
     * @return an array of indexes of each node
     */
    public int[] newIdAssigner(ArrayList<Node> nodes) {

        //We create an array that is twice as big as the amount of nodes there are.
        int[] newIdArray = new int[nodes.size() * 2];

        //We fill it with -1, so that we can change the necessary ones later.
        Arrays.fill(newIdArray, 0);

        //We fill the new array with the corresponding node.
        for(int i = 0; i < nodes.size(); i++) {
            newIdArray[nodes.get(i).getId()] = i;
        }
        return newIdArray;
    }

}
