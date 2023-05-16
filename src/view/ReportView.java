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
        controller = new ReportController(this);
        initComponents();

        controller = new ReportController(this);
    }

    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - isuru Yahampath

        //======== this ========
        setPreferredSize(new Dimension(1000, 700));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
        0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
        . BOTTOM, new java .awt .Font ("Dialo\u0067" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
        red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
        beans .PropertyChangeEvent e) {if ("borde\u0072" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
        setLayout(new GridLayout(1, 2));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        add(controller.dailyReport(), 0);
        add(controller.canceledReport(), 1);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - isuru Yahampath
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
