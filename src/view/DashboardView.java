/*
 * Created by JFormDesigner on Sat May 13 06:21:31 IST 2023
 */

package view;

import java.awt.*;
import javax.swing.*;

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
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        tablesPanel = new JPanel();

        //======== this ========
        setPreferredSize(new Dimension(1000, 550));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (
        new javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e"
        , javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
        , new java .awt .Font ("D\u0069al\u006fg" ,java .awt .Font .BOLD ,12 )
        , java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (
        new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("\u0062or\u0064er" .equals (e .getPropertyName () )) throw new RuntimeException( )
        ; }} );
        setLayout(null);

        //---- label1 ----
        label1.setText("SavourSync");
        add(label1);
        label1.setBounds(new Rectangle(new Point(50, 50), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("Current Capacity");
        add(label2);
        label2.setBounds(new Rectangle(new Point(400, 50), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("Reservations for today");
        label3.setPreferredSize(new Dimension(130, 16));
        add(label3);
        label3.setBounds(new Rectangle(new Point(705, 95), label3.getPreferredSize()));

        //======== tablesPanel ========
        {
            tablesPanel.setLayout(new GridBagLayout());
            ((GridBagLayout)tablesPanel.getLayout()).columnWidths = new int[] {0, 0};
            ((GridBagLayout)tablesPanel.getLayout()).rowHeights = new int[] {0, 0};
            ((GridBagLayout)tablesPanel.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
            ((GridBagLayout)tablesPanel.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};
        }
        add(tablesPanel);
        tablesPanel.setBounds(-65, 105, 700, 700);

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

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - isuru Yahampath
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JPanel tablesPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
