/*
 * Created by JFormDesigner on Sat May 13 06:21:41 IST 2023
 */

package view;

import controller.ReportController;

import java.awt.*;
import javax.swing.*;

/**
 * @author ASUS
 */
public class ReportView extends AbstractView {

    private ReportController controller;
    public ReportView() {
        initComponents();

        controller = new ReportController(this);
    }

    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - isuru Yahampath
        dailyPanel = new JPanel();
        cancelPanel = new JPanel();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.
        border.EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border.TitledBorder.CENTER
        ,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font
        .BOLD,12),java.awt.Color.red), getBorder())); addPropertyChangeListener(
        new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("bord\u0065r"
        .equals(e.getPropertyName()))throw new RuntimeException();}});
        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {20, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 1.0, 1.0E-4};

        //======== dailyPanel ========
        {
            dailyPanel.setLayout(null);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < dailyPanel.getComponentCount(); i++) {
                    Rectangle bounds = dailyPanel.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = dailyPanel.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                dailyPanel.setMinimumSize(preferredSize);
                dailyPanel.setPreferredSize(preferredSize);
            }
        }
        add(dailyPanel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //======== cancelPanel ========
        {
            cancelPanel.setLayout(null);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < cancelPanel.getComponentCount(); i++) {
                    Rectangle bounds = cancelPanel.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = cancelPanel.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                cancelPanel.setMinimumSize(preferredSize);
                cancelPanel.setPreferredSize(preferredSize);
            }
        }
        add(cancelPanel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        
        dailyButton.addActionListener(e -> {
            controller.dailyReport();
        });

        cancelsButton.addActionListener(e -> {
            controller.canceledReport();
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - isuru Yahampath
    private JPanel dailyPanel;
    private JPanel cancelPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
