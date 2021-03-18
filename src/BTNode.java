import java.math.BigInteger;

public class BTNode {

    private String name;
    private BigInteger value;
    private BTNode lChild;
    private BTNode rChild;

    /**
     * Constructor to create a standard node with no children
     * @param name the name of the node
     * @param value the value of the node
     */
    public BTNode(String name, BigInteger value){
        this.name = name;
        this.value = value;
        this.lChild = null;
        this.rChild = null;
    }

    /**
     * Getter to get the name of the Node
     * @return the name of the node
     */
    public String getName() {
        return name;
    }

    /**
     * Getter to get the value of the Node
     * @return the value of the node
     */
    public BigInteger getValue() {
        return value;
    }

    /**
     * Getter to get the left child of the Node
     * @return the left child of the node
     */
    public BTNode getlChild() {
        return lChild;
    }

    /**
     * Getter to get the right child of the Node
     * @return the right child of the node
     */
    public BTNode getrChild() {
        return rChild;
    }

    /**
     * Setter to input the left child of the node
     * @param lChild the node to be set as the left child
     */
    public void setlChild(BTNode lChild) {
        this.lChild = lChild;
    }

    /**
     * Setter to input the right child of the node
     * @param rChild the node to be set as the right child
     */
    public void setrChild(BTNode rChild) {
        this.rChild = rChild;
    }
}
