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
}
