import java.util.ArrayList;

public class Rect implements RNode{

    public static final int MAX_CHILDREN = 3;

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

    @Override
    public void setParent(Rect parent) {
        this.parent = parent;
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
                if(in.getPos().findDistance(curr.centre) < dist){
                    dist = in.getPos().findDistance(curr.centre);
                    target = i;
                }
            }
            ((Rect)children.get(target)).insert(in);
        }
    }

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

        RLeaf p1 = input.get(pair1);
        RLeaf p2 = input.get(pair2);

        ((Rect)output.get(0)).insert(p1);
        ((Rect)output.get(1)).insert(p2);
        input.remove(p1);
        input.remove(p2);

        for(RLeaf curr: input){
            if(curr.getPos().findDistance(((Rect)output.get(0)).getCentre()) <
                    curr.getPos().findDistance(((Rect)output.get(1)).getCentre())){
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

}
