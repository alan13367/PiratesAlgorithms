import java.io.FileNotFoundException;
import java.util.*;

public class UI {
    private Graph graph;
    /**
     * UI starting message
     */
    public void ui () {
        //Output the starting message "-= Pirates of the Mediterranean =-".
        System.out.println("-= ☠ Pirates of the Mediterranean ☠ =-");
        this.dataset();
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
    public void dataset () {
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
            this.dataset();
        }
        catch (FileNotFoundException e) {
            //... not a correct file, then we output an error message "ERROR: File not found, please enter a valid dataset."
            System.out.println("ERROR: File not found, please enter a valid dataset.");
            //... and we show the starting menu again
            this.dataset();
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
                    //TODO: 2. Inventory (Binary trees)
                    break;
                case 3:
                    //TODO: 3. Deck (R trees)
                    break;
                case 4:
                    //TODO: 4. Crew (Tables)
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
            //... not a character value between A and E, then we output an error message "ERROR: Functionality
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
