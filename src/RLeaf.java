public class RLeaf implements RNode{

    private String name;
    private Vec2 pos;
    private Rect parent;

    public RLeaf(String name, float x, float y) {
        this.name = name;
        this.pos = new Vec2(x,y);
        this.parent = null;
    }

    public RLeaf(String data){
        String[] split = data.split(",");
        this.name = split[0];
        this.pos = new Vec2(Float.parseFloat(split[1]), Float.parseFloat(split[2]));
    }

    public String getName() {
        return name;
    }

    public Vec2 getPos() {
        return pos;
    }

    @Override
    public Rect getParent() {
        return parent;
    }

    public void setParent(Rect parent) {
        this.parent = parent;
    }
}
