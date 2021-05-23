import javax.swing.*;

/**
 * Class to visualize the frame of the R-Tree data structure
 * @author Alan Beltran
 * @version 2.0 7 May 2021
 */
public class MyFrame extends JFrame {


    /**
     *Constructor class for MyFrame
     * @param rVisualize class to pass the Rect data into the frame and display the R-Tree
     */
    public MyFrame(RVisualize rVisualize){
        this.setSize(1920,1080);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(rVisualize);
        this.setVisible(true);
    }


}
