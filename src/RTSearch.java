import java.util.ArrayList;

public class RTSearch {
    private float minimumDistance = 0;
    public ArrayList<RLeaf> searchByArea(Rect root, Vec2 corner1, Vec2 corner2) {
        Rect rectUser = new Rect(corner1, corner2);
        return sbA(root, rectUser, null);

    }
    private ArrayList<RLeaf> sbA(Rect rectTree, Rect rectUser, ArrayList<RLeaf> pointsList) {

        for(int i = 0; i < rectTree.getChildren().size(); i++) {
            if (rectTree.getChildren().get(0) instanceof RLeaf) {
                pointsList.add((RLeaf) rectTree.getChildren().get(0));
            }
            if (isOverlapped(rectUser, rectTree)) {
                sbA((Rect) rectTree.getChildren().get(0), rectUser, pointsList);
            }
        }
            return pointsList;

    }

    private boolean isOverlapped(Rect userRectangle, Rect treeRectangle) {
        if(userRectangle.getBounds()[0].x > treeRectangle.getBounds()[0].x && userRectangle.getBounds()[0].y > treeRectangle.getBounds()[0].y) {
            return true;
        }
        if(userRectangle.getBounds()[1].x < treeRectangle.getBounds()[1].x && userRectangle.getBounds()[1].y < treeRectangle.getBounds()[1].y) {
            return true;
        }
        return false;
    }


    public RLeaf searchNearest(Rect tree, Vec2 point) {
        RNode nearest = null;
        if(tree.getChildren().isEmpty()) {
            return null;
        }
        if(tree.getChildren().get(0).getClass() == RLeaf.class) {
            return (RLeaf) tree.getChildren().get(0);
        }
        for(int i = 0; i < tree.getChildren().size(); i++) {
            if (tree.getChildren().get(i).getClass() == RNode.class) {
                RNode node = tree.getChildren().get(i);
                float distance = node.getParent().getCentre().findDistance(point);
                if (distance < minimumDistance) {
                    minimumDistance = distance;
                    nearest = tree.getChildren().get(i);
                }
            }
        }
        assert nearest != null;
        searchNearest((Rect) nearest, point);

        return null;
    }










    /*
        if(tree.getChildren().isEmpty()){
            return null;
        }
        if(tree.getChildren().get(0).getClass() == RLeaf.class){
            for (RNode curr: tree.getChildren()){
                RLeaf node = (RLeaf) curr;
                if(node.getName().equals(value)){
                    return node;
                }
            }
        }
        else{
            for (RNode curr: tree.getChildren()) {
                Rect node = (Rect) curr;
                RLeaf out = RTSearch.search(node, value);
                if(out != null){
                    return out;
                }
            }
        }
        return null;

     */

}