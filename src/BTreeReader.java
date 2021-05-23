import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * Binary Tree parser from the .paed to our desired format.
 *
 * @version 2.0 23 May 2021
 */
public class BTreeReader {
    private static String basepath = "Trees/";

    /**
     * Static method to read a requested file
     * @param path the name of the file within the Trees folder
     * @return a node which is the root of the tree
     * @throws FileNotFoundException when the provided name doesn't exist within the "trees" folder
     */
    public static BTNode reader(String path) throws FileNotFoundException {

        File file = new File(basepath + path);
        Scanner scanner = new Scanner(file);
        int numOfNodes = scanner.nextInt();
        scanner.nextLine();
        BTNode root = build(scanner.nextLine());
        do{
            BTNode curr = build(scanner.nextLine());
            root = add(root, curr);
        }while (scanner.hasNextLine());

        int max = BTreeAVL.max(root);

        return root;
    }

    /**
     * Method which extracts the process of splitting the data provided
     * @param input the string of information which must be split
     * @return the node with the name and value filled in
     */
    private static BTNode build(String input){
        String[] split = input.split(",");
        return new BTNode(split[0], new BigInteger(split[1]));
    }

    /**
     * Method to insert a child where it belongs to
     * @param in the parent node
     * @param add the child node to be inserted
     * @return the parent node with the child attached
     */
    public static BTNode add(BTNode in, BTNode add){
        if(add.getValue().compareTo(in.getValue()) >= 0){
            if(in.getrChild() == null){
                add.setParent(in);
                in.setrChild(add);
            }
            else{
                in.setrChild(add(in.getrChild(), add));
            }
        }
        else{
            if(in.getlChild() == null){
                add.setParent(in);
                in.setlChild(add);
            }
            else{
                in.setlChild(add(in.getlChild(),add));
            }
        }
        return BTreeAVL.balance(in);
    }

    /**
     * Method to delete a particular node from the binary tree
     * @param root the root node of the tree
     * @param name the name of the node to be deleted
     * @return the new root of the tree. Will be the same if it wasn't deleted.
     */
    public static BTNode delete(BTNode root, String name){
        Queue<BTNode> check = new LinkedList<>();
        check.add(root);
        BTNode curr = root;
        while(curr.getName().compareTo(name) != 0){
            if(curr.getlChild() != null){
                check.add(curr.getlChild());
            }
            if(curr.getrChild() != null){
                check.add(curr.getrChild());
            }
            if(check.isEmpty()){
                return null;
            }
            curr = check.poll();
        }
        if(curr == root){
            root = del(root, curr.getValue());
        }
        else {
            curr = del(root, curr.getValue());
        }
        return root;
    }

    /**
     * Recursive function which gets called until it finds the right node to delete specified by the code
     * @param node the node that must be looked at
     * @param key the value of the node you want to delete
     * @return the new balanced node
     */
    private static BTNode del(BTNode node, BigInteger key){
        if(node == null){
            return null;
        }
        else if(node.getValue().compareTo(key) > 0){
            //BTNode tmp = del(node.getlChild(), key);
            //tmp.setParent(node);
            //node.setlChild(tmp);
            node = del(node.getlChild(), key);
        }
        else if(node.getValue().compareTo(key) < 0){
            //BTNode tmp = del(node.getrChild(), key);
            //tmp.setParent(node);
            //node.setrChild(tmp);
            node = del(node.getrChild(), key);
        }
        else{
            if(node.getlChild() == null && node.getrChild() == null){
                BTNode parent = node.getParent();
                if(parent.getrChild() == node){
                    parent.setrChild(null);
                }
                else{
                    parent.setlChild(null);
                }
                node = parent;
            } else if(node.getlChild() == null || node.getrChild() == null){
                BTNode tmp = node.getParent();
                node = (node.getlChild() == null) ? node.getrChild() : node.getlChild();
                node.setParent(tmp);
            }
            else{
                BTNode lmc = getFurthestLeft(node.getrChild());
                BTNode tmp = node.getParent();
                BTNode parent = lmc.getParent();
                lmc.setParent(tmp);
                lmc.setlChild(node.getlChild());
                lmc.getlChild().setParent(lmc);
                if(node.getrChild() == lmc){
                    lmc.setrChild(null);
                }else {
                    if (lmc.getrChild() != null) {
                        BTNode child = lmc.getrChild();
                        parent.setlChild(child);
                        child.setParent(parent);
                    }
                    else{
                        parent.setlChild(null);
                    }
                    lmc.setrChild(node.getrChild());
                    lmc.getrChild().setParent(lmc);
                }
                if(tmp != null) {
                    if (tmp.getrChild() == node) {
                        tmp.setrChild(lmc);
                    } else {
                        tmp.setlChild(lmc);
                    }
                }
                node = lmc;
            }
        }
        return BTreeAVL.balance(node);
    }

    /**
     * Gets the node to the furthest left from the node provided
     * @param node the root node where we want to start the search
     * @return the node which has no left child
     */
    private static BTNode getFurthestLeft(BTNode node){
        if(node.getlChild() == null){
            return node;
        }
        else{
            return getFurthestLeft(node.getlChild());
        }
    }

}
