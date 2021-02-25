import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {
    public UI() {}
    /**
     * UI starting message
     */
    public void ui () {
        //Output the starting message "-= Pirates of the Mediterranean =-".
        System.out.println("-= ☠ Pirates of the Mediterranean ☠ =-");
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
                case 2:
                    //TODO: 2. Inventory (Binary trees)
                case 3:
                    //TODO: 3. Deck (R trees)
                case 4:
                    //TODO: 4. Crew (Tables)
                case 5:
                    System.out.println("So long, comrade!");
                    //... 5, then we output a farewell message and exit the program.
                    break;
                default:
                    //... not an integer value between 1 and 5, then we output an error message "ERROR: Option must be
                    // an integer value from 1 to 5."
                    System.out.println("ERROR: Option must be an integer value from 1 to 5.");
                    //Leave an empty line.
                    System.out.println();
                    //... and we show the starting menu again
                    this.startMenu();
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
        System.out.println("What functionality do you want to run? ");
        //Try to scan the user input looking for a character...
        try {
            //Get the character selected and transform it to uppercase given a String.
            functionality = Character.toUpperCase(scanner.nextLine().charAt(0));
            switch (functionality) {
                //If the functionality selected is...
                case 'A':
                    //... A, then we give the user a menu to find points of interest.
                    this.findPointsOfInterest();
                case 'B':
                    //... B, then we give the user a menu to find dangerous places.
                    this.findDangerousPlaces();
                case 'C':
                    //... C, then we show the user the universal nautical chart.
                    this.showUniversalNauticalChart();
                case 'D':
                    //... D, then we give the user a menu to find the optimal route.
                    this.findOptimalRoute();
                case 'E':
                    //... E, then we go back to the starting menu.
                    this.startMenu();
                default:
                    //... not a character value between A and E, then we output an error message "ERROR: Functionality
                    //must be a character value (A-E)"
                    System.out.println("ERROR: Functionality must be a character value (A-E)");
                    //Leave an empty line.
                    System.out.println();
                    //... and we show the routes menu again
                    this.routesMenu();
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
        Scanner scanner = new Scanner(System.in);   //Scanner to get the user input through the System input.
        int originNodeId;                           //integer to store an identification from the origin node
        //Show a message saying "Enter the origin node's identifier: ".
        System.out.println("Enter the origin node's identifier: ");
        //Store the user input inside originNodeId
        originNodeId = scanner.nextInt();
        //TODO: Find if the given node identifier exists
        //Show a message saying "DFS found the following points of interest: ".
        System.out.println("DFS found the following points of interest: ");
        //Leave an empty line.
        System.out.println();
        //TODO: DFS and posterior printing
    }
    /**
     * Show dangerous places to the user using BFS, f.e.:
     * Kraken's lair
     * Deep waters
     */
    public void findDangerousPlaces () {
        Scanner scanner =  new Scanner(System.in);  //Scanner to get the user input through the System input.
        int originNodeId = 0;                       //integer to store an identification from the origin node
        //Show a message saying "Enter the origin node's identifier: ".
        System.out.println("Enter the origin node's identifier: ");
        //Store the user input inside originNodeId
        originNodeId = scanner.nextInt();
        //TODO: Find if the given node identifier existsç
        //Show a message saying "BFS found the following dangerous places: ".
        System.out.println("BFS found the following dangerous places: ");
        //TODO: BFS and posterior printing
    }

    /**
     * Finds the MST
     */
    public void showUniversalNauticalChart () {
        //Show a message saying "Finding the MST...".
        System.out.println("Finding the MST...");
        //TODO: find the MST
    }

    /**
     * Finds the optimal route between two points: an origin and a destination, using Dijkstra.
     */
    public void findOptimalRoute () {
        Scanner scanner =  new Scanner(System.in);  //Scanner to get the user input through the System input.
        int originNodeId = 0;                       //integer to store an identification from the origin node
        int destinationNodeId = 0;                  //integer to store an identification from the destination node
        //Show a message saying "Enter the origin node's identifier: ".
        System.out.println("Enter the origin node's identifier: ");
        //Store the user input inside originNodeId
        originNodeId = scanner.nextInt();
        //TODO: Handle missmatching
        //Show a message saying "Enter the destination node's identifier: ".
        System.out.println("Enter the destination node's identifier: ");
        //Store the user input inside destinationNodeId
        destinationNodeId = scanner.nextInt();
        //TODO: Handle missmatching
        //Leave an empty line.
        System.out.println();
        //Show a message saying "Finding the optimal route...".
        System.out.println("Finding the optimal route...");
        //TODO: Find the optimal route
    }

}
