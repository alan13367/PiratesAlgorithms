import java.util.ArrayList;

public class BTreeTraversals {

    /**
     * This method will fill an ArrayList with the elements of the tree in preorder
     * @param list Arraylist to store the info of the nodes of the tree in preorder
     * @param node the root from where the tree starts
     */
    public void preOrder(ArrayList<String> list,BTNode node){

        if(node == null){
            return;
        }

        list.add(node.getName() + " - " + node.getValue() + " doubloons");

        preOrder(list,node.getlChild());

        preOrder(list,node.getrChild());
    }

    /**
     * This method will fill an ArrayList with the elements of the tree in inorder
     * @param list Arraylist to store the info of the nodes of the tree in inorder
     * @param node the root from where the tree starts
     */
    public void inOrder(ArrayList<String> list,BTNode node){

        if(node == null){
            return;
        }

        inOrder(list,node.getlChild());

        list.add(node.getName() + " - " + node.getValue() + " doubloons");

        inOrder(list,node.getrChild());
    }


    /**
     * This method will fill an ArrayList with the elements of the tree following a postorder search
     * @param list ArrayList to store all the information of the nodes of the tree following postOrder
     * @param node the root from where the search will start
     */
    public void postOrder(ArrayList<String> list,BTNode node){

        if(node == null){
            return;
        }

        postOrder(list,node.getlChild());

        postOrder(list,node.getrChild());

        list.add(node.getName() + " - " + node.getValue() + " doubloons");
    }




}
