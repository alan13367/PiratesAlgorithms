import javax.swing.*;

public class MyFrame extends JFrame {


    public MyFrame(RVisualize rVisualize){
        this.setSize(1920,1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(rVisualize);
        this.setVisible(true);
    }

}
