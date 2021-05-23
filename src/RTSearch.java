import java.util.ArrayList;

/**
 * Class implementing R-Trees Data structure Search
 * @author Alfonso Sarro
 * @version 2.0 22 March 2021
 */
public class RTSearch {
    /**
     * Function that will get the 2 points designated by the user and return all the RLeaves inside that area
     * @param root the first parent rectangle in the tree
     * @param corner1 the first point given by the user
     * @param corner2 the second point given by the user
     * @return an array list with all the RLeaves inside the designated area
     */
    public ArrayList<RLeaf> searchByArea(Rect root, Vec2 corner1, Vec2 corner2) {
        Rect rectUser = new Rect(corner1, corner2);
        ArrayList<RLeaf> pointsList = new ArrayList<>();
        return sbA(root, rectUser, pointsList);
    }

    /**
     * A private recursive function that will go inside the valid rectangles, until it finds the valid RLeaves and adds them to an arraylist
     * @param rectTree the rectangle we want to check from the tree
     * @param rectUser the rectangle designated by the user
     * @param pointsList the arraylist with all the valid RLeaves
     * @return an arraylist with all the valid RLeaves (pointsList)
     */
    private ArrayList<RLeaf> sbA(Rect rectTree, Rect rectUser, ArrayList<RLeaf> pointsList) {
        for (int i = 0; i < rectTree.getChildren().size(); i++) {
            if(rectTree.getChildren().get(i) instanceof Rect) {
                if(isOverlapped(rectUser, (Rect) rectTree.getChildren().get(i))) {
                    pointsList = sbA((Rect) rectTree.getChildren().get(i), rectUser, pointsList);
                }
            }
            else {
                RLeaf temp = (RLeaf) rectTree.getChildren().get(i);
                if(rectUser.findGrowth(temp.getPos()) == 0) {
                    pointsList.add(temp);
                }
            }
        }
        return pointsList;
    }

    /**
     * A function that will determine if a rectangle is overlapping with the one designated by the user
     * @param userRectangle the rectangle of the user
     * @param treeRectangle the rectangle we want to check from the tree
     * @return true if it overlaps, false if it doesn't overlap
     */
    private boolean isOverlapped(Rect userRectangle, Rect treeRectangle) {
        if(userRectangle.getBounds()[0].x > treeRectangle.getBounds()[1].x ||
                    userRectangle.getBounds()[1].x < treeRectangle.getBounds()[0].x) {
                return false;
        }
        else if(userRectangle.getBounds()[0].y > treeRectangle.getBounds()[1].y ||
                userRectangle.getBounds()[1].y < treeRectangle.getBounds()[0].y) {
            return false;
        }
        return true;
    }

    /**
     * FUnction that given a specific point will search for x ammount of points nearest to the designated point
     * @param tree the parent rectangle of the tree
     * @param point the point designated by the user
     * @param numTreasures the amount of treasures the user wants to search for
     * @return an arraylist of RLeaves ordered from closest to furthest
     */
    public ArrayList<RLeaf> searchNearest(Rect tree, Vec2 point, int numTreasures) {
        ArrayList<RLeaf> rLeaves = new ArrayList<>();
        return sN(tree, point, rLeaves, numTreasures);
    }

    /**
     * A private function that checks the nearest rectangle, enters it and gets all the Rleaves.
     * Then, it sorts the arrayList by proximity.
     * @param tree the rectangle we want to check
     * @param point the point designated by the user
     * @param rLeaves the arraylist with all the rLeaves ordered
     * @param numTreasures the number of treasures the user wants to look for
     * @return an arraylist with all the rLeaves ordered (rLeaves)
     */
    private ArrayList<RLeaf> sN(Rect tree, Vec2 point, ArrayList<RLeaf> rLeaves, int numTreasures) {
        float minimumDistanceLeaf = Float.MAX_VALUE;
        ArrayList<Rect> children = orderChildrenRect(tree, point);
        for (int i = 0; i < children.size(); i++) {
            //We check if we already have the number of treasures the user wants to look for
            if (rLeaves.size() >= numTreasures) {
                //If we do, we end the function
                break;
            }

            for (int j = 0; j < children.get(i).getChildren().size(); j++) {
                //We check if the next children will be rLeaves, and if they are we add them to the arraylist
                if(children.get(i).getChildren().get(j) instanceof RLeaf) {
                    if (minimumDistanceLeaf > ((RLeaf) children.get(i).getChildren().get(j)).getPos().findDistance(point)) {
                        minimumDistanceLeaf = ((RLeaf) children.get(i).getChildren().get(j)).getPos().findDistance(point);
                        rLeaves.add(0, (RLeaf) children.get(i).getChildren().get(j));
                    } else {
                        rLeaves.add((RLeaf) children.get(i).getChildren().get(j));
                    }
                }
                else{
                    //If they are not rLeaves, we add the children to an internal arrayList of rectangles
                    children.addAll(orderChildrenRect((Rect) children.get(i).getChildren().get(j), point));
                }
            }
        }
        return rLeaves;
    }

    /**
     * A function that will order all the rectangle children by proximity
     * @param parentRect the rectangle parent to the children we want to order
     * @param point the point given by the user
     * @return the children ordered by proximity
     */
    private ArrayList<Rect> orderChildrenRect(Rect parentRect, Vec2 point) {
        float minimumDistanceRect = Float.MAX_VALUE;
        ArrayList<Rect> orderedChildren = new ArrayList<>();
        for (int i = 0; i < parentRect.getChildren().size(); i++) {
            if (parentRect.getChildren().get(i) instanceof Rect) {
                if(minimumDistanceRect > ((Rect) parentRect.getChildren().get(i)).getCentre().findDistance(point)) {
                    minimumDistanceRect = ((Rect) parentRect.getChildren().get(i)).getCentre().findDistance(point);
                    orderedChildren.add(0, (Rect) parentRect.getChildren().get(i));
                }
                else{
                    orderedChildren.add((Rect) parentRect.getChildren().get(i));
                }
            }
        }
        bubbleSort(orderedChildren, point);
        return orderedChildren;
    }

    /**
     * Function that will sort all the children array by proximity to the point
     * @param children the array with all the valid children
     * @param point the point designated by the user
     */
    private void bubbleSort(ArrayList<Rect> children, Vec2 point) {
        for (int i = 0; i < children.size() - 1; i++) {
            for (int j = 0; j < children.size() - i - 1; j++) {
                if(children.get(j).getCentre().findDistance(point) > children.get(j + 1).getCentre().findDistance(point)) {
                    Rect temp = children.get(j);
                    children.set(j, children.get(j + 1));
                    children.set(j + 1, temp);
                }
            }
        }
    }
}