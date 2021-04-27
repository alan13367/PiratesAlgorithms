public class RLeaf implements RNode{

    private String name;
    private Vec2 pos;
    private Rect parent;

    /**
     * Constructor to manually build a node
     * @param name the name of the node
     * @param x the x position of the node
     * @param y the y position of the node
     */
    public RLeaf(String name, float x, float y) {
        this.name = name;
        this.pos = new Vec2(x,y);
        this.parent = null;
    }

    /**
     * Constructor that builds a leaf node from a string, format must follow the files for the r tree
     * @param data a string containing all the information to build the leaf node
     */
    public RLeaf(String data){
        String[] split = data.split(",");
        this.name = split[0];
        this.pos = new Vec2(Float.parseFloat(split[1]), Float.parseFloat(split[2]));
    }

    /**
     * Gets the name of the node
     * @return a string containing the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the position of the leaf node as a Vec2 object
     * @return a Vec2 object containing the relevant position of the node
     */
    public Vec2 getPos() {
        return pos;
    }

    /**
     * Gets the parent of the leaf node
     * @return a Rect object which the is the parent of the leaf node
     */
    @Override
    public Rect getParent() {
        return parent;
    }

    /**
     * Sets the provided Rect object as parent of the leaf
     * @param parent the Rect object to be set as the parent
     */
    public void setParent(Rect parent) {
        this.parent = parent;
    }
}
