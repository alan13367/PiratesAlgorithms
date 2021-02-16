import java.util.ArrayList;
import java.util.Arrays;

public class ArrayAssignment {
    /**
     * Returns an array to be able to know what id each node has in the matrix
     * @param nodes array list of the nodes that must be indexed
     * @return an array of indexes of each node
     */
    public int[] newIdAssigner(ArrayList<Node> nodes) {
        int i;
        int j = 0;
        int numId = 0;

        //We check what is the highest ID number to generate an array that depends on the highest ID number.
        for(i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getId() > numId) {
                numId = nodes.get(i).getId();
            }
        }

        int[] newIdArray = new int[numId];
        int[] tempArray = new int[numId];

        //We generate a temporary array to compare with the node ID array
        for(i = 0; i < numId; i++) {
            tempArray[i] = i;
        }

        //We compare the temporary array with the node ID array and we generate the new ID array.
        for(i = 0; i < numId; i++) {
            if(nodes.get(j).getId() == tempArray[i]) {
                newIdArray[i] = j;
                j++;
            }
            else {
                newIdArray[i] = -1;
            }
        }
        return newIdArray;
    }

}
