import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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

        //int max = BTreeAVL.max(root);
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
        BTNode parent = null;
        boolean modifyingRoot = false;
        if(curr.getParent() == null){
            parent = new BTNode("tmp", (BigInteger.valueOf(-1)));
            parent.setrChild(curr);
            modifyingRoot = true;
        }
        else{
            parent = curr.getParent();
        }
        if(curr.getrChild() == null && curr.getlChild() == null){
            if(parent.getlChild() == curr){
                parent.setlChild(null);
            }
            else{
                parent.setrChild(null);
            }
        }
        else if(curr.getrChild() == null && curr.getlChild() != null){
            if(parent.getlChild() == curr){
                parent.setlChild(curr.getlChild());
            }
            else{
                parent.setrChild(curr.getlChild());
            }
        }
        else if(curr.getrChild() != null && curr.getlChild() == null){
            if(parent.getlChild() == curr){
                parent.setlChild(curr.getrChild());
            }
            else{
                parent.setrChild(curr.getrChild());
            }
        }
        else if(curr.getrChild() != null && curr.getlChild() != null){
            BTNode child = curr.getrChild();
            while(child.getlChild() != null){
                child = child.getlChild();
            }
            if(parent.getlChild() == curr){
                parent.setlChild(child);
            }
            else{
                parent.setrChild(child);
            }
        }
        parent = BTreeAVL.balance(parent);
        if(modifyingRoot){
            root = parent.getrChild();
            root.setParent(null);
        }
        return BTreeAVL.balance(root);
        else{
            try {
                parent.getlChild().setParent(parent);
                parent.getrChild().setParent(parent);
            }
            catch (NullPointerException ignored){}
        }
        return root;
    }

}
