import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RTreeReader {
    private static final String basepath = "RTrees/";

    private static int maxnum;

    /**
     * static method to read file at provided path and output a root node
     * @param path the name of the file within "RTrees/" directory
     * @return a Rect class which represents the the whole graph
     * @throws FileNotFoundException if the file is not found
     */
    public static Rect reader(String path) throws FileNotFoundException {
        File file = new File(basepath + path);
        Scanner scanner = new Scanner(file);
        maxnum = scanner.nextInt();
        scanner.nextLine();
        Rect root = new Rect();
        do{
            RLeaf curr = new RLeaf(scanner.nextLine());
            root.insert(curr);
            root.reBalance();
        }while (scanner.hasNextLine());
        return root;
    }

    public static double getScaleFactor(){
        if(maxnum < 64){
            return 100;
        }
        else if(maxnum<1000){
            return 10;
        }

        return 0.3;
    }
}
