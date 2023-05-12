/*
 * Created by JFormDesigner on Fri May 12 19:43:54 IST 2023
 */

package view;

import java.awt.*;
import javax.swing.*;

/**
 * @author ASUS
 */
public class ReportView extends AbstractView {
    public ReportView() {
        initComponents();
    }

    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - isuru Yahampath
        navbarPanel = new JPanel();
        label1 = new JLabel();

        //======== this ========
        setBackground(new Color(0x171717));
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.
        swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border
        .TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog"
        ,java.awt.Font.BOLD,12),java.awt.Color.red), getBorder
        ())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java
        .beans.PropertyChangeEvent e){if("\u0062order".equals(e.getPropertyName()))throw new RuntimeException
        ();}});
        setLayout(new BorderLayout());

        //======== navbarPanel ========
        {
            navbarPanel.setPreferredSize(new Dimension(10, 50));
            navbarPanel.setBackground(new Color(0x171717));
            navbarPanel.setLayout(new FlowLayout());
        }
        add(navbarPanel, BorderLayout.NORTH);

        //---- label1 ----
        label1.setText("REPORTS");
        label1.setForeground(Color.white);
        add(label1, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        navbarPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        navbarPanel.setPreferredSize(new Dimension(700, 50));

        navbarPanel.add(new NavbarView());


    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - isuru Yahampath
    private JPanel navbarPanel;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
