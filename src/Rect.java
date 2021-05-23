import java.util.ArrayList;

/**
 * Class implementing the Rectangles of the R-Tree data structure
 * @author Ramon Sabater
 * @version 2.0 25 April 2021
 */
public class Rect implements RNode{

    public static final int MAX_CHILDREN = 3;
    public static final int MIN_CHILDREN = 1;

    private Vec2 centre;
    private Vec2[] bounds;
    private Rect parent;
    private ArrayList<RNode> children;

    /**
     * Empty constructor to initialize Array lists and set variables to default
     */
    public Rect() {
        this.parent = null;
        this.bounds = new Vec2[2];
        this.centre = new Vec2();
        this.children = new ArrayList<>();
    }

    public Rect(Vec2 corner1, Vec2 corner2){
        this.parent = null;
        this.bounds = new Vec2[2];
        float xmin = corner1.x;
        float xmax = corner2.x;

        float ymin = corner1.y;
        float ymax = corner2.y;

        if(corner2.x < xmin) {
            xmin = corner2.x;
            xmax = corner1.x;
        }

        if(corner2.y < ymin) {
            ymin = corner2.y;
            ymax = corner1.y;
        }

        bounds[0] = new Vec2(xmin, ymin);
        bounds[1] = new Vec2(xmax, ymax);
        calcCentre();
        this.children = null;
    }

    /**
     * Gets the center point of the rectangle
     * @return a vec2 object containing the center coordinates
     */
    public Vec2 getCentre() {
        return centre;
    }

    /**
     * Gets the bound points of the rectangle
     * @return an array holding the bottom left point on the first position and top right on the second position
     */
    public Vec2[] getBounds() {
        return bounds;
    }

    /**
     * Override of interface method to get the parent
     * @return the parent rectangle
     */
    @Override
    public Rect getParent() {
        return parent;
    }

    /**
     * Gets the children of the current rectangle
     * @return the children of the current node as an array
     */
    public ArrayList<RNode> getChildren() {
        return children;
    }

    /**
     * Sets the provided parent as the parent of the rectangle
      * @param parent the parent which the rectangle is meant to have
     */
    @Override
    public void setParent(Rect parent) {
        this.parent = parent;
    }



    /**
     * Re calculates the bounds of the rectangle according to its children
     */
    public void reBalance(){
        calcBounds();
        calcCentre();
    }

    /**
     * Calculates the centre position of the rectangle
     */
    public void calcCentre(){
        this.centre = new Vec2((bounds[0].x + bounds[1].x)/2.0f,(bounds[0].y + bounds[1].y)/2.0f);
    }

    /**
     * Calculates the bound points of the rectangle
     */
    public void calcBounds(){
        float minX = Float.MAX_VALUE, minY = Float.MAX_VALUE;
        float maxX = Float.MIN_VALUE, maxY = Float.MIN_VALUE;
        if(children.isEmpty()){
            return;
        }
        if(children.get(0).getClass() == RLeaf.class){
            for (RNode node : children){
                RLeaf leaf = (RLeaf)node;
                if(leaf.getPos().x < minX){
                    minX = leaf.getPos().x;
                }
                if(leaf.getPos().x > maxX){
                    maxX = leaf.getPos().x;
                }
                if(leaf.getPos().y < minY){
                    minY = leaf.getPos().y;
                }
                if(leaf.getPos().y > maxY){
                    maxY = leaf.getPos().y;
                }
            }
        }
        else{
            for (RNode node : children){
                Rect rect = (Rect) node;
                rect.reBalance();
                if(rect.bounds[0].x < minX){
                    minX = rect.bounds[0].x;
                }
                if(rect.bounds[1].x > maxX){
                    maxX = rect.bounds[1].x;
                }
                if(rect.bounds[0].y < minY){
                    minY = rect.bounds[0].y;
                }
                if(rect.bounds[1].y > maxY){
                    maxY = rect.bounds[1].y;
                }
            }
        }

        bounds[0] = new Vec2(minX, minY);
        bounds[1] = new Vec2(maxX, maxY);

    }

    /**
     * Method which inserts a leaf node into the rectangle
     * @param in the leaf node to be inserted
     */
    public void insert(RLeaf in){
        if(children.isEmpty()){
            children.add(in);
            in.setParent(this);
            this.reBalance();
            return;
        }
        if(children.get(0).getClass() == RLeaf.class){
            if(children.size() == MAX_CHILDREN){
                ArrayList<RLeaf> reInsert = new ArrayList<>();
                for(RNode curr: children){
                    reInsert.add((RLeaf) curr);
                }
                reInsert.add(in);
                if(this.parent == null || this.parent.getChildren().size() == MAX_CHILDREN){
                    //level above full of children split current level into two rectangles and insert
                    children = genRects(reInsert);
                    for (RNode curr: children){
                        curr.setParent(this);
                    }
                    this.reBalance();
                }
                else{
                    //delete current rectangle and create two new ones and re insert
                    int index = this.parent.getChildren().indexOf(this);
                    ArrayList<RNode> newRects = genRects(reInsert);
                    this.parent.getChildren().remove(index);
                    for (RNode curr : newRects){
                        curr.setParent(this.parent);
                        this.parent.getChildren().add(curr);
                    }
                    this.parent.reBalance();
                }
            }
            else{
                children.add(in);
                in.setParent(this);
            }
        }
        else{
            float dist = Float.MAX_VALUE;
            int target = 0;
            for (int i = 0; i < children.size(); i++) {
                Rect curr = (Rect) children.get(i);
                if(curr.findGrowth(in.getPos()) < dist){
                    dist = curr.findGrowth(in.getPos());
                    target = i;
                }
            }
            ((Rect)children.get(target)).insert(in);
        }
    }

    /**
     * Generates rectangles which would fit the leaf nodes provided
     * @param input an array list of points which the rectangles will have to accommodate
     * @return an array list of rectangles with all the points in input sorted
     */
    private ArrayList<RNode> genRects(ArrayList<RLeaf> input){
        ArrayList<RNode> output = new ArrayList<>();
        output.add(new Rect());
        output.add(new Rect());
        float dist = Float.MIN_VALUE;
        int pair1 = 0, pair2 = 0;
        for (int i = 0; i < input.size(); i++) {
            for (int j = i+1; j < input.size(); j++) {
                if(input.get(i).getPos().findDistance(input.get(j).getPos()) > dist){
                    dist = input.get(i).getPos().findDistance(input.get(j).getPos());
                    pair1 = i;
                    pair2 = j;
                }
            }
        }

        int numChildren = input.size();

        RLeaf p1 = input.get(pair1);
        RLeaf p2 = input.get(pair2);

        ((Rect)output.get(0)).insert(p1);
        ((Rect)output.get(1)).insert(p2);
        input.remove(p1);
        input.remove(p2);
        for(RLeaf curr: input){
            if(((Rect)output.get(0)).findGrowth(curr.getPos()) < ((Rect)output.get(1)).findGrowth(curr.getPos())){
                ((Rect)output.get(0)).insert(curr);
                ((Rect)output.get(0)).reBalance();
            }
            else{
                ((Rect)output.get(1)).insert(curr);
                ((Rect)output.get(1)).reBalance();
            }
        }

        return output;
    }

    public float findGrowth(Vec2 point){
        float x,y;
        if(point.x < this.bounds[0].x){
            x = this.bounds[0].x;
        }
        else if(point.x > this.bounds[1].x){
            x = this.bounds[1].x;
        }
        else{
            x = point.x;
        }

        if(point.y < this.bounds[0].y){
            y = this.bounds[0].y;
        }
        else if(point.y > this.bounds[1].y){
            y = this.bounds[1].y;
        }
        else{
            y = point.y;
        }
        Vec2 out = new Vec2(x,y);
        return out.findDistance(point);
    }

    public int delete(String name){
        RLeaf target = this.find(name);
        if(target == null){
            return 1;
        }
        this.children = del(target);
        return 0;
    }

    private ArrayList<RNode> del(RLeaf target){
        if(this.children.get(0).getClass() == RLeaf.class){
            for (RNode node : this.children){
                RLeaf curr = (RLeaf) node;
                if(curr.getPos().equal(target.getPos())){
                    this.children.remove(node);
                    break;
                }
            }
        }
        else{
            int index = -1;
            float minDistance = Float.MAX_VALUE;
            for (int i = 0; i < this.children.size(); i++) {
                float currDistance = ((Rect) this.children.get(i)).getCentre().findDistance(target.getPos());
                if(currDistance < minDistance){
                    minDistance = currDistance;
                    index = i;
                }
            }
            this.children = ((Rect)this.children.get(index)).del(target);
        }
        Rect parent = this.parent;
        if(parent == null){
            return this.children;
        }
        if(this.children.size() < MIN_CHILDREN){
            parent.children.remove(this);
            if(parent.children.size() >= MIN_CHILDREN){
                for(RNode node : this.children){
                    parent.insert((RLeaf) node);
                }
            }
            else{
                ArrayList<RLeaf> reInsert = new ArrayList<>();
                for (RNode node : this.children){
                    reInsert.add((RLeaf) node);
                }
                for(RNode node : parent.children){
                    Rect curr = (Rect) node;
                    reInsert.addAll(breakRect(curr));
                }
                for(RLeaf node : reInsert){
                    parent.insert(node);
                }
            }
        }
        return parent.children;
    }

    private ArrayList<RLeaf> breakRect(Rect top){
        ArrayList<RLeaf> out = new ArrayList<>();
        if(top.children.get(0).getClass() == RLeaf.class){
            for(RNode node : top.children){
                out.add((RLeaf) node);
            }
        }
        else{
            for (RNode node : top.children){
                Rect curr = (Rect) node;
                out.addAll(breakRect(curr));
            }
        }
        return out;
    }

    private RLeaf find(String name){
        if(this.children.isEmpty()){
            return null;
        }
        if(this.children.get(0).getClass() == RLeaf.class){
            for (RNode curr: children){
                RLeaf node = (RLeaf) curr;
                if(node.getName().equals(name)){
                    return node;
                }
            }
        }
        else{
            for (RNode curr: children) {
                Rect node = (Rect) curr;
                RLeaf out = node.find(name);
                if(out != null){
                    return out;
                }
            }
        }
        return null;
    }

}
