public class Vec2 {
    public float x;
    public float y;

    public Vec2() {
        this.x = 0;
        this.y = 0;
    }

    public Vec2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float findDistance(Vec2 target){
        return (float) Math.sqrt(Math.pow((target.x - this.x),2) + Math.pow((target.y - this.y),2));
    }

}
