public class Node {

    private int id;
    private String name;
    private boolean safe;

    /**
     * The Node constructor.
     * @param id the id of the node.
     * @param name the name of the node.
     * @param safe if the node is safe or not.
     */
    public Node(int id, String name, boolean safe){
        this.id = id;
        this.name = name;
        this.safe = safe;
    }

    /**
     * The Id Getter
     * @return return of the node's Id
     */
    public int getId(){
        return id;
    }
    /**
     * The Name Getter
     * @return return of the node's Name
     */
    public String getName(){
        return name;
    }
    /**
     * The Safe Getter
     * @return return whether if it's safe or not
     */
    public boolean getSafe(){
        return safe;
    }
}
