import java.util.ArrayList;

public class BTreeTraversals {

    /**
     * This method will fill an ArrayList with the elements of the tree in preorder
     * @param list Arraylist to store the nodes of the tree in preorder
     * @param node the root from where the tree starts
     */
    public void preOrder(ArrayList<BTNode> list,BTNode node){

        if(node == null){
            return;
        }

        list.add(node);

        preOrder(list,node.getlChild());

        preOrder(list,node.getrChild());
    }

    /**
     * This method will fill an ArrayList with the elements of the tree in inorder
     * @param list Arraylist to store the nodes of the tree in inorder
     * @param node the root from where the tree starts
     */
    public void inOrder(ArrayList<BTNode> list,BTNode node){

        if(node == null){
            return;
        }

        inOrder(list,node.getlChild());

        list.add(node);

        inOrder(list,node.getrChild());
    }


}
