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
        label7 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        button1 = new JButton();
        button2 = new JButton();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
        0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
        . BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
        red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
        beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
        setLayout(null);

        //---- label1 ----
        label1.setText("Place Reservation");
        label1.setPreferredSize(new Dimension(150, 16));
        add(label1);
        label1.setBounds(new Rectangle(new Point(25, 30), label1.getPreferredSize()));
        add(textField1);
        textField1.setBounds(120, 70, 145, 35);

        //---- label2 ----
        label2.setText("Name");
        add(label2);
        label2.setBounds(new Rectangle(new Point(35, 75), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("Email");
        label3.setPreferredSize(new Dimension(100, 16));
        add(label3);
        label3.setBounds(new Rectangle(new Point(35, 130), label3.getPreferredSize()));
        add(textField2);
        textField2.setBounds(120, 130, 145, 35);

        //---- label4 ----
        label4.setText("Contact No.");
        label4.setPreferredSize(new Dimension(100, 16));
        add(label4);
        label4.setBounds(new Rectangle(new Point(35, 200), label4.getPreferredSize()));
        add(textField3);
        textField3.setBounds(120, 200, 145, 35);

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
        textField4.setBounds(120, 265, 145, 35);
        add(textField5);
        textField5.setBounds(380, 135, 215, 35);

        //---- label7 ----
        label7.setText("Additional Requests");
        label7.setPreferredSize(new Dimension(150, 16));
        add(label7);
        label7.setBounds(new Rectangle(new Point(35, 325), label7.getPreferredSize()));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textArea1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(35, 345, 440, 115);

        //---- button1 ----
        button1.setText("Submit");
        add(button1);
        button1.setBounds(510, 420, 100, 37);

        //---- button2 ----
        button2.setText("Clear All");
        add(button2);
        button2.setBounds(510, 365, 100, 37);

        //---- label8 ----
        label8.setText("seperate multiple values");
        label8.setFont(new Font("Segoe UI", Font.ITALIC, 11));
        add(label8);
        label8.setBounds(380, 95, 215, label8.getPreferredSize().height);

        //---- label9 ----
        label9.setText("with a comma");
        label9.setFont(new Font("Segoe UI", Font.ITALIC, 11));
        add(label9);
        label9.setBounds(380, 110, 215, 15);

        //---- label10 ----
        label10.setText("Date and Time");
        add(label10);
        label10.setBounds(385, 190, 105, label10.getPreferredSize().height);

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
    private JLabel label7;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JButton button1;
    private JButton button2;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
