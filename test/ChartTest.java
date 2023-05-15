import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sun May 14 21:22:54 IST 2023
 */

import org.jfree.chart.*;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 * @author ASUS
 */
public class ChartTest extends JFrame {

    public static void main(String[] args) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Category 1", 25.0);
        dataset.setValue("Category 2", 40.0);
        dataset.setValue("Category 3", 35.0);

        JFreeChart chart = ChartFactory.createRingChart(
                "Donut Chart", dataset, true, true, false);

        PiePlot plot = (PiePlot) chart.getPlot();
        ChartPanel chartPanel = new ChartPanel(chart);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(chartPanel, BorderLayout.CENTER);

        JFrame frame = new JFrame("Donut Chart Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}