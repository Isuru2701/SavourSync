/*
 * Created by JFormDesigner on Fri May 12 18:43:40 IST 2023
 */

package view;

import controller.NavBarController;

import java.awt.*;
import javax.swing.*;

/**
 * @author ASUS
 */
public class NavbarView extends AbstractView {
    private NavBarController controller;
    public NavbarView() {

        controller = new NavBarController();
        initComponents();
    }

    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - isuru Yahampath
        dashboardButton = new JButton();
        reserveButton = new JButton();
        reportButton = new JButton();
        logoutButton = new JButton();

        //======== this ========
        setBackground(new Color(0x171717));
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new
        javax . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax
        . swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java
        . awt .Font ( "D\u0069alog", java .awt . Font. BOLD ,12 ) ,java . awt
        . Color .red ) , getBorder () ) );  addPropertyChangeListener( new java. beans .
        PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order" .
        equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
        setLayout(new FlowLayout());

        //---- dashboardButton ----
        dashboardButton.setText("Dashboard");
        dashboardButton.setBackground(new Color(0x3f3f3f));
        dashboardButton.setForeground(new Color(0xa6a6a6));
        dashboardButton.setPreferredSize(new Dimension(100, 30));
        dashboardButton.setFocusPainted(false);
        add(dashboardButton);

        //---- reserveButton ----
        reserveButton.setText("Reserve");
        reserveButton.setBackground(new Color(0x3f3f3f));
        reserveButton.setForeground(new Color(0xa6a6a6));
        reserveButton.setPreferredSize(new Dimension(100, 30));
        add(reserveButton);

        //---- reportButton ----
        reportButton.setText("Report");
        reportButton.setBackground(new Color(0x3f3f3f));
        reportButton.setForeground(new Color(0xa6a6a6));
        reportButton.setPreferredSize(new Dimension(100, 30));
        add(reportButton);

        //---- logoutButton ----
        logoutButton.setText("Logout");
        logoutButton.setBackground(new Color(0x3f3f3f));
        logoutButton.setForeground(new Color(0xa6a6a6));
        logoutButton.setPreferredSize(new Dimension(100, 30));
        add(logoutButton);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

        dashboardButton.addActionListener(e -> {
            controller.navigate(this, new DashboardView());
        });

        reportButton.addActionListener(e -> {
            controller.navigate(this, new ReportView());
        });

        logoutButton.addActionListener(e -> {
            System.exit(1);
        });


    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - isuru Yahampath
    private JButton dashboardButton;
    private JButton reserveButton;
    private JButton reportButton;
    private JButton logoutButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
