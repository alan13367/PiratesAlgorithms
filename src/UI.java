import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.*;

/**
 * Class implementing the UI
 * @author Alvaro Delgado
 * @version 2.0 23 May 2021
 */
public class UI {
    /**
     * Graph to store the graph dataset selected.
     */
    private Graph graph;
    /**
     * Object reference to the root of the binary tree to store the dataset selected.
     */
    private BTNode btNode;
    /**
     * R-Tree to store the r-tree dataset selected
     */
    private Rect rect;
    /**
     * Table to hold the pirate info
     */
    private Table table;
    /**
     * UI starting message
     */
    public void ui () {
        //Output the starting message "-= Pirates of the Mediterranean =-".
        System.out.println("-= ☠ Pirates of the Mediterranean ☠ =-");
        this.datasetGraph();
    }

    /**
     * Choose a dataset:
     * L) graphL.paed
     * M) graphM.paed
     * S) graphS.paed
     * XL) graphXL.paed
     * XS) graphXS.paed
     * XXL) graphXXL.paed
     * XXS) graphXXS.paed
     */
    public void datasetGraph() {
        GraphReader graphReader = new GraphReader();
        Scanner scanner = new Scanner(System.in);
        String dataset;
        //Leave an empty line.
        System.out.println();
        System.out.println("L) graphL.paed");
        System.out.println("M) graphM.paed");
        System.out.println("S) graphS.paed");
        System.out.println("XL) graphXL.paed");
        System.out.println("XS) graphXS.paed");
        System.out.println("XXL) graphXXL.paed");
        System.out.println("XXS) graphXXS.paed");
        //Leave an empty line.
        System.out.println();
        //Show a message saying "Choose an option: ".
        System.out.print("Choose a dataset: ");
        try {
            //Get the dataset selected.
            dataset = scanner.nextLine();
            //If the dataset selected is...
            this.graph = graphReader.reader("graph"+ dataset.toUpperCase() +".paed");
        }
        catch (InputMismatchException e) {
            //... not a string, then we output an error message "ERROR: Input mismatch, a string is required."
            System.out.println("ERROR: Input mismatch, a string is required.");
            //... and we show the starting menu again
            this.datasetGraph();
        }
        catch (FileNotFoundException e) {
            //... not a correct file, then we output an error message "ERROR: File not found, please enter a valid dataset."
            System.out.println("ERROR: File not found, please enter a valid dataset.");
            //... and we show the starting menu again
            this.datasetGraph();
        }
        //Call the starting menu.
        this.datasetTrees();
    }

    /**
     * Choose a dataset:
     * L) treeL.paed
     * M) treeM.paed
     * S) treeS.paed
     * XL) treeXL.paed
     * XS) treeXS.paed
     * XXL) treeXXL.paed
     * XXS) treeXXS.paed
     */
    public void datasetTrees() {
        Scanner scanner = new Scanner(System.in);
        String dataset;
        //Leave an empty line.
        System.out.println();
        System.out.println("L) treeL.paed");
        System.out.println("M) treeM.paed");
        System.out.println("S) treeS.paed");
        System.out.println("XL) treeXL.paed");
        System.out.println("XS) treeXS.paed");
        System.out.println("XXL) treeXXL.paed");
        System.out.println("XXS) treeXXS.paed");
        //Leave an empty line.
        System.out.println();
        //Show a message saying "Choose an option: ".
        System.out.print("Choose a dataset: ");
        try {
            //Get the dataset selected.
            dataset = scanner.nextLine();
            //If the dataset selected is...
            this.btNode = BTreeReader.reader("tree"+ dataset.toUpperCase() +".paed");
        }
        catch (InputMismatchException e) {
            //... not a string, then we output an error message "ERROR: Input mismatch, a string is required."
            System.out.println("ERROR: Input mismatch, a string is required.");
            //... and we show the starting menu again
            this.datasetTrees();
        }
        catch (FileNotFoundException e) {
            //... not a correct file, then we output an error message "ERROR: File not found, please enter a valid dataset."
            System.out.println("ERROR: File not found, please enter a valid dataset.");
            //... and we show the starting menu again
            this.datasetTrees();
        }
        //Call the starting menu.
        this.datasetRTrees();
    }

    /**
     * Choose a dataset:
     * L) r-treeL.paed
     * M) r-treeM.paed
     * S) r-treeS.paed
     * XL) r-treeXL.paed
     * XS) r-treeXS.paed
     * XXL) r-treeXXL.paed
     * XXS) r-treeXXS.paed
     */
    public void datasetRTrees() {
        Scanner scanner = new Scanner(System.in);
        String dataset;
        //Leave an empty line.
        System.out.println();
        System.out.println("L) r-treeL.paed");
        System.out.println("M) r-treeM.paed");
        System.out.println("S) r-treeS.paed");
        System.out.println("XL) r-treeXL.paed");
        System.out.println("XS) r-treeXS.paed");
        System.out.println("XXL) r-treeXXL.paed");
        System.out.println("XXS) r-treeXXS.paed");
        //Leave an empty line.
        System.out.println();
        //Show a message saying "Choose a dataset: ".
        System.out.print("Choose a dataset: ");
        try {
            //Get the dataset selected.
            dataset = scanner.nextLine();
            //If the dataset selected is...
            this.rect =  RTreeReader.reader("r-tree" + dataset.toUpperCase() + ".paed");
        }
        catch (InputMismatchException e) {
            //... not a string, then we output an error message "ERROR: Input mismatch, a string is required."
            System.out.println("ERROR: Input mismatch, a string is required.");
            //... and we show the dataset r-tree menu again
            this.datasetRTrees();
        }
        catch (FileNotFoundException e) {
            //... not a correct file, then we output an error message "ERROR: File not found, please enter a valid dataset."
            System.out.println("ERROR: File not found, please enter a valid dataset.");
            //... and we show the dataset r-tree menu again
            this.datasetRTrees();
        }
        //Call the starting menu.
        this.datasetTables();
    }

    /**
     * Choose a dataset:
     * L) tablesL.paed
     * M) tablesM.paed
     * S) tablesS.paed
     * XL) tablesXL.paed
     * XS) tablesXS.paed
     * XXL) tablesXXL.paed
     * XXS) tablesXXS.paed
     */
    public void datasetTables() {
        Scanner scanner = new Scanner(System.in);
        String dataset;
        //Leave an empty line.
        System.out.println();
        System.out.println("L) tablesL.paed");
        System.out.println("M) tablesM.paed");
        System.out.println("S) tablesS.paed");
        System.out.println("XL) tablesXL.paed");
        System.out.println("XS) tablesXS.paed");
        System.out.println("XXL) tablesXXL.paed");
        System.out.println("XXS) tablesXXS.paed");
        //Leave an empty line.
        System.out.println();
        //Show a message saying "Choose a dataset: ".
        System.out.print("Choose a dataset: ");
        try {
            //Get the dataset selected.
            dataset = scanner.nextLine();
            //If the dataset selected is...
            table = new Table();
            table.reader("tables" + dataset.toUpperCase() + ".paed" );
        }
        catch (InputMismatchException e) {
            //... not a string, then we output an error message "ERROR: Input mismatch, a string is required."
            System.out.println("ERROR: Input mismatch, a string is required.");
            //... and we show the dataset table menu again
            this.datasetTables();
        }
        catch (FileNotFoundException e){
            System.out.println("ERROR: File not found, please enter a valid dataset.");
            this.datasetTables();
        }
        //Call the starting menu.
        this.startMenu();
    }

    /**
     * Show the starting menu, the one that the user will see once they start the program.It gives a range of options to
     * work with related to sections of the project:
     * 1. Routes (Graphs)
     * 2. Inventory (Binary trees)
     * 3. Deck (R trees)
     * 4. Crew (Tables)
     * 5. Exit
     */
    public void startMenu () {
        Scanner scanner = new Scanner(System.in);   //Scanner to get the user input through the System input.
        int option;                             //integer to store the option selected.
        //Output the starting menu selection
        //Leave an empty line.
        System.out.println();
        //Show a message saying "1. Routes (Graphs)".
        System.out.println("1. Routes (Graphs)");
        //Show a message saying "2. Inventory (Binary trees)".
        System.out.println("2. Inventory (Binary trees)");
        //Show a message saying "3. Deck (R trees)".
        System.out.println("3. Deck (R trees)");
        //Show a message saying "4. Crew (Tables)".
        System.out.println("4. Crew (Tables)");
        //Leave an empty line.
        System.out.println();
        //Show a message saying "5. Exit".
        System.out.println("5. Exit");
        //Leave an empty line.
        System.out.println();
        //Show a message saying "Choose an option: ".
        System.out.print("Choose an option: ");
        //Try to scan the user input looking for an integer...
        try {
            //Get the option selected.
            option = scanner.nextInt();
            switch (option) {
                //If the option selected is...
                case 1:
                    //... 1, then we give the user a menu to manage maritime routes.
                    this.routesMenu();
                    break;
                case 2:
                    this.inventoryMenu();
                    break;
                case 3:
                    this.deckMenu();
                    break;
                case 4:
                    this.crewMenu();
                    break;
                case 5:
                    System.out.println("So long, comrade! ⛵");
                    //... 5, then we output a farewell message and exit the program.
                    System.exit(0);
                    break;
                default:
                    //... not an integer value between 1 and 5, then we output an error message "ERROR: Option must be
                    // an integer value from 1 to 5."
                    System.out.println("ERROR: Option must be an integer value from 1 to 5.");
                    //Leave an empty line.
                    System.out.println();
                    //... and we show the starting menu again
                    this.startMenu();
                    break;
            }
        }
        //... if that is not the case, we catch the exception.
        catch (InputMismatchException e) {
            //... not an integer, then we output an error message "ERROR: Input mismatch, an integer is required."
            System.out.println("ERROR: Input mismatch, an integer is required.");
            //Leave an empty line.
            System.out.println();
            //... and we show the starting menu again
            this.startMenu();
        }
    }

    /**
     * Show a menu where the user chooses how to manage the pirates. It gives the next range of functionalities to
     * choose from:
     *  A. Add pirate
     *  B. Remove pirate
     *  C. Show pirate
     *  D. Age histogram
     *
     *  E. Go back
     *
     *What functionality do you want to run?
     *
     */
    public void crewMenu() {
        Scanner scanner = new Scanner(System.in);   //Scanner to get the user input through the System input.
        char functionality;                     //character to store the functionality selected.
        //Leave an empty line.
        System.out.println();
        //Show a message saying "    A. Add pirate".
        System.out.println("    A. Add pirate");
        //Show a message saying "    B. Remove pirate".
        System.out.println("    B. Remove pirate");
        //Show a message saying "    C. Show pirate".
        System.out.println("    C. Show pirate");
        //Show a message saying "    D. Age histogram".
        System.out.println("    D. Age histogram");
        //Leave an empty line.
        System.out.println();
        //Show a message saying "    E. Go back".
        System.out.println("    E. Go back");
        //Leave an empty line.
        System.out.println();
        //Show a message saying "What functionality do you want to run? ".
        System.out.print("What functionality do you want to run? ");
        //Try to scan the user input looking for a character...
        try {
            //Get the character selected and transform it to uppercase given a String.
            functionality = Character.toUpperCase(scanner.nextLine().charAt(0));
            //If the functionality selected is...
            //... A, then we give the user a menu to add a treasure.
            //... B, then we give the user a menu to remove a treasure.
            //... C, then we show the user a visualize the deck.
            //... D, then we give the user a list of treasures given an area.
            //... E, then we go back to the starting menu.
            //... not a character value between A and E, then we output an error message "ERROR: Functionality.
            //must be a character value (A-E)"
            //Leave an empty line.
            //... and we show the crew menu again
            switch (functionality) {
                case 'A' -> this.addPirate();
                case 'B' -> this.removePirate();
                case 'C' -> this.showPirate();
                case 'D' -> this.ageHistogram();
                case 'E' -> this.startMenu();
                default -> {
                    System.out.println("ERROR: Functionality must be a character value (A-E)");
                    System.out.println();
                    this.crewMenu();
                }
            }
            //... if that is not the case, we catch the exception.
        } catch (InputMismatchException e) {
            //... not a character, then we output an error message "ERROR: Input mismatch, a character is required."
            System.out.println("ERROR: Input mismatch, a character is required.");
            //Leave an empty line.
            System.out.println();
            //... and we show the crews menu again
            this.crewMenu();
        }
    }

    /**
     * Allows the user to add a new pirate to the table, given a pirate name, age and role.
     */
    public void addPirate(){
        Scanner scanner = new Scanner(System.in);
        String name = "";
        int age = 0;
        String role = "";
        System.out.println();
        System.out.print("Enter the pirate's name: ");
        try {
            name = scanner.nextLine();
        } catch (InputMismatchException e) {
            //... not a String, then we output an error message "ERROR: Input mismatch, a String is required."
            System.out.println("ERROR: Input mismatch, a String is required.");
            //Leave an empty line.
            System.out.println();
            //... and we show the add r-treasure menu
            this.addPirate();
        }
        System.out.print("Enter the pirate's age: ");
        try {
            age = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            //... not an integer, then we output an error message "ERROR: Input mismatch, an integer is required."
            System.out.println("ERROR: Input mismatch, an integer is required.");
            //Leave an empty line.
            System.out.println();
            //... and we show the add r-treasure menu
            this.addPirate();
        }
        System.out.print("Enter the pirate's role: ");
        try {
            role = scanner.nextLine();
        } catch (InputMismatchException e) {
            //... not a String, then we output an error message "ERROR: Input mismatch, a String is required."
            System.out.println("ERROR: Input mismatch, a String is required.");
            //Leave an empty line.
            System.out.println();
            //... and we show the add r-treasure menu
            this.addPirate();
        }

        //Pirate addition
        if(table.get(name) == null){
            Pirate pirate = new Pirate(name, age,role);
            table.insert(pirate);
            System.out.println();
            System.out.println("The pirate was correctly added to the crew.");
            this.crewMenu();
        }else{
            System.out.println("\nThe pirate alredy exists please enter another one");
            this.addPirate();
        }

    }

    /**
     * Allows the user to remove a pirate given its name,
     */
    public void removePirate(){
        Scanner scanner = new Scanner(System.in);
        String name = "";
        System.out.println();
        System.out.print("Enter the pirate's name: ");
        try {
            name = scanner.nextLine();
        } catch (InputMismatchException e) {
            //... not a String, then we output an error message "ERROR: Input mismatch, a String is required."
            System.out.println("ERROR: Input mismatch, a String is required.");
            //Leave an empty line.
            System.out.println();
            //... and we show the remove pirate menu
            this.removePirate();
        }
        //Pirate deletion
        if(table.delete(name) == 1){
            System.out.println("ERROR: Pirate does not exist");
            this.removePirate();
        }
        System.out.println();
        System.out.println("The pirate was correctly removed from the crew.");
        System.out.println();
        System.out.println("⠀⠀⠀⢀⡤⢶⣶⣶⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⢀⣠⣤⣤⣤⣿⣧⣀⣀⣀⣀⣀⣀⣀⣀⣤⡄⠀");
        System.out.println("⢠⣾⡟⠋⠁⠀⠀⣸⠇⠈⣿⣿⡟⠉⠉⠉⠙⠻⣿⡀");
        System.out.println("⢺⣿⡀⠀⠀⢀⡴⠋⠀⠀⣿⣿⡇⠀⠀⠀⠀⠀ ⠙⠇");
        System.out.println("⠈⠛⠿⠶⠚⠋⣀⣤⣤⣤⣿⣿⣇⣀⣀⣴⡆⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠠⡞⠋⠀⠀⠀⣿⣿⡏⠉⠛⠻⣿⡀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⣿⣿⡇⠀⠀⠀⠈⠁⠀⠀");
        System.out.println("⠀⠀⣠⣶⣶⣶⣶⡄⠀⠀⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⢰⣿⠟⠉⠙⢿⡟⠀⠀⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⢸⡟⠀⠀⠀⠘⠀⠀⠀⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠈⢿⡄⠀⠀⠀⠀⠀⣼⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠙⠷⠶⠶⠶⠿⠟⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        this.crewMenu();
    }

    /**
     * Shows a specific pirate given its name.
     */
    public void showPirate(){
        Scanner scanner = new Scanner(System.in);
        String name = null;
        Pirate pirate;
        System.out.println();
        System.out.print("Enter the pirate's name: ");
        try {
            name = scanner.nextLine();
        } catch (InputMismatchException e) {
            //... not a String, then we output an error message "ERROR: Input mismatch, a String is required."
            System.out.println("ERROR: Input mismatch, a String is required.");
            //Leave an empty line.
            System.out.println();
            //... and we show the show pirate menu
            this.showPirate();
        }
        //Pirate show
        pirate = table.get(name);
        if(pirate == null){
            System.out.println("\nError 404 : Pirate Not Found");
            this.crewMenu();
        }else{
            System.out.println();
            System.out.println("    Name: " + pirate.getName());
            System.out.println("    Age: " + pirate.getAge());
            System.out.println("    Role: " + pirate.getRole());
            this.crewMenu();
        }

    }

    /**
     * Generates the histogram.
     */
    public void ageHistogram(){
        System.out.println();
        System.out.print("Generating histogram... ");
        TableQueries tableQueries = new TableQueries(table.getAges());
        tableQueries.drawChart();
        System.out.println();
        this.crewMenu();
    }

    /**Show a menu where the user chooses how to manage the deck. It gives the next range of functionalities to
     * choose from:
     *  A. Add treasure
     *  B. Remove treasure
     *  C. Visualize
     *  D. Search by area
     *  E. Search by proximity
     *
     *  F. Go back
     *
     *What functionality do you want to run?
     */
    public void deckMenu() {
        Scanner scanner = new Scanner(System.in);   //Scanner to get the user input through the System input.
        char functionality;                     //character to store the functionality selected.
        //Leave an empty line.
        System.out.println();
        //Show a message saying "    A. Add treasure".
        System.out.println("    A. Add treasure");
        //Show a message saying "    B. Find dangerous places (BFS)".
        System.out.println("    B. Remove treasure");
        //Show a message saying "    C. Visualize".
        System.out.println("    C. Visualize");
        //Show a message saying "    D. Search by area".
        System.out.println("    D. Search by area");
        //Show a message saying "    E. Search by proximity".
        System.out.println("    E. Search by proximity");
        //Leave an empty line.
        System.out.println();
        //Show a message saying "    F. Go back".
        System.out.println("    F. Go back");
        //Leave an empty line.
        System.out.println();
        //Show a message saying "What functionality do you want to run? ".
        System.out.print("What functionality do you want to run? ");
        //Try to scan the user input looking for a character...
        try {
            //Get the character selected and transform it to uppercase given a String.
            functionality = Character.toUpperCase(scanner.nextLine().charAt(0));
            //If the functionality selected is...
            //... A, then we give the user a menu to add a treasure.
            //... B, then we give the user a menu to remove a treasure.
            //... C, then we show the user a visualize the deck.
            //... D, then we give the user a list of treasures given an area.
            //... E, then we give the user a list of treasures given a proximity.
            //... F, then we go back to the starting menu.
            //... not a character value between A and F, then we output an error message "ERROR: Functionality.
            //must be a character value (A-F)"
            //Leave an empty line.
            //... and we show the deck menu again
            switch (functionality) {
                case 'A' -> this.addRTreasure();
                case 'B' -> this.removeRTreasure();
                case 'C' -> this.visualize();
                case 'D' -> this.searchByArea();
                case 'E' -> this.searchByProximity();
                case 'F' -> this.startMenu();
                default -> {
                    System.out.println("ERROR: Functionality must be a character value (A-F)");
                    System.out.println();
                    this.deckMenu();
                }
            }
            //... if that is not the case, we catch the exception.
        } catch (InputMismatchException e) {
            //... not a character, then we output an error message "ERROR: Input mismatch, a character is required."
            System.out.println("ERROR: Input mismatch, a character is required.");
            //Leave an empty line.
            System.out.println();
            //... and we show the routes menu again
            this.deckMenu();
        }
    }
    /**
     * Allows the user to add a new treasure to the r-tree, given a treasure name, x-coordinate and y-coordinate.
     */
    public void addRTreasure() {
        Scanner scanner = new Scanner(System.in);
        String treasuresName = new String();
        float x = 0.0f;
        float y = 0.0f;
        System.out.println();
        System.out.println("Enter the treasure's name: ");
        try {
            treasuresName = scanner.nextLine();
        } catch (InputMismatchException e) {
            //... not a String, then we output an error message "ERROR: Input mismatch, a String is required."
            System.out.println("ERROR: Input mismatch, a String is required.");
            //Leave an empty line.
            System.out.println();
            //... and we show the add r-treasure menu
            this.addRTreasure();
        }
        System.out.print("Enter the X coordinate of the treasure's position: ");
        try {
            x = scanner.nextFloat();
        } catch (InputMismatchException e) {
            //... not a float, then we output an error message "ERROR: Input mismatch, a float is required."
            System.out.println("ERROR: Input mismatch, a float is required.");
            //Leave an empty line.
            System.out.println();
            //... and we show the add r-treasure menu
            this.addRTreasure();
        }
        System.out.print("Enter the Y coordinate of the treasure's position: ");
        try {
            y = scanner.nextFloat();
        } catch (InputMismatchException e) {
            //... not a float, then we output an error message "ERROR: Input mismatch, a float is required."
            System.out.println("ERROR: Input mismatch, a float is required.");
            //Leave an empty line.
            System.out.println();
            //... and we show the add r-treasure menu
            this.addRTreasure();
        }
        RLeaf insert = new RLeaf(treasuresName, x,y);
        rect.insert(insert);
        System.out.println();
        System.out.println("The treasure was correctly added to the deck.");
        this.deckMenu();
    }

    /**
     * Removes a treasure from the deck.
     */
    public void removeRTreasure(){
        Scanner scanner = new Scanner(System.in);
        String treasuresName = new String();
        System.out.println();
        System.out.println("Enter the treasure's name: ");
        try {
            treasuresName = scanner.nextLine();
        } catch (InputMismatchException e) {
            //... not a String, then we output an error message "ERROR: Input mismatch, a String is required."
            System.out.println("ERROR: Input mismatch, a String is required.");
            //Leave an empty line.
            System.out.println();
            //... and we show the add r-treasure menu
            this.removeRTreasure();
        }
        //Treasure remove
        int err = rect.delete(treasuresName);
        if(err == 1){
            System.out.println("The name doesn't exist");
            this.removeTreasure();
        }
        System.out.println();
        System.out.println("The treasure was correctly removed from the deck.");
        this.deckMenu();
    }

    /**
     * Visualize the deck representation
     */
    public void visualize(){

        System.out.println();
        System.out.println("Generating the deck representation...");
        System.out.println();
        //Visualize
        RVisualize rVisualize = new RVisualize(this.rect);
        rVisualize.setScaleFact(RTreeReader.getScaleFactor());
        MyFrame myFrame = new MyFrame(rVisualize);
        this.deckMenu();
    }

    /**
     * Search the treasures inside an area designated by the user
     */
    public void searchByArea(){
        Scanner scanner = new Scanner(System.in);
        String firstPoint = new String();
        String secondPoint = new String();
        String[] xAndY1;
        String[] xAndY2;
        float x1 = 0.0f;
        float y1 = 0.0f;
        float x2 = 0.0f;
        float y2 = 0.0f;
        System.out.println();
        System.out.println("Enter the rectangle's first point (X,Y): ");
        try {
            firstPoint = scanner.nextLine();
            firstPoint.replace(" ", "");
            xAndY1 = firstPoint.split(",");
            if (xAndY1.length == 2) {
                x1 = Float.parseFloat(xAndY1[0]);
                y1 = Float.parseFloat(xAndY1[1]);
            } else {
                System.out.println("ERROR: Incorrect format, please enter %f,%f");
                //Leave an empty line.
                System.out.println();
                //... and we show the add r-treasure menu
                this.searchByArea();
            }
        } catch (InputMismatchException e) {
            //... not a String, then we output an error message "ERROR: Input mismatch, a String is required."
            System.out.println("ERROR: Input mismatch, a String is required.");
            //Leave an empty line.
            System.out.println();
            //... and we show the add search by area menu
            this.searchByArea();
        }
        System.out.println("Enter the rectangle's second point (X,Y): ");
        try {
            secondPoint = scanner.nextLine();
            secondPoint.replace(" ", "");
            xAndY2 = secondPoint.split(",");
            if (xAndY2.length == 2) {
                x2 = Float.parseFloat(xAndY2[0]);
                y2 = Float.parseFloat(xAndY2[1]);
            } else {
                System.out.println("ERROR: Incorrect format, please enter %f,%f");
                //Leave an empty line.
                System.out.println();
                //... and we show the add r-treasure menu
                this.searchByArea();
            }
        } catch (InputMismatchException e) {
            //... not a String, then we output an error message "ERROR: Input mismatch, a String is required."
            System.out.println("ERROR: Input mismatch, a String is required.");
            //Leave an empty line.
            System.out.println();
            //... and we show the add search by area menu
            this.searchByArea();
        }
        //Create the 2 points and pass it to the search by area function
        Vec2 corner1 = new Vec2(x1, y1);
        Vec2 corner2 = new Vec2(x2, y2);
        RTSearch rtSearch = new RTSearch();
        ArrayList<RLeaf> treasures = rtSearch.searchByArea(this.rect, corner1, corner2);
        System.out.println(treasures.size() + " treasures were found in this area:");
        //Printing of the treasures
        for (int i = 0; i < treasures.size(); i++) {
            System.out.println(treasures.get(i).getName() + "(" + treasures.get(i).getPos().x + ", " + treasures.get(i).getPos().y + ")");
        }
        this.deckMenu();
    }

    /**
     * Search x number of treasures near a point given its proximity.
     */
    public void searchByProximity () {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        String point;
        String aux;
        String[] xAndY;
        float x = 0.0f;
        float y = 0.0f;

        System.out.println();
        System.out.println("Enter the number of treasures to find: ");
        try {
            number = scanner.nextInt();
            aux = scanner.nextLine();
        } catch (InputMismatchException e) {
            //... not a integer, then we output an error message "ERROR: Input mismatch, an integer is required."
            System.out.println("ERROR: Input mismatch, an integer is required.");
            //Leave an empty line.
            System.out.println();
            //... and we show the add search by area menu
            this.searchByProximity();
        }
        System.out.println("Enter the point to search around (X,Y): ");
        try {
            point = scanner.nextLine();
            point.replace(" ", "");
            xAndY = point.split(",");
            if (xAndY.length == 2) {
                x = Float.parseFloat(xAndY[0]);
                y = Float.parseFloat(xAndY[1]);
            } else {
                System.out.println("ERROR: Incorrect format, please enter %f,%f");
                //Leave an empty line.
                System.out.println();
                //... and we show the add r-treasure menu
                this.searchByProximity();
            }
        } catch (InputMismatchException e) {
            //... not a String, then we output an error message "ERROR: Input mismatch, a String is required."
            System.out.println("ERROR: Input mismatch, a String is required.");
            //Leave an empty line.
            System.out.println();
            //... and we show the add search by area menu
            this.searchByProximity();
        }

        //We create the point and pass it to the search by proximity function
        Vec2 userPoint = new Vec2(x, y);
        RTSearch rtSearch = new RTSearch();
        ArrayList<RLeaf> treasure = rtSearch.searchNearest(this.rect, userPoint, number);
        System.out.println("The " + number + " nearest treasures to this point are:");
        //Printing of the treasures
        for (int i = 0; i < number; i++) {
            System.out.println(treasure.get(i).getName() + " (" + treasure.get(i).getPos().x + ", " + treasure.get(i).getPos().y + ")");
        }
        this.deckMenu();
    }
    /**
     * Show a menu where the user chooses how to manage the loot. It gives the next range of functionalities to
     * choose from:
     * A. Add treasure
     * B. Remove treasure
     * C. List loot
     * D. Search by value (exact)
     * E. Search by value (range)
     * F. Go back
     */
    public void inventoryMenu () {
        Scanner scanner = new Scanner(System.in);   //Scanner to get the user input through the System input.
        char functionality;                     //character to store the functionality selected.
        //Leave an empty line.
        System.out.println();
        //Show a message saying "    A. Add treasure".
        System.out.println("    A. Add treasure");
        //Show a message saying "    B. Find dangerous places (BFS)".
        System.out.println("    B. Remove treasure");
        //Show a message saying "    C. List loot".
        System.out.println("    C. List loot");
        //Show a message saying "    D. Search by value (exact)".
        System.out.println("    D. Search by value (exact)");
        //Show a message saying "    E. Search by value (range)".
        System.out.println("    E. Search by value (range)");
        //Leave an empty line.
        System.out.println();
        //Show a message saying "    F. Go back".
        System.out.println("    F. Go back");
        //Leave an empty line.
        System.out.println();
        //Show a message saying "What functionality do you want to run? ".
        System.out.print("What functionality do you want to run? ");
        //Try to scan the user input looking for a character...
        try {
            //Get the character selected and transform it to uppercase given a String.
            functionality = Character.toUpperCase(scanner.nextLine().charAt(0));
            //If the functionality selected is...
            //... A, then we give the user a menu to add a treasure.
            //... B, then we give the user a menu to remove a treasure.
            //... C, then we show the user a list of the loot.
            //... D, then we give the user a menu to search for an exact treasure given a value.
            //... E, then we give the user a menu to search for a range of treasures given a value.
            //... F, then we go back to the starting menu.
            //... not a character value between A and F, then we output an error message "ERROR: Functionality.
            //must be a character value (A-F)"
            //Leave an empty line.
            //... and we show the routes menu again
            switch (functionality) {
                case 'A' -> this.addTreasure();
                case 'B' -> this.removeTreasure();
                case 'C' -> this.listLoot();
                case 'D' -> this.searchByValueExact();
                case 'E' -> this.searchByValueRange();
                case 'F' -> this.startMenu();
                default -> {
                    System.out.println("ERROR: Functionality must be a character value (A-F)");
                    System.out.println();
                    this.inventoryMenu();
                }
            }
            //... if that is not the case, we catch the exception.
        } catch (InputMismatchException e) {
            //... not a character, then we output an error message "ERROR: Input mismatch, a character is required."
            System.out.println("ERROR: Input mismatch, a character is required.");
            //Leave an empty line.
            System.out.println();
            //... and we show the routes menu again
            this.inventoryMenu();
        }
    }

    /**
     * Allows the user to add a new treasure to the tree, given a treasure name and a treasure value.
     */
    public void addTreasure() {
        Scanner scanner = new Scanner(System.in);
        String treasuresName = new String();
        BigInteger treasureValue = BigInteger.ZERO;
        System.out.println();
        System.out.print("Enter the treasure's name: ");
        try {
            treasuresName = scanner.nextLine();
        } catch (InputMismatchException e) {
            //... not a String, then we output an error message "ERROR: Input mismatch, a String is required."
            System.out.println("ERROR: Input mismatch, a String is required.");
            //Leave an empty line.
            System.out.println();
            //... and we show the find optimal route menu
            this.addTreasure();
        }
        System.out.print("Enter the treasure's value: ");
        try {
            treasureValue = scanner.nextBigInteger();
        } catch (InputMismatchException e) {
            //... not a Big Integer, then we output an error message "ERROR: Input mismatch, a Big Integer is required."
            System.out.println("ERROR: Input mismatch, a Big Integer is required.");
            //Leave an empty line.
            System.out.println();
            //... and we show the find optimal route menu
            this.addTreasure();
        }
        //Treasure addition
        btNode = BTreeReader.add(btNode,new BTNode(treasuresName, treasureValue));
        System.out.println();
        System.out.println("The treasure was correctly added to the loot.");
        this.inventoryMenu();
    }

    /**
     * Removes a treasure from the loot.
     */
    public void removeTreasure() {
        Scanner scanner = new Scanner(System.in);
        String treasuresName = new String();
        System.out.println();
        System.out.print("Enter the treasure's name: ");
        try {
            treasuresName = scanner.nextLine();
        } catch (InputMismatchException e) {
            //... not a String, then we output an error message "ERROR: Input mismatch, a String is required."
            System.out.println("ERROR: Input mismatch, a String is required.");
            //Leave an empty line.
            System.out.println();
            //... and we show the find optimal route menu
            this.removeTreasure();
        }
        //Treasure deletion
        System.out.println();
        BTNode tmp = BTreeReader.delete(btNode, treasuresName);
        if(tmp == null){
            System.out.println("The treasure does not exist");
        }
        else {
            System.out.println("The treasure was correctly removed from the loot.");
            btNode = tmp;

        }
        //int max = BTreeAVL.max(btNode);
        this.inventoryMenu();
    }

    /**
     * Lists the loot following a specific order:
     * I. Preorder
     * II. Postorder
     * III. Inorder
     * IV. By level
     */
    public void listLoot() {
        BTreeTraversals btraversals = new BTreeTraversals();
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);   //Scanner to get the user input through the System input.
        String traversal = new String();            //String to store the traversal selected.
        //Leave an empty line.
        System.out.println();
        //Show a message saying "    I. Preorder".
        System.out.println("    I. Preorder");
        //Show a message saying "    II. Postorder".
        System.out.println("    II. Postorder");
        //Show a message saying "    III. Inorder".
        System.out.println("    III. Inorder");
        //Show a message saying "    IV. By level".
        System.out.println("    IV. By level");
        //Leave an empty line.
        System.out.println();
        //Show a message saying "Pick a traversal: ".
        System.out.print("Pick a traversal: ");
        //Try to scan the user input looking for a character...
        try {
            //Get the character selected and transform it to uppercase given a String.
            traversal = scanner.nextLine();
            //If the traversal selected is...
            if (traversal.toUpperCase().compareTo("I") == 0) {
                //... I, then do a preorder traversal.
                btraversals.preOrder(list,this.btNode);
                for (String element: list){
                    System.out.println(element);
                }
                this.inventoryMenu();
            } else {
                if (traversal.toUpperCase().compareTo("II") == 0) {
                    //... II, then we do a postorder traversal.
                    btraversals.postOrder(list,this.btNode);
                    for (String element: list){
                        System.out.println(element);
                    }
                    this.inventoryMenu();
                } else {
                    if (traversal.toUpperCase().compareTo("III") == 0) {
                        //... III, then we do a inorder traversal.
                        btraversals.inOrder(list,this.btNode);
                        for (String element: list){
                            System.out.println(element);
                        }
                        this.inventoryMenu();
                    } else {
                        if (traversal.toUpperCase().compareTo("IV") == 0) {
                            //... IV, then do a by level traversal.
                            btraversals.levels(list,this.btNode);
                            for (String element: list){
                                System.out.println(element);
                            }
                            this.inventoryMenu();
                        } else {
                            //Leave an empty line.
                            System.out.println();
                            //... not a String value between I and IV, then we output an error message "ERROR: Traversal
                            //must be a String value (I-IV)"
                            System.out.println("ERROR: Traversal must be a String value (I-IV)");
                            this.listLoot();
                            //... and we show the list loot menu again
                        }
                    }
                }
            }
            //... if that is not the case, we catch the exception.
        } catch (InputMismatchException e) {
            //... not a String, then we output an error message "ERROR: Input mismatch, a String is required."
            System.out.println("ERROR: Input mismatch, a String is required.");
            //Leave an empty line.
            System.out.println();
            //... and we show the routes menu again
            this.listLoot();
        }
    }

    /**
     * Searches for a treasure given an exact value.
     */
    public void searchByValueExact() {
        Scanner scanner = new Scanner(System.in);
        BigInteger treasureValue = null;
        String treasureName = new String();
        System.out.println();
        System.out.print("Enter the value to search for: ");
        try {
            treasureValue = scanner.nextBigInteger();
        } catch (InputMismatchException e) {
            //... not a Big Integer, then we output an error message "ERROR: Input mismatch, a Big Integer is required."
            System.out.println("ERROR: Input mismatch, a Big Integer is required.");
            //Leave an empty line.
            System.out.println();
            //... and we show the find optimal route menu
            this.searchByValueExact();
        }
        System.out.println();
        BTNode btNode1 = Search.searchByValueExact(treasureValue, btNode);
        if (btNode1 == null) {
            System.out.println("ERROR: Please enter a value that exists.");
            this.searchByValueExact();
        } else {
            System.out.println("A treasure with this value was found: " + btNode1.getName() + " - " + btNode1.getValue() + " doubloons.");
            this.inventoryMenu();
        }
    }

    /**
     * Searches for n numbers of treasures given a range of values.
     */
    public void searchByValueRange() {
        Scanner scanner = new Scanner(System.in);
        BigInteger minimumTreasureValue = null;
        BigInteger maximumTreasureValue = null;
        int numberOfTreasures = 0;
        String treasureName = new String();
        System.out.println();
        System.out.print("Enter the minimum value to search for: ");
        LinkedList<BTNode> result = new LinkedList<>();
        try {
            minimumTreasureValue = scanner.nextBigInteger();
        } catch (InputMismatchException e) {
            //... not a Big Integer, then we output an error message "ERROR: Input mismatch, a Big Integer is required."
            System.out.println("ERROR: Input mismatch, a Big Integer is required.");
            //Leave an empty line.
            System.out.println();
            //... and we show the find optimal route menu
            this.searchByValueRange();
        }
        System.out.print("Enter the maximum value to search for: ");
        try {
            maximumTreasureValue = scanner.nextBigInteger();
        } catch (InputMismatchException e) {
            //... not a Big Integer, then we output an error message "ERROR: Input mismatch, a Big Integer is required."
            System.out.println("ERROR: Input mismatch, a Big Integer is required.");
            //... and we show the find optimal route menu
            this.searchByValueRange();
        }
        if (maximumTreasureValue.compareTo(minimumTreasureValue) == -1) {
            //... the maximum value is smaller than the minimum value, then we output an error message "ERROR: The minimum
            //value needs to be smaller than the maximum value."
            System.out.println();
            System.out.println("ERROR: The minimum value needs to be smaller than the maximum value.");
            this.searchByValueRange();
        } else {
            if (maximumTreasureValue.compareTo(minimumTreasureValue) == 0) {
                //... the maximum value is equal to the minimum value, then we output an error message "ERROR: The minimum
                //value needs to be smaller than the maximum value."
                System.out.println();
                System.out.println("ERROR: The minimum value needs to be smaller than the maximum value.");
                this.searchByValueRange();
            } else {
                System.out.println();
                result = Search.searchByValueRange(minimumTreasureValue, maximumTreasureValue, btNode);
                if (result.isEmpty()) {
                    System.out.println("ERROR: Please enter a range that exists.");
                    this.searchByValueRange();
                } else {
                    System.out.println(result.size() + " treasures were found in this range: ");
                    System.out.println();
                    for (BTNode node : result){
                        System.out.println(node.getName() + " - " + node.getValue() + " doubloons.");
                    }
                    this.inventoryMenu();
                }
            }
        }
    }
    /**
     * Show a menu where the user chooses how to manage maritime routes. It gives the next range of functionalities to
     * choose from:
     * A. Find points of interest (DFS)
     * B. Find dangerous places (BFS)
     * C. Show the Universal Nautical Chart (MST)
     * D. Find the optimal route (Dijikstra)
     * E. Go back
     */
    public void routesMenu () {
        Scanner scanner = new Scanner(System.in);   //Scanner to get the user input through the System input.
        char functionality;                     //character to store the functionality selected.
        //Leave an empty line.
        System.out.println();
        //Show a message saying "    A. Find points of interest (DFS)".
        System.out.println("    A. Find points of interest (DFS)");
        //Show a message saying "    B. Find dangerous places (BFS)".
        System.out.println("    B. Find dangerous places (BFS)");
        //Show a message saying "    C. Show the Universal Nautical Chart (MST)".
        System.out.println("    C. Show the Universal Nautical Chart (MST)");
        //Show a message saying "    D. Find the optimal route (Dijikstra)".
        System.out.println("    D. Find the optimal route (Dijikstra)");
        //Leave an empty line.
        System.out.println();
        //Show a message saying "    E. Go back".
        System.out.println("    E. Go back");
        //Leave an empty line.
        System.out.println();
        //Show a message saying "What functionality do you want to run? ".
        System.out.print("What functionality do you want to run? ");
        //Try to scan the user input looking for a character...
        try {
            //Get the character selected and transform it to uppercase given a String.
            functionality = Character.toUpperCase(scanner.nextLine().charAt(0));
            //If the functionality selected is...
            //... A, then we give the user a menu to find points of interest.
            //... B, then we give the user a menu to find dangerous places.
            //... C, then we show the user the universal nautical chart.
            //... D, then we give the user a menu to find the optimal route.
            //... E, then we go back to the starting menu.
            //... not a character value between A and E, then we output an error message "ERROR: Functionality.
            //must be a character value (A-E)"
            //Leave an empty line.
            //... and we show the routes menu again
            switch (functionality) {
                case 'A' -> this.findPointsOfInterest();
                case 'B' -> this.findDangerousPlaces();
                case 'C' -> this.showUniversalNauticalChart();
                case 'D' -> this.findOptimalRoute();
                case 'E' -> this.startMenu();
                default -> {
                    System.out.println("ERROR: Functionality must be a character value (A-E)");
                    System.out.println();
                    this.routesMenu();
                }
            }
        //... if that is not the case, we catch the exception.
        } catch (InputMismatchException e) {
            //... not a character, then we output an error message "ERROR: Input mismatch, a character is required."
            System.out.println("ERROR: Input mismatch, a character is required.");
            //Leave an empty line.
            System.out.println();
            //... and we show the routes menu again
            this.routesMenu();
        }
    }
    /**
     * Shows points of interest to the user using DFS, f.e.:
     * Pirate base
     * Treasure trove
     */
    public void findPointsOfInterest () {
        DFS dfs = new DFS();                        //DFS algorithm to find all the points of interests
        Scanner scanner = new Scanner(System.in);   //Scanner to get the user input through the System input.
        int originNodeId = 0;                       //integer to store an identification from the origin node
        ArrayList<Node> result;                     //Array list to store the nodes that compound the result
        //Show a message saying "Enter the origin node's identifier: ".
        System.out.println();
        System.out.print("Enter the origin node's identifier: ");
        //Store the user input inside originNodeId
        try {
            originNodeId = scanner.nextInt();
            //... if that is not the case, we catch the exception.
        } catch (InputMismatchException e) {
            //... not an integer, then we output an error message "ERROR: Input mismatch, an integer is required."
            System.out.println("ERROR: Input mismatch, an integer is required.");
            //Leave an empty line.
            System.out.println();
            //... and we show the find dangerous places menu again
            this.findPointsOfInterest();
        }
        //Check if the originNodeId corresponds to a Node
        if (!graph.ifNodeExists(originNodeId)) {
            //...if the node does not exist then...
            //...show an error message saying ""ERROR: Please enter a node identifier that exists."...
            System.out.println("ERROR: Please enter a node identifier that exists.");
            //...and call again the find points of interest menu
            this.findPointsOfInterest();
        } else {
            //...if the node does exist then...
            //Show a message saying "DFS found the following points of interest: ".
            System.out.println();
            System.out.println("DFS found the following points of interest: ");
            //Leave an empty line.
            System.out.println();
            //call the DFS algorithm to get the result...
            result = dfs.dfsAlgorithm(originNodeId, this.graph);
            //... and for each node we output its name
            for (Node node : result) {
                System.out.println(node.getName());
            }
            //Go back to the routes menu
            this.routesMenu();
        }
    }
    /**
     * Show dangerous places to the user using BFS, f.e.:
     * Kraken's lair
     * Deep waters
     */
    public void findDangerousPlaces () {
        BFS bfs = new BFS();                        //BFS algorithm to find all the dangerous places.
        Scanner scanner =  new Scanner(System.in);  //Scanner to get the user input through the System input.
        int originNodeId = 0;                       //integer to store an identification from the origin node.
        LinkedList<String> result;                  //Linked list to store the strings that compound the result.
        //Show a message saying "Enter the origin node's identifier: ".
        System.out.println();
        System.out.print("Enter the origin node's identifier: ");
        //Store the user input inside originNodeId
        //Try to scan the user input looking for an integer...
        try {
            originNodeId = scanner.nextInt();
            //... if that is not the case, we catch the exception.
        } catch (InputMismatchException e) {
            //... not an integer, then we output an error message "ERROR: Input mismatch, an integer is required."
            System.out.println("ERROR: Input mismatch, an integer is required.");
            //Leave an empty line.
            System.out.println();
            //... and we show the find dangerous places menu again
            this.findDangerousPlaces();
        }
        //Check if the originNodeId corresponds to a Node
        if (!graph.ifNodeExists(originNodeId)) {
            //...if the node does not exist then...
            //...show an error message saying ""ERROR: Please enter a node identifier that exists."...
            System.out.println("ERROR: Please enter a node identifier that exists.");
            //...and call again the find dangerous places menu
            this.findDangerousPlaces();
        } else {
            //...if the node does exist then...
            //Show a message saying "BFS found the following dangerous places: ".
            System.out.println();
            System.out.println("BFS found the following dangerous places: ");
            //Leave an empty line.
            System.out.println();
            //call the BFS algorithm to get the result...
            result = bfs.bfsAlgorithm(this.graph, originNodeId);
            //... and for each node we output its name
            for (String name : result) {
                System.out.println(name);
            }
            //Go back to the routes menu
            this.routesMenu();
        }
    }

    /**
     * Finds the MST
     */
    public void showUniversalNauticalChart () {
        //Show a message saying "Finding the MST...".
        System.out.println();
        System.out.println("Finding the MST...");
        //Leave an empty line.
        System.out.println();
        int[] arr = new int[graph.getNodes().size()];
        MST mst = new MST(arr);

        ArrayList<Edge> edges = mst.mst(graph);
        for (Edge edge: edges){
            System.out.println("From: " + edge.getFrom() + " ➡ To: " + edge.getTo() + " With cost: " + edge.getCost());
        }
        this.routesMenu();
    }

    /**
     * Finds the optimal route between two points: an origin and a destination, using Dijkstra.
     */
    public void findOptimalRoute () {
        Scanner scanner =  new Scanner(System.in);  //Scanner to get the user input through the System input.
        int originNodeId = 0;                       //integer to store an identification from the origin node
        int destinationNodeId = 0;                  //integer to store an identification from the destination node
        Dijkstra dijkstra = new Dijkstra(this.graph);
        List<Node> nodeList = null;
        System.out.println();
        //Show a message saying "Enter the origin node's identifier: ".
        System.out.print("Enter the origin node's identifier: ");
        //Store the user input inside originNodeId
        try {
            originNodeId = scanner.nextInt();
            //... if that is not the case, we catch the exception.
        } catch (InputMismatchException e) {
            //... not an integer, then we output an error message "ERROR: Input mismatch, an integer is required."
            System.out.println("ERROR: Input mismatch, an integer is required.");
            //Leave an empty line.
            System.out.println();
            //... and we show the find optimal route menu
            this.findOptimalRoute();
        }
        //Check if the originNodeId corresponds to a Node
        if (!graph.ifNodeExists(originNodeId)) {
            //...if the node does not exist then...
            //...show an error message saying "ERROR: Please enter a node identifier that exists."...
            System.out.println("ERROR: Please enter a node identifier that exists.");
            //...and call again the find optimal route menu
            this.findOptimalRoute();
        } else {
            //Show a message saying "Enter the destination node's identifier: ".
            System.out.print("Enter the destination node's identifier: ");
            //Store the user input inside destinationNodeId
            try {
                destinationNodeId = scanner.nextInt();
                //... if that is not the case, we catch the exception.
            } catch (InputMismatchException e) {
                //... not an integer, then we output an error message "ERROR: Input mismatch, an integer is required."
                System.out.println("ERROR: Input mismatch, an integer is required.");
                //Leave an empty line.
                System.out.println();
                //... and we show the find optimal route menu
                this.findOptimalRoute();
            }
            if (!graph.ifNodeExists(destinationNodeId)) {
                //...if the node does not exist then...
                //...show an error message saying "ERROR: Please enter a node identifier that exists."...
                System.out.println("ERROR: Please enter a node identifier that exists.");
                //...and call again the find optimal route menu
                this.findOptimalRoute();
            } else {
                //Leave an empty line.
                System.out.println();
                //Show a message saying "Finding the optimal route...".
                System.out.println("Finding the optimal route...");
                //Leave an empty line.
                System.out.println();
                try {
                    nodeList = dijkstra.findShortestPath(originNodeId, destinationNodeId);
                } catch (IndexOutOfBoundsException e) {
                    //...if there is no connexion then...
                    //...show an error message saying "ERROR: Index out of bounds, origin and destination are not connected."...
                    System.out.println("ERROR: Index out of bounds, origin and destination are not connected.");
                    //...and call again the find optimal route menu
                    this.findOptimalRoute();
                }
                assert nodeList != null;
                System.out.println("0) " + nodeList.get(0).getName());
                for (int i = 1; i < nodeList.size(); i++) {
                    System.out.println("    ⬆");
                    System.out.println(graph.getCost(nodeList.get(i - 1).getId(), nodeList.get(i).getId()));
                    System.out.println("    ⬇");
                    System.out.println(i + ") " + nodeList.get(i).getName());
                }
                System.out.println();
                System.out.println("Final cost: " + dijkstra.getFinalCost());
                this.routesMenu();
            }
        }
    }
}
