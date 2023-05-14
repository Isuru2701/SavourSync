/*
 * Created by JFormDesigner on Sat May 13 06:54:32 IST 2023
 */

package view;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import controller.AppController;

import java.awt.*;
import javax.swing.*;

/**
 * @author ASUS
 */
public class App extends JFrame {

    AppController controller;
    public App() {
        controller = new AppController(this);

        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        }
        catch (UnsupportedLookAndFeelException ignored) {

        }
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - isuru Yahampath
        navbarPanel = new JPanel();
        label1 = new JLabel();
        dashboardButton = new JButton();
        reserveButton = new JButton();
        reportButton = new JButton();
        logoutButton = new JButton();
        contentPanel = new JPanel();

        //======== this ========
        setPreferredSize(new Dimension(1000, 750));
        setBackground(new Color(0x393939));
        var contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {57, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 1.0, 1.0E-4};

        //======== navbarPanel ========
        {
            navbarPanel.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new
            javax . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax
            . swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java
            . awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt
            . Color .red ) ,navbarPanel. getBorder () ) ); navbarPanel. addPropertyChangeListener( new java. beans .
            PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "bord\u0065r" .
            equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
            navbarPanel.setLayout(new FlowLayout());

            //---- label1 ----
            label1.setText("SavourSync    ");
            label1.setFont(new Font("Segoe UI", Font.BOLD, 20));
            navbarPanel.add(label1);

            //---- dashboardButton ----
            dashboardButton.setText("Dashboard");
            dashboardButton.setFocusPainted(false);
            dashboardButton.setPreferredSize(new Dimension(150, 50));
            navbarPanel.add(dashboardButton);

            //---- reserveButton ----
            reserveButton.setText("Reserve");
            reserveButton.setPreferredSize(new Dimension(150, 50));
            navbarPanel.add(reserveButton);

            //---- reportButton ----
            reportButton.setText("Report");
            reportButton.setPreferredSize(new Dimension(150, 50));
            navbarPanel.add(reportButton);

            //---- logoutButton ----
            logoutButton.setText("Exit");
            logoutButton.setPreferredSize(new Dimension(150, 50));
            navbarPanel.add(logoutButton);
        }
        contentPane.add(navbarPanel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //======== contentPanel ========
        {
            contentPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        }
        contentPane.add(contentPanel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        //ADDING ACTION LISTENERS
        dashboardButton.addActionListener(e -> {
            controller.setView(new DashboardView());
        });

        reportButton.addActionListener(e -> {
            controller.setView(new ReportView());
        });

        reserveButton.addActionListener(e -> {
            controller.setView(new ReserveView());
        });

        logoutButton.addActionListener(e -> {
            controller.kill();
        });

        controller.setView(new DashboardView());

    }
    
    public JPanel getContentPanel() {
        return contentPanel;
    }

    public void setController(AppController controller) {
        this.controller = controller;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - isuru Yahampath
    private JPanel navbarPanel;
    private JLabel label1;
    private JButton dashboardButton;
    private JButton reserveButton;
    private JButton reportButton;
    private JButton logoutButton;
    private JPanel contentPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
