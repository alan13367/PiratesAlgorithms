import java.util.LinkedList;

public class BTreeAVL {

    public static BTNode balance(BTNode root){
        //left rotation if number is positive
        //right rotation if negative
        root.calcCosts();
        BTNode curr = findNext(root);
        while (curr != null){
            if(curr.getBf() > 0){
                BTNode child = curr.getrChild();
                BTNode parent = curr.getParent();
                curr.setrChild(child.getlChild());
                if(curr.getrChild() != null) {
                    curr.getrChild().setParent(curr);
                }
                child.setlChild(curr);
                curr.setParent(child);
                if(parent == null){
                    child.setParent(null);
                }
                else{
                    child.setParent(parent);
                    if(parent.getrChild() == curr){
                        parent.setrChild(child);
                    }
                    else{
                        parent.setlChild(child);
                    }
                }
            }
            else{
                BTNode child = curr.getlChild();
                BTNode parent = curr.getParent();
                curr.setlChild(child.getrChild());
                if(curr.getlChild() != null) {
                    curr.getlChild().setParent(curr);
                }
                child.setrChild(curr);
                curr.setParent(child);
                if(parent == null){
                    child.setParent(null);
                }
                else{
                    child.setParent(parent);
                    if(parent.getrChild() == curr){
                        parent.setrChild(child);
                    }
                    else{
                        parent.setlChild(child);
                    }
                }
            }
            root = reRoot(root);
            root.calcCosts();
            curr = findNext(root);
        }

        return root;
    }

    private static BTNode findNext(BTNode in){
        LinkedList<BTNode> queue = new LinkedList<>();
        BTNode current;
        queue.add(in);

        while(queue.size() != 0){
            current = queue.poll();

            if(Math.abs(current.getBf()) >= 2){
                return current;
            }
            if(current.getlChild() != null){
                queue.add(current.getlChild());
            }
            if(current.getrChild() != null){
                queue.add(current.getrChild());
            }
        }
        return null;
    }

    private static BTNode reRoot(BTNode root){
        BTNode curr = root;
        while(curr.getParent() != null){
            curr = curr.getParent();
        }
        return curr;
    }
}
