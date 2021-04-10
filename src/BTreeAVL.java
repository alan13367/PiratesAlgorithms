import java.util.ArrayList;
import java.util.LinkedList;

public class BTreeAVL {
    /**
     * Balances the current node
     * @param node the node to be balanced
     * @return the balanced node
     */
    public static BTNode balance(BTNode node){
        //left rotation if number is positive
        //right rotation if negative
        node.calcCosts();
        if(node.getBf() > 1){
            if(hCalc(node.getrChild().getrChild()) > hCalc(node.getrChild().getlChild())){
                node = leftRotation(node);
            }
            else{
                node.setrChild(rightRotation(node.getrChild()));
                node = leftRotation(node);
            }
        }
        else if(node.getBf() < -1){
            if(hCalc(node.getlChild().getlChild()) > hCalc(node.getlChild().getrChild())){
                node = rightRotation(node);
            }
            else {
                node.setlChild(leftRotation(node.getlChild()));
                node = rightRotation(node);
            }
        }
        node.calcCosts();
        return node;
    }

    /**
     * Returns the height to of the node in the case its null it returns a -1
     * @param node the node to check the height of
     * @return the height of the node
     */
    private static int hCalc(BTNode node){
        try {
            return node.getHeight();
        }
        catch (NullPointerException e){
            return -1;
        }
    }

    /**
     * Finds the largest absolute balance factor (Used for testing)
     * @param root the start of the tree you want to find the absolute max of
     * @return the absolute max
     */
    public static int max(BTNode root){
        int max = 0;
        ArrayList<BTNode> list = new ArrayList<>();
        root.calcCosts();
        putInList(list, root);
        for (BTNode node : list){
            if(Math.abs(node.getBf()) > Math.abs(max)){
                max = node.getBf();
            }
        }
        return max;
    }

    /**
     * Gets the tree from the specified node and works layer by layer putting all nodes
     * @param list the list containing all the nodes
     * @param node the root node
     */
    private static void putInList(ArrayList<BTNode> list, BTNode node){
        LinkedList<BTNode> queue = new LinkedList<>();
        BTNode current;
        queue.add(node);

        while(queue.size() != 0){
            current = queue.poll();
            list.add(current);

            if(current.getlChild() != null){
                queue.add(current.getlChild());
            }
            if(current.getrChild() != null){
                queue.add(current.getrChild());
            }
        }
    }

    /**
     * Rotates the specified node to the right
     * @param curr node to be rotated
     * @return the node rotated
     */
    private static BTNode rightRotation(BTNode curr){
        BTNode child = curr.getlChild();
        BTNode parent = curr.getParent();
        curr.setlChild(child.getrChild());
        if(curr.getlChild() != null) {
            curr.getlChild().setParent(curr);
        }
        child.setrChild(curr);
        curr.setParent(child);
        if(parent == null){
            child.setParent(null);
        }
        else{
            child.setParent(parent);
            if(parent.getrChild() == curr){
                parent.setrChild(child);
            }
            else{
                parent.setlChild(child);
            }
        }
        return child;
    }

    /**
     * Rotates the specified node to the left
     * @param curr node to be rotated
     * @return the node rotated
     */
    private static BTNode leftRotation(BTNode curr){
        BTNode child = curr.getrChild();
        BTNode parent = curr.getParent();
        curr.setrChild(child.getlChild());
        if(curr.getrChild() != null) {
            curr.getrChild().setParent(curr);
        }
        child.setlChild(curr);
        curr.setParent(child);
        if(parent == null){
            child.setParent(null);
        }
        else{
            child.setParent(parent);
            if(parent.getrChild() == curr){
                parent.setrChild(child);
            }
            else{
                parent.setlChild(child);
            }
        }
        return child;
    }

}
