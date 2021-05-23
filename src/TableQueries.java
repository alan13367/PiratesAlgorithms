import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;

/**
 * Class for the Queries of the tables and showing the Histogram
 * Created by Alan Beltran Pozo 17/05/21
 */
public class TableQueries {

    private int[] ages;

    /**
     * Public constructor to build the class with the information of the ages on it.
     * @param ages
     */
    public TableQueries(int[] ages){
        this.ages = ages;
    }

    /**
     * Function that displays the histogram of the number of pirates by ages.
     */
    public void drawChart() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < ages.length; i++) {
            if(ages[i] != 0){
                dataset.setValue(ages[i], "",Integer.toString(i+1));
            }
        }
        JFreeChart chart = ChartFactory.createBarChart("Pirates by Age","",
                "Number of Pirates", dataset,PlotOrientation.VERTICAL,false,true,false);
        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.blue);

        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.GREEN);
        ChartFrame frame1 = new ChartFrame("Count",chart);
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.setVisible(true);
        frame1.setSize(1280,720);


    }

}
