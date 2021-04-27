import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RTreeReader {
    private static final String basepath = "RTrees/";

    public static Rect reader(String path) throws FileNotFoundException {
        File file = new File(basepath + path);
        Scanner scanner = new Scanner(file);
        int numOfNodes = scanner.nextInt();
        scanner.nextLine();
        Rect root = new Rect();
        do{
            RLeaf curr = new RLeaf(scanner.nextLine());
            root.insert(curr);
            root.reBalance();
        }while (scanner.hasNextLine());
        return root;
    }
}
