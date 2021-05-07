import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class RVisualize extends JPanel {

    private Rect rect;

    private double scaleFact;

    public RVisualize(Rect rect){
        this.rect = rect;
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        Graphics2D g2D = (Graphics2D) g;

        Vec2[] coords =  rect.getBounds();
        Rectangle2D.Double rec = new Rectangle2D.Double((double)coords[0].x*(double)scaleFact,(double)coords[0].y*(double)scaleFact,(double)(coords[1].x-coords[0].x)*(double)scaleFact,(double)(coords[1].y-coords[0].y)*(double)scaleFact);
        g2D.setStroke(new BasicStroke(2));
        g2D.setColor(Color.GREEN);
        g2D.draw(rec);

        recursiveRect(g2D, rect.getChildren());
    }

    private void recursiveRect(Graphics2D g2D,ArrayList<RNode> children){
        Rectangle2D.Double rec;
        Line2D.Double line2D ;
        Vec2 pos;
        Vec2[] coords;
        if(children.get(0).getClass() == RLeaf.class){
            for (RNode node : children){
                RLeaf curr = (RLeaf) node;
                pos = curr.getPos();
                line2D = new Line2D.Double((double)pos.x* scaleFact,(double) pos.y* scaleFact,(double) pos.x* scaleFact,(double)pos.y* scaleFact);
                g2D.setStroke(new BasicStroke(4));
                g2D.setColor(Color.RED);
                g2D.draw(line2D);
            }
        }
        else{
            for (RNode node : children){
                Rect curr = (Rect) node;
                coords = curr.getBounds();
                rec = new Rectangle2D.Double((double)coords[0].x* scaleFact,(double)coords[0].y* scaleFact,(double)(coords[1].x-coords[0].x)* scaleFact,(double)(coords[1].y-coords[0].y)* scaleFact);
                g2D.setStroke(new BasicStroke(2));
                g2D.setColor(Color.GREEN);
                g2D.draw(rec);
                recursiveRect(g2D,curr.getChildren());
            }


        }


    }

    public void setScaleFact(double scaleFact) {
        this.scaleFact = scaleFact;
    }
}
