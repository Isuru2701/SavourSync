/*
 * Created by JFormDesigner on Fri May 12 19:55:49 IST 2023
 */

package view;

import java.awt.*;
import javax.swing.*;

/**
 * @author ASUS
 */
public class ReserveView extends AbstractView {
    public ReserveView() {
        initComponents();
    }

    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - isuru Yahampath
        navbarPanel = new JPanel();
        label1 = new JLabel();

        //======== this ========
        setBackground(new Color(0x171717));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border.
        EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing
        . border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ),
        java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( )
        { @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () ))
        throw new RuntimeException( ); }} );
        setLayout(new BorderLayout());

        //======== navbarPanel ========
        {
            navbarPanel.setPreferredSize(new Dimension(0, 50));
            navbarPanel.setBackground(new Color(0x171717));
            navbarPanel.setLayout(null);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < navbarPanel.getComponentCount(); i++) {
                    Rectangle bounds = navbarPanel.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = navbarPanel.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                navbarPanel.setMinimumSize(preferredSize);
                navbarPanel.setPreferredSize(preferredSize);
            }
        }
        add(navbarPanel, BorderLayout.NORTH);

        //---- label1 ----
        label1.setText("RESERVATION");
        label1.setForeground(Color.white);
        add(label1, BorderLayout.WEST);
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
