import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class RVisualize extends JPanel {

    private Rect rect;

    public RVisualize(Rect rect){
        this.rect = rect;
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        Vec2[] coords =  rect.getBounds();
        Rectangle2D.Double rec = new Rectangle2D.Double(coords[0].x,coords[0].y,coords[1].x,coords[1].y);
        g2D.draw(rec);
        for (int i = 0; i <rect.getChildren().size(); i++) {
            if(rect.getChildren().get(i) instanceof Rect){
                coords = ((Rect)rect.getChildren().get(i)).getBounds();
                rec = new Rectangle2D.Double(coords[0].x,coords[0].y,coords[1].x,coords[1].y);
                g2D.draw(rec);
            }
        }


    }

}
