/**
 * Class implementing a 2D Vector
 * @author Ramon Sabater
 * @version 2.0 27 April 2021
 */
public class Vec2 {
    public float x;
    public float y;

    /**
     * Empty constructor to create a vector at the origin
     */
    public Vec2() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Constructor to create Vec2 object at the coordinates provided
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Vec2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Finds the distance from the current vector to the vector provided
     * @param target the target vector
     * @return the distance between target and this as a float
     */
    public float findDistance(Vec2 target){
        return (float) Math.sqrt(Math.pow((target.x - this.x),2) + Math.pow((target.y - this.y),2));
    }

    /**
     * Finds if two vectors are equal
     * @param target vector to compare
     * @return if the vectors have equal position
     */
    public boolean equal(Vec2 target){
        return this.x == target.x && this.y == target.y;
    }
}
