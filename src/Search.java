import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Class to implement Binary Tree Search by Exact Value and Range
 * @author  Alvaro Delgado
 * @version 2.0 23 March 2021
 */
public class Search {
    /**
     * Given the root of a binary tree it founds the element that has the same value as the one requested.
     * @param value the value that we are looking for.
     * @param btNode the root of the binary tree and the binary tree itself.
     * @return the node with the corresponding value.
     */
    public static BTNode searchByValueExact (BigInteger value, BTNode btNode) {
        //If the value of the root node is equal to the one requested...
        if (value.compareTo(btNode.getValue()) == 0) {
            //...then we return the root node.
            return btNode;
        }
        //... if it is not equal to the one requested...
        //... then while we are not in a leave node (both childs are equal to null)...
        while (btNode.getlChild() != null || btNode.getrChild() != null) {
            //...if the value of the current node is smaller than the one requested, we move to the left child...
            if (value.compareTo(btNode.getValue()) < 0) {
                //... and we set it as the current node.
                btNode = btNode.getlChild();
            } else {
                //...if the value of the current node is bigger than the one requested, we move to the right child...
                if (value.compareTo(btNode.getValue()) > 0) {
                    //... and we set it as the current node.
                    btNode = btNode.getrChild();
                }
            }
            //...if the value of the current node is equal to the one requested, then we return it as the result.
            if (value.compareTo(btNode.getValue()) == 0) {
                return btNode;
            }
        }
        return null;
    }

    /**
     * Given a range of values, we look for all the nodes that its own value is inside that range.
     * @param minimumTreasureValue the minimum value of the range (inclusive)
     * @param maximumTreasureValue the maximum value of the range (inclusive)
     * @param btNode the root node and the binary tree itself
     * @return linkedlist with all the nodes that fulfill the statement
     */
    public static LinkedList<BTNode> searchByValueRange (BigInteger minimumTreasureValue, BigInteger maximumTreasureValue, BTNode btNode) {
        LinkedList<BTNode> linkedList = new LinkedList<>(); //LinkedList to store all the nodes that accomplishes the
                                                            //function described.
        Queue<BTNode> queue = new LinkedList<>();           //Queue to know the nodes we need to visit.

        //Add the root node to the queue of nodes that we need to check.
        queue.add(btNode);
        //While the queue is not empty, meaning that there is still some nodes to check...
        while (!queue.isEmpty()) {
            //...poll a node...
            BTNode btCurrent = queue.poll();
            //...if this node is inside the range...
            if (minimumTreasureValue.compareTo(btCurrent.getValue()) <= 0
                    && maximumTreasureValue.compareTo(btCurrent.getValue()) >= 0) {
                //...add it to the linked list.
                linkedList.add(btCurrent);
                //...if it has a left child...
                if (btCurrent.getlChild() != null) {
                    //...add it to the queue in order to check it later.
                    queue.add(btCurrent.getlChild());
                }
                //...if it has a right child...
                if (btCurrent.getrChild() != null) {
                    //...add it to the queue in order to check it later.
                    queue.add(btCurrent.getrChild());
                }
            }
        }
        return linkedList;
    }

}
