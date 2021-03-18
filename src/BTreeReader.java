import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
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
        return in;
    }
}
