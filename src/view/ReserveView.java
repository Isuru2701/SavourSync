/*
 * Created by JFormDesigner on Sat May 13 06:21:51 IST 2023
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
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        textField2 = new JTextField();
        label4 = new JLabel();
        textField3 = new JTextField();
        label5 = new JLabel();
        label6 = new JLabel();
        textField4 = new JTextField();
        textField5 = new JTextField();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
        ( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER, javax. swing. border
        . TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt
        . Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
        propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( )
        ; }} );
        setLayout(null);

        //---- label1 ----
        label1.setText("Place Reservation");
        label1.setPreferredSize(new Dimension(150, 16));
        add(label1);
        label1.setBounds(new Rectangle(new Point(25, 30), label1.getPreferredSize()));
        add(textField1);
        textField1.setBounds(new Rectangle(new Point(120, 70), textField1.getPreferredSize()));

        //---- label2 ----
        label2.setText("Name");
        add(label2);
        label2.setBounds(new Rectangle(new Point(35, 75), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("Email");
        add(label3);
        label3.setBounds(new Rectangle(new Point(35, 130), label3.getPreferredSize()));
        add(textField2);
        textField2.setBounds(new Rectangle(new Point(120, 130), textField2.getPreferredSize()));

        //---- label4 ----
        label4.setText("Contact No.");
        label4.setPreferredSize(new Dimension(100, 16));
        add(label4);
        label4.setBounds(new Rectangle(new Point(35, 200), label4.getPreferredSize()));
        add(textField3);
        textField3.setBounds(new Rectangle(new Point(120, 200), textField3.getPreferredSize()));

        //---- label5 ----
        label5.setText("Table No(s).");
        label5.setPreferredSize(new Dimension(100, 16));
        add(label5);
        label5.setBounds(new Rectangle(new Point(380, 75), label5.getPreferredSize()));

        //---- label6 ----
        label6.setText("Seats");
        label6.setPreferredSize(new Dimension(100, 16));
        add(label6);
        label6.setBounds(new Rectangle(new Point(35, 265), label6.getPreferredSize()));
        add(textField4);
        textField4.setBounds(new Rectangle(new Point(125, 265), textField4.getPreferredSize()));
        add(textField5);
        textField5.setBounds(new Rectangle(new Point(460, 70), textField5.getPreferredSize()));

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
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - isuru Yahampath
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField2;
    private JLabel label4;
    private JTextField textField3;
    private JLabel label5;
    private JLabel label6;
    private JTextField textField4;
    private JTextField textField5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
