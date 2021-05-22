import java.util.ArrayList;

public class RTSearch {
    public ArrayList<RLeaf> searchByArea(Rect root, Vec2 corner1, Vec2 corner2) {
        Rect rectUser = new Rect(corner1, corner2);
        ArrayList<RLeaf> pointsList = new ArrayList<>();
        return sbA(root, rectUser, pointsList);
    }
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


    public ArrayList<RLeaf> searchNearest(Rect tree, Vec2 point, int numTreasures) {
        ArrayList<RLeaf> rLeaves = new ArrayList<>();

        return sN(tree, point, rLeaves, numTreasures);
    }

    private ArrayList<RLeaf> sN(Rect tree, Vec2 point, ArrayList<RLeaf> rLeaves, int numTreasures) {
        float minimumDistanceRect = Float.MAX_VALUE;
        float minimumDistanceLeaf = Float.MAX_VALUE;
        ArrayList<Rect> children = orderChildrenRect(tree, point);
        for (int i = 0; i < children.size(); i++) {
            if (rLeaves.size() >= numTreasures) {
                break;
            }

            for (int j = 0; j < children.get(i).getChildren().size(); j++) {
                if(children.get(i).getChildren().get(j) instanceof RLeaf) {
                    if (minimumDistanceLeaf > ((RLeaf) children.get(i).getChildren().get(j)).getPos().findDistance(point)) {
                        minimumDistanceLeaf = ((RLeaf) children.get(i).getChildren().get(j)).getPos().findDistance(point);
                        rLeaves.add(0, (RLeaf) children.get(i).getChildren().get(j));
                    } else {
                        rLeaves.add((RLeaf) children.get(i).getChildren().get(j));
                    }
                }
                else{
                    children.addAll(orderChildrenRect((Rect) children.get(i).getChildren().get(j), point));
                }
            }
        }
        return rLeaves;
    }

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
    
    private ArrayList<Rect> bubbleSort(ArrayList<Rect> children, Vec2 point) {
        for (int i = 0; i < children.size() - 1; i++) {
            for (int j = 0; j < children.size() - i - 1; j++) {
                if(children.get(j).getCentre().findDistance(point) > children.get(j + 1).getCentre().findDistance(point)) {
                    Rect temp = children.get(j);
                    children.set(j, children.get(j + 1));
                    children.set(j + 1, temp);
                }
            }
        }
        return children;
    }
}