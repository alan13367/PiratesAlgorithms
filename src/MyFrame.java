import javax.swing.*;

public class MyFrame extends JFrame {


    public MyFrame(RVisualize rVisualize){
        this.setSize(1280,720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(rVisualize);
        this.setVisible(true);
    }

}
