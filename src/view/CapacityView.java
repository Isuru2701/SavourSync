/*
 * Created by JFormDesigner on Sun May 14 21:04:24 IST 2023
 */

package view;

import java.awt.*;
import javax.swing.*;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import controller.CapacityController;

//chart imports
import org.knowm.xchart.*;
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
        swing. border. EmptyBorder( 0, 0, 0, 0) , "", javax. swing. border
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
    public void plot(int value, int total) {

        //setting up the dataset, using xchart
        String[] categories = {"Occupied", "Total"};
        int[] values = {(int) value, (int) total};

        PieChart chart = new PieChartBuilder()
                .width(350)
                .height(450)
                .title("Capacity")
                .build();


        chart.getStyler().setPlotContentSize(.9);

        Color background = new Color(30, 30, 30);

        chart.getStyler().setChartBackgroundColor(background);
        chart.getStyler().setPlotBackgroundColor(background);

        chart.getStyler().setLegendBorderColor(background);

        chart.getStyler().setLegendBackgroundColor(background);
        chart.getStyler().setChartFontColor(Color.white);



        chart.getStyler().setPlotBorderColor(background);
        chart.getStyler().setDefaultSeriesRenderStyle(PieSeries.PieSeriesRenderStyle.Donut);

        for (int i = 0; i < categories.length; i++) {
            chart.addSeries(categories[i], values[i]);
        }
        JPanel chartXChartPanel = new XChartPanel<>(chart);
        chartPanel.add(chartXChartPanel);




    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - isuru Yahampath
    private JPanel chartPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
