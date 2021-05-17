import javax.swing.*;

public class MyFrame extends JFrame {


    public MyFrame(RVisualize rVisualize){
        this.setSize(1920,1080);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(rVisualize);
        this.setVisible(true);
    }

    public MyFrame(TableQueries tableQueries){
        this.setSize(1920,1080);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(tableQueries);
        this.setVisible(true);
    }



}
