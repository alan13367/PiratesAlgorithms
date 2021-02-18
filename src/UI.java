import java.util.Scanner;

public class UI {


    public UI() {
    }

    public void ui () {
        System.out.println("-= Pirates of the Mediterranean =-");
        System.out.println();
        this.startMenu();
    }
    public void startMenu () {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        System.out.println("1. Routes (Graphs)");
        System.out.println("2. Inventory (Binary trees)");
        System.out.println("3. Deck (R trees)");
        System.out.println("4. Crew (Tables)");
        System.out.println();
        System.out.println("5. Exit");
        System.out.println();
        System.out.print("Choose an option: ");
        option = scanner.nextInt();
        switch (option) {
            case 1:
                this.routesMenu();
            case 2:
                //TODO: 2. Inventory (Binary trees)
            case 3:
                //TODO: 3. Deck (R trees)
            case 4:
                //TODO: 4. Crew (Tables)
            case 5:
                System.out.println("So long, comrade!");
                break;
            default:
                System.out.println("ERROR: Option must be an integer value (1-5)");
                this.startMenu();
        }

    }
    public void routesMenu () {
        Scanner scanner = new Scanner(System.in);
        char functionality = 0;

        System.out.println("    A. Find points of interest (DFS)");
        System.out.println("    B. Find dangerous places (BFS)");
        System.out.println("    C. Show the Universal Nautical Chart (MST)");
        System.out.println("    D. Find the optimal route (Dijikstra)");
        System.out.println();
        System.out.println("    E. Go back");
        System.out.println();
        System.out.println("What functionality do you want to run? ");
        functionality = Character.toUpperCase(scanner.nextLine().charAt(0));
        switch (functionality) {
            case 'A':
                this.findPointsOfInterest();
            case 'B':
                this.findDangerousPlaces();
            case 'C':
                this.showUniversalNauticalChart();
            case 'D':
                //TODO: D. Find the optimal route (Dijikstra)
            case 'E':
                this.startMenu();
            default:
                System.out.println("ERROR: Functionality must be a character value (A-E)");
                this.routesMenu();
        }
    }
    public void findPointsOfInterest () {
        Scanner scanner = new Scanner(System.in);
        int originNodeId = 0;

        System.out.println("Enter the origin node's indentifier: ");
        originNodeId = scanner.nextInt();
        //TODO: Find if the given node identifier exists
        System.out.println("DFS found the following points of interest: ");
        System.out.println();
        //TODO: DFS and posterior printing
    }
    public void findDangerousPlaces () {
        Scanner scanner =  new Scanner(System.in);
        int originNodeId = 0;

        System.out.println("Enter the origin node's identifier: ");
        originNodeId = scanner.nextInt();
        //TODO: Find if the given node identifier exists
        System.out.println("BFS foind the following dangerous places: ");
        //TODO: BFS and posterior printing
    }
    public void showUniversalNauticalChart () {
        System.out.println("Finding the MST...");
        //TODO: find the MST
    }
    public void findOptimalRoute () {
        Scanner scanner =  new Scanner(System.in);
        int originNodeId = 0;
        int destinationNodeId = 0;

        System.out.println("Enter the origin node's identifier: ");
        originNodeId = scanner.nextInt();
        //TODO: Handle missmatching
        System.out.println("Enter the destination node's identifier: ");
        destinationNodeId = scanner.nextInt();
        //TODO: Handle missmatching
        System.out.println();
        System.out.println("Finding the optimal route...");
        //TODO: Find the optimal route
    }

}
