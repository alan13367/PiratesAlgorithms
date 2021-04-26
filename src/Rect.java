import java.util.ArrayList;

public class Rect implements RNode{

    public static final int MAX_CHILDREN = 5;

    private Vec2 centre;
    private Vec2[] bounds;
    private Rect parent;
    private ArrayList<RNode> children;

    public Rect() {
        this.parent = null;
        this.bounds = new Vec2[2];
        this.centre = new Vec2();
        this.children = new ArrayList<>();
    }

    public Vec2 getCentre() {
        return centre;
    }

    public Vec2[] getBounds() {
        return bounds;
    }

    @Override
    public Rect getParent() {
        return parent;
    }

    public ArrayList<RNode> getChildren() {
        return children;
    }

    public void reBalance(){
        calcBounds();
        calcCentre();
    }

    public void calcCentre(){
        this.centre = new Vec2((bounds[0].x + bounds[1].x)/2.0f,(bounds[0].y + bounds[1].y)/2.0f);
    }

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
                else if(leaf.getPos().x > maxX){
                    maxX = leaf.getPos().x;
                }
                if(leaf.getPos().y < minY){
                    minY = leaf.getPos().y;
                }
                else if(leaf.getPos().y > maxY){
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
                else if(rect.bounds[1].x > maxX){
                    maxX = rect.bounds[1].x;
                }
                if(rect.bounds[0].y < minY){
                    minY = rect.bounds[0].y;
                }
                else if(rect.bounds[1].y > maxY){
                    maxY = rect.bounds[1].y;
                }
            }
        }

        bounds[0] = new Vec2(minX, minY);
        bounds[1] = new Vec2(maxX, maxY);

    }

    //TODO this
    public RNode insert(RLeaf in){
        return null;
    }

}
