/*
 * Created by JFormDesigner on Sat May 13 06:21:31 IST 2023
 */

package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author ASUS
 */
public class DashboardView extends AbstractView {
    public DashboardView() {
        initComponents();
    }

    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - isuru Yahampath
        tablesPanel = new JPanel();
        capacityPanel = new JPanel();
        ganttPanel = new JPanel();

        //======== this ========
        setPreferredSize(new Dimension(1000, 600));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
        . border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder
        . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .
        awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder( )) )
        ;  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
        ;
        setLayout(null);

        //======== tablesPanel ========
        {
            tablesPanel.setLayout(new GridBagLayout());
            ((GridBagLayout)tablesPanel.getLayout()).columnWidths = new int[] {0, 0};
            ((GridBagLayout)tablesPanel.getLayout()).rowHeights = new int[] {0, 0};
            ((GridBagLayout)tablesPanel.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
            ((GridBagLayout)tablesPanel.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};
        }
        add(tablesPanel);
        tablesPanel.setBounds(0, 275, 535, 380);

        //======== capacityPanel ========
        {
            capacityPanel.setPreferredSize(new Dimension(340, 450));
            capacityPanel.setBackground(new Color(0x1e1e1e));
            capacityPanel.setLayout(new BoxLayout(capacityPanel, BoxLayout.X_AXIS));
        }
        add(capacityPanel);
        capacityPanel.setBounds(0, -15, 515, 310);

        //======== ganttPanel ========
        {
            ganttPanel.setPreferredSize(new Dimension(700, 800));
            ganttPanel.setLayout(new BoxLayout(ganttPanel, BoxLayout.X_AXIS));
        }
        add(ganttPanel);
        ganttPanel.setBounds(540, 0, 495, 630);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < getComponentCount(); i++) {
                Rectangle bounds = getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            setMinimumSize(preferredSize);
            setPreferredSize(preferredSize);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        tablesPanel.add(new TableForm());

        capacityPanel.add(new CapacityView());

        ganttPanel.add(new ReservationsView());
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - isuru Yahampath
    private JPanel tablesPanel;
    private JPanel capacityPanel;
    private JPanel ganttPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
