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
        label7 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        button1 = new JButton();
        button2 = new JButton();
        label10 = new JLabel();
        comboBox3 = new JComboBox();
        label11 = new JLabel();
        comboBox4 = new JComboBox();
        comboBox5 = new JComboBox();
        toggleButton1 = new JToggleButton();
        comboBox6 = new JComboBox();
        comboBox7 = new JComboBox();
        comboBox8 = new JComboBox();

        //======== this ========
        setPreferredSize(new Dimension(1000, 750));
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(
        0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder
        .BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt.Color.
        red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.
        beans.PropertyChangeEvent e){if("\u0062ord\u0065r".equals(e.getPropertyName()))throw new RuntimeException();}});
        setLayout(null);

        //---- label1 ----
        label1.setText("Place Reservation");
        label1.setPreferredSize(new Dimension(150, 16));
        add(label1);
        label1.setBounds(new Rectangle(new Point(25, 30), label1.getPreferredSize()));
        add(textField1);
        textField1.setBounds(165, 75, 155, 50);

        //---- label2 ----
        label2.setText("Name");
        add(label2);
        label2.setBounds(35, 75, 55, 50);

        //---- label3 ----
        label3.setText("Email");
        label3.setPreferredSize(new Dimension(100, 16));
        add(label3);
        label3.setBounds(35, 130, 125, 50);
        add(textField2);
        textField2.setBounds(165, 135, 155, 50);

        //---- label4 ----
        label4.setText("Contact No.");
        label4.setPreferredSize(new Dimension(100, 16));
        add(label4);
        label4.setBounds(35, 200, 125, 50);
        add(textField3);
        textField3.setBounds(165, 205, 155, 50);

        //---- label5 ----
        label5.setText("Table Number");
        label5.setPreferredSize(new Dimension(100, 16));
        add(label5);
        label5.setBounds(390, 60, 110, 50);

        //---- label6 ----
        label6.setText("Seats");
        label6.setPreferredSize(new Dimension(100, 16));
        add(label6);
        label6.setBounds(35, 265, 125, 50);
        add(textField4);
        textField4.setBounds(165, 270, 155, 50);

        //---- label7 ----
        label7.setText("Additional Requests");
        label7.setPreferredSize(new Dimension(150, 16));
        add(label7);
        label7.setBounds(30, 375, 205, 41);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textArea1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(30, 425, 495, 140);

        //---- button1 ----
        button1.setText("Submit");
        add(button1);
        button1.setBounds(590, 500, 155, 62);

        //---- button2 ----
        button2.setText("Clear All");
        add(button2);
        button2.setBounds(590, 430, 155, 62);

        //---- label10 ----
        label10.setText("Date");
        add(label10);
        label10.setBounds(390, 120, 115, 40);
        add(comboBox3);
        comboBox3.setBounds(640, 160, 125, 45);

        //---- label11 ----
        label11.setText("Time");
        add(label11);
        label11.setBounds(380, 225, 135, 50);
        add(comboBox4);
        comboBox4.setBounds(380, 275, 130, 55);
        add(comboBox5);
        comboBox5.setBounds(515, 275, 130, 55);

        //---- toggleButton1 ----
        toggleButton1.setText("text");
        add(toggleButton1);
        toggleButton1.setBounds(650, 275, 105, 55);
        add(comboBox6);
        comboBox6.setBounds(510, 65, 125, 45);
        add(comboBox7);
        comboBox7.setBounds(510, 160, 125, 45);
        add(comboBox8);
        comboBox8.setBounds(380, 160, 125, 45);

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
    private JLabel label7;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JButton button1;
    private JButton button2;
    private JLabel label10;
    private JComboBox comboBox3;
    private JLabel label11;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JToggleButton toggleButton1;
    private JComboBox comboBox6;
    private JComboBox comboBox7;
    private JComboBox comboBox8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
