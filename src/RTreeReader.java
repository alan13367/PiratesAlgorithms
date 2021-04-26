import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RTreeReader {
    private static final String basepath = "RTrees/";

    public static void reader(String path) throws FileNotFoundException {
        File file = new File(basepath + path);
        Scanner scanner = new Scanner(file);
        int numOfNodes = scanner.nextInt();
        scanner.nextLine();
        //BTNode root = build(scanner.nextLine());
        do{
            //BTNode curr = build(scanner.nextLine());
            //root = add(root, curr);
        }while (scanner.hasNextLine());
    }
}
