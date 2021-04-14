import java.math.BigInteger;

public class BTNode {

    private String name;
    private BigInteger value;
    private int bf;
    private int height;
    private BTNode parent;
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
        this.parent = null;
        this.bf = 0;
        this.height = 0;
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
     * Getter to get the parent of the node
     * @return the parent of the node
     */
    public BTNode getParent() {
        return parent;
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
     * Setter to input the parent of the node
     * @param parent the node to be set as the parent
     */
    public void setParent(BTNode parent) {
        this.parent = parent;
    }

    /**
     * Setter to input the left child of the node
     * @param lChild the node to be set as the left child
     */
    public void setlChild(BTNode lChild) {
        this.lChild = lChild;
    }

    /**
     * Getter for the balance factor
     * @return the balance factor
     */
    public int getBf() {
        return bf;
    }

    /**
     * Setter to hardcode the balance factor
     * @param bf the balance factor desired
     */
    public void setBf(int bf) {
        this.bf = bf;
    }

    /**
     * Getter for the height of the Node
     * @return the height of the node on the tree
     */
    public int getHeight() {
        return height;
    }

    /**
     * Setter for the height of the node
     * @param height of the node
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * It calculates the costs of the height and inbalance value, for every node, starting from the one u provide
      */
    public void calcCosts(){
        if(this.rChild == null && this.lChild == null){
            this.height = 1;
            this.bf = 0;
        }
        else if(this.rChild != null && this.lChild == null){
            this.rChild.calcCosts();
            this.height = this.rChild.height + 1;
            this.bf = this.rChild.height;
        }
        else if(this.rChild == null){
            this.lChild.calcCosts();
            this.height = this.lChild.height + 1;
            this.bf = -this.lChild.height;
        }
        else{
            this.rChild.calcCosts();
            this.lChild.calcCosts();
            if(this.rChild.height >= this.lChild.height){
                this.height = this.rChild.height + 1;
            }
            else{
                this.height = this.lChild.height + 1;
            }
            this.bf = this.rChild.height - this.lChild.height;
        }

    }

    /**
     * Setter to input the right child of the node
     * @param rChild the node to be set as the right child
     */
    public void setrChild(BTNode rChild) {
        this.rChild = rChild;
    }
}
