/*
 * Created by JFormDesigner on Sun May 14 21:04:24 IST 2023
 */

package view;

import java.awt.*;
import javax.swing.*;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import controller.CapacityController;

//chart imports
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 * @author ASUS
 */
public class CapacityView extends JPanel {


    private static CapacityController controller;

    public CapacityView() {
        controller = new CapacityController(this);
        initComponents();
        controller.plot();
    }

    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - isuru Yahampath
        chartPanel = new JPanel();

        //======== this ========
        setPreferredSize(new Dimension(350, 450));
        setBackground(new Color(0x1e1e1e));
        setBorder(null);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
        swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax. swing. border
        . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069al\u006fg"
        ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder
        ( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
        .beans .PropertyChangeEvent e) {if ("\u0062or\u0064er" .equals (e .getPropertyName () )) throw new RuntimeException
        ( ); }} );
        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

        //======== chartPanel ========
        {
            chartPanel.setPreferredSize(new Dimension(350, 450));
            chartPanel.setBackground(new Color(0x1e1e1e));
            chartPanel.setBorder(null);
            chartPanel.setLayout(new BoxLayout(chartPanel, BoxLayout.X_AXIS));
        }
        add(chartPanel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

    }

    //used to plot the donut chart
    public void plot(double value, double total) {

        //setting up the dataset
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Occupied: " + total, total);
        dataset.setValue("Total: " + value , value);

        JFreeChart chart = ChartFactory.createRingChart(
                "Occupancy Ratio",  // Title
                dataset,       // Dataset
                false,          // Show legend
                true,          // Use tooltips
                false          // Generate URLs
        );

        chart.getPlot().setBackgroundPaint(new Color(30, 30, 30, 255));
        ChartPanel panel = new ChartPanel(chart);
        panel.setSize(340, 450);
        panel.setBackground(new Color(30, 30, 30, 255));
        chartPanel.add(panel);
        setVisible(true);


    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - isuru Yahampath
    private JPanel chartPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
