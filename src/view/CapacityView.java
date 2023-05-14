/*
 * Created by JFormDesigner on Sun May 14 21:04:24 IST 2023
 */

package view;

import java.awt.*;
import javax.swing.*;

import controller.CapacityController;

//chart imports
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 * @author ASUS
 */
public class CapacityView extends AbstractView {


    private static CapacityController controller;

    public CapacityView() {
        controller = new CapacityController(this);
        initComponents();
    }

    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - isuru Yahampath

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing.
        border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax. swing. border. TitledBorder. CENTER
        , javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069al\u006fg" ,java .awt .Font
        .BOLD ,12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (
        new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062or\u0064er"
        .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {1.0, 1.0E-4};
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

    }

    //used to plot the donut chart
    public void plot(double value, double total) {

        //setting up the dataset
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Occupied", value);
        dataset.setValue("Total", total);

        JFreeChart chart = ChartFactory.createRingChart(
                "Donut Chart",  // Title
                dataset,       // Dataset
                true,          // Show legend
                true,          // Use tooltips
                false          // Generate URLs
        );

        ChartFrame frame = new ChartFrame("Occupancy Ratio", chart);
        frame.setBounds(0, 0, 450, 350);
        frame.pack();
        add(frame);
        setVisible(true);


    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - isuru Yahampath
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
