/*
 * Created by JFormDesigner on Sat May 13 06:21:51 IST 2023
 */

package view;

import controller.ReserveController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import java.time.Month;
import java.time.Year;

import model.Reservation;
import model.Table;

public class ReserveView extends AbstractView {
    private ReserveController controller;
    public ReserveView() {

        controller = new ReserveController(this);
        initComponents();

        populate();
    }

    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - isuru Yahampath
        label1 = new JLabel();
        nameField = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        emailField = new JTextField();
        label4 = new JLabel();
        phoneField = new JTextField();
        label5 = new JLabel();
        label7 = new JLabel();
        scrollPane1 = new JScrollPane();
        requestsArea = new JTextArea();
        submitButton = new JButton();
        label10 = new JLabel();
        yearBox = new JComboBox();
        label11 = new JLabel();
        hourBox = new JComboBox();
        minuteBox = new JComboBox();
        tableBox = new JComboBox();
        monthBox = new JComboBox();
        dayBox = new JComboBox();

        //======== this ========
        setPreferredSize(new Dimension(1000, 750));
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax
        . swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "" , javax. swing
        .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .
        Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .red
        ) , getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override
        public void propertyChange (java . beans. PropertyChangeEvent e) { if( "bord\u0065r" .equals ( e. getPropertyName (
        ) ) )throw new RuntimeException( ) ;} } );
        setLayout(null);

        //---- label1 ----
        label1.setText("Place Reservation");
        label1.setPreferredSize(new Dimension(150, 16));
        label1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        add(label1);
        label1.setBounds(25, 30, 190, 45);
        add(nameField);
        nameField.setBounds(165, 110, 155, 50);

        //---- label2 ----
        label2.setText("Name");
        add(label2);
        label2.setBounds(35, 110, 55, 50);

        //---- label3 ----
        label3.setText("Email");
        label3.setPreferredSize(new Dimension(100, 16));
        add(label3);
        label3.setBounds(35, 165, 125, 50);
        add(emailField);
        emailField.setBounds(165, 170, 155, 50);

        //---- label4 ----
        label4.setText("Contact No.");
        label4.setPreferredSize(new Dimension(100, 16));
        add(label4);
        label4.setBounds(35, 235, 125, 50);
        add(phoneField);
        phoneField.setBounds(165, 240, 155, 50);

        //---- label5 ----
        label5.setText("Table Number");
        label5.setPreferredSize(new Dimension(100, 16));
        add(label5);
        label5.setBounds(390, 60, 110, 50);

        //---- label7 ----
        label7.setText("Additional Requests");
        label7.setPreferredSize(new Dimension(150, 16));
        add(label7);
        label7.setBounds(30, 375, 205, 41);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(requestsArea);
        }
        add(scrollPane1);
        scrollPane1.setBounds(30, 425, 495, 140);

        //---- submitButton ----
        submitButton.setText("Submit");
        add(submitButton);
        submitButton.setBounds(580, 465, 155, 62);

        //---- label10 ----
        label10.setText("Date");
        add(label10);
        label10.setBounds(390, 120, 115, 40);
        add(yearBox);
        yearBox.setBounds(640, 160, 125, 45);

        //---- label11 ----
        label11.setText("Time");
        add(label11);
        label11.setBounds(380, 225, 135, 50);
        add(hourBox);
        hourBox.setBounds(380, 275, 130, 55);
        add(minuteBox);
        minuteBox.setBounds(515, 275, 130, 55);
        add(tableBox);
        tableBox.setBounds(510, 65, 125, 45);
        add(monthBox);
        monthBox.setBounds(510, 160, 125, 45);
        add(dayBox);
        dayBox.setBounds(380, 160, 125, 45);

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

        submitButton.addActionListener(e -> {

            try {
                String datetime = yearBox.getSelectedItem().toString() + "-" + (monthBox.getSelectedIndex() + 1) + "-" + dayBox.getSelectedItem().toString() + " " + hourBox.getSelectedItem().toString() + ":" + minuteBox.getSelectedItem().toString();

                controller.validate(nameField.getText(), emailField.getText(), phoneField.getText(), tableBox.getSelectedItem().toString(), datetime, requestsArea.getText());
            }
            catch (Exception ex) {
                displayError(ex.getMessage());
            }
        });
    }

    //used to fill the comboBoxes with appropriate data
    private void populate() {
        //Days 1 - 31
        for(int i = 1; i <= 31; ++i) {
            dayBox.addItem(i);
        }

        //Months jan to feb, using the Month enum
        for(Month m : Month.values()){
            monthBox.addItem(m.toString().toLowerCase());
        }

        //place reservations upto 5 years from now. A reasonable span
        for(int i = Year.now().getValue(); i <= Year.now().plusYears(5).getValue(); ++i) {
            yearBox.addItem(i);
        }

        //hours
        for(int i = 0; i <= 23; ++i) {
            hourBox.addItem(i);
        }

        //minutes
        for(int i = 0; i<=59; ++i) {
            minuteBox.addItem(i);
        }

        //getting and plugging in AVAILABLE tables' ids
        //add a empty value first
        tableBox.addItem("");
        try {
            List<Integer> available = Table.getAvailable();
            if (!available.isEmpty()) {
                for (int i : Table.getAvailable()) {
                    tableBox.addItem(i);
                }
            }
        }
        catch (Exception e){
            displayError("Error getting available tables. Is the database online?");
        }




    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - isuru Yahampath
    private JLabel label1;
    private JTextField nameField;
    private JLabel label2;
    private JLabel label3;
    private JTextField emailField;
    private JLabel label4;
    private JTextField phoneField;
    private JLabel label5;
    private JLabel label7;
    private JScrollPane scrollPane1;
    private JTextArea requestsArea;
    private JButton submitButton;
    private JLabel label10;
    private JComboBox yearBox;
    private JLabel label11;
    private JComboBox hourBox;
    private JComboBox minuteBox;
    private JComboBox tableBox;
    private JComboBox monthBox;
    private JComboBox dayBox;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on


}
