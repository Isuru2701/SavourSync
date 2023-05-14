/*
 * Created by JFormDesigner on Sun May 14 17:01:55 IST 2023
 */

package view;

import controller.TableController;

import java.awt.*;
import javax.swing.*;

/**
 * @author ASUS
 */
public class TableForm extends JPanel {

    private TableController controller;
    public TableForm() {
        initComponents();
        controller = new TableController(this);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - isuru Yahampath
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        seatsField = new JTextField();
        scrollPane1 = new JScrollPane();
        idList = new JList();
        addButton = new JButton();
        scrollPane2 = new JScrollPane();
        seatsList = new JList();
        scrollPane3 = new JScrollPane();
        availableList = new JList();
        scrollPane4 = new JScrollPane();
        deleteButton = new JList();
        refreshButton = new JButton();

        //======== this ========
        setPreferredSize(new Dimension(500, 500));
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder ( 0
        , 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM
        , new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .red ) ,
         getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
        ) { if( "bord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
        setLayout(null);

        //---- label1 ----
        label1.setText("Manage Tables");
        add(label1);
        label1.setBounds(15, 30, 130, 30);

        //---- label2 ----
        label2.setText("Add a table");
        add(label2);
        label2.setBounds(10, 350, 110, 36);

        //---- label3 ----
        label3.setText("Number of seats");
        add(label3);
        label3.setBounds(110, 350, 122, 41);
        add(seatsField);
        seatsField.setBounds(210, 350, 89, 42);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(idList);
        }
        add(scrollPane1);
        scrollPane1.setBounds(10, 70, 100, 265);

        //---- addButton ----
        addButton.setText("Add");
        add(addButton);
        addButton.setBounds(305, 350, 97, 42);

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(seatsList);
        }
        add(scrollPane2);
        scrollPane2.setBounds(120, 70, 100, 265);

        //======== scrollPane3 ========
        {
            scrollPane3.setViewportView(availableList);
        }
        add(scrollPane3);
        scrollPane3.setBounds(230, 70, 100, 265);

        //======== scrollPane4 ========
        {
            scrollPane4.setViewportView(deleteButton);
        }
        add(scrollPane4);
        scrollPane4.setBounds(340, 70, 100, 265);

        //---- refreshButton ----
        refreshButton.setText("Refresh");
        add(refreshButton);
        refreshButton.setBounds(new Rectangle(new Point(155, 35), refreshButton.getPreferredSize()));

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


        //button for adding a table
        addButton.addActionListener(e -> {
            if(seatsField.getText().isEmpty()){
                JOptionPane.showMessageDialog(this,"Please enter the number of seats");
            }
            else if (!seatsField.getText().matches(".*\\d.*")) {
                    JOptionPane.showMessageDialog(this,"Please enter a valid number");

            }
            else {
                int seats = Integer.parseInt(seatsField.getText());
                controller.add(seats);
            }
        });

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - isuru Yahampath
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField seatsField;
    private JScrollPane scrollPane1;
    private JList idList;
    private JButton addButton;
    private JScrollPane scrollPane2;
    private JList seatsList;
    private JScrollPane scrollPane3;
    private JList availableList;
    private JScrollPane scrollPane4;
    private JList deleteButton;
    private JButton refreshButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
