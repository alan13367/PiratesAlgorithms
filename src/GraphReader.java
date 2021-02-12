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
}
