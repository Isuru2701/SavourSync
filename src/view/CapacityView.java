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
import org.knowm.xchart.style.PieStyler;

/**
 * @author ASUS
 */
public class CapacityView extends JPanel {


    private PieChart chart;
    private JPanel chartXChartPanel;
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
        refreshButton = new JButton();

        //======== this ========
        setPreferredSize(new Dimension(350, 450));
        setBackground(new Color(0x1e1e1e));
        setBorder(null);
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(
        new javax.swing.border.EmptyBorder(0,0,0,0), ""
        ,javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM
        ,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12)
        ,java.awt.Color.red), getBorder())); addPropertyChangeListener(
        new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
        ){if("bord\u0065r".equals(e.getPropertyName()))throw new RuntimeException()
        ;}});
        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {1.0, 0.0, 1.0E-4};

        //======== chartPanel ========
        {
            chartPanel.setPreferredSize(new Dimension(350, 450));
            chartPanel.setBackground(new Color(0x1e1e1e));
            chartPanel.setBorder(null);
            chartPanel.setLayout(new BoxLayout(chartPanel, BoxLayout.X_AXIS));
        }
        add(chartPanel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- refreshButton ----
        refreshButton.setText("Refresh");
        refreshButton.setPreferredSize(new Dimension(100, 50));
        add(refreshButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.EAST, GridBagConstraints.NONE,
            new Insets(0, 0, 0, 0), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        refreshButton.addActionListener(e -> {
            controller.plot();
            chartPanel.revalidate();
            chartPanel.repaint();


        });
    }

    //used to plot the donut chart
    public void plot(int value, int total) {


        chartPanel.removeAll();
        //setting up the dataset, using xchart
        String[] categories = {"Occupied", "Total"};
        int[] values = { value, total};

        chart = new PieChartBuilder()
                .width(350)
                .height(450)
                .title("")
                .build();


        //stylizing.
        chart.getStyler().setPlotContentSize(.9);

        Color background = new Color(30, 30, 30);

        chart.getStyler().setChartBackgroundColor(background);
        chart.getStyler().setPlotBackgroundColor(background);

        chart.getStyler().setLegendBorderColor(background);

        chart.getStyler().setLegendBackgroundColor(background);
        chart.getStyler().setChartFontColor(Color.white);

        chart.getStyler().setLabelsVisible(false);
        chart.getStyler().setLabelType(PieStyler.LabelType.Value);

        chart.getStyler().setSeriesColors(new Color[]{
            new Color(135, 206, 250),
            new Color(0, 122, 255)
        });

        chart.getStyler().setPlotBorderColor(background);
        chart.getStyler().setDefaultSeriesRenderStyle(PieSeries.PieSeriesRenderStyle.Donut);


        for (int i = 0; i < categories.length; i++) {
            chart.addSeries(categories[i], values[i]);
        }
        chartXChartPanel = new XChartPanel<>(chart);
        chartPanel.add(chartXChartPanel);


    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - isuru Yahampath
    private JPanel chartPanel;
    private JButton refreshButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
