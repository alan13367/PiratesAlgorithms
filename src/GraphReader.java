import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GraphReader {
    private static String basePath = "Graphs/";

    /**
     * A method which takes the name of the data which must be located within the "Graphs" directory.
     * @param path the name of the file to read.
     * @return a graph class holding two lists, one of all the nodes and one for all the edges.
     */
    public Graph reader(String path){
        ArrayList<Node> nodes = new ArrayList<>();
        ArrayList<Edge> edges = new ArrayList<>();
        int numNode = 0;
        int numEdge = 0;
        String temp;
        String[] splitted;

        try{
            File file = new File(basePath + path);
            Scanner reader = new Scanner(file);
            numNode = reader.nextInt();
            reader.nextLine();
            for (int i = 0; i < numNode; i++) {
                temp = reader.nextLine();
                splitted = temp.split(",");
                nodes.add(new Node(Integer.parseInt(splitted[0]), splitted[1], splitted[2].equals("INTEREST")));
            }
            sort(nodes,0,nodes.size()-1);
            numEdge = reader.nextInt();
            reader.nextLine();
            for (int i = 0; i < numEdge; i++) {
                temp = reader.nextLine();
                splitted = temp.split(",");
                edges.add(new Edge(Integer.parseInt(splitted[0]), Integer.parseInt(splitted[1]), Float.parseFloat(splitted[2])));
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }
        return new Graph(nodes, edges);

    }

    /**
     * A method which takes the nodes and checks whether its higher or lower than the comparing pivot and orders the
     * nodes based on it.
     * @param nodes array list of the nodes gotten from the file
     * @param low lowest index of nodes
     * @param high highest index of nodes
     * @return integer refering to the index of the partition
     */
    private int partition(ArrayList<Node> nodes, int low, int high) {
        Node pivot = nodes.get(high); //Pivot element
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++) {

            // =====================================================
            // Sort by Id ascending order
            // =====================================================

            //If node(j) lower than pivot swap nodes(i) and nodes(j)
            if (nodes.get(j).getId() < pivot.getId()) {
                i++;
                Node temp = nodes.get(i);
                nodes.set(i, nodes.get(j));
                nodes.set(j, temp);
            }
        }
        // swap nodes(i+1) and nodes(high) (or pivot)
        Node temp = nodes.get(i+1);
        nodes.set(i+1, nodes.get(high));
        nodes.set(high, temp);

        return i+1;
    }


    /**
     *  A method that recursively calls itself in order to sort the entire nodes arraylist.
     * @param nodes array list of the nodes gotten from the file
     * @param low lowest index of nodes
     * @param high highest index of nodes
     */
    private void sort(ArrayList<Node> nodes, int low, int high) {
        if (low < high) {

            int partindex = partition(nodes, low, high);

            sort(nodes, low, partindex-1);
            sort(nodes, partindex+1, high);
        }
    }

}
