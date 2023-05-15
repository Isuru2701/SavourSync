/*
 * Created by JFormDesigner on Sun May 14 17:01:55 IST 2023
 */

package view;

import controller.TableController;
import model.Table;

import java.awt.*;
import javax.swing.*;


/**
 * @author ASUS
 */
public class TableForm extends AbstractView {

    private TableController controller;
    public TableForm() {
        initComponents();
        controller = new TableController(this);
        populate();
    }

    public void initComponents() {
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
        deleteButtons = new JPanel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();

        //======== this ========
        setPreferredSize(new Dimension(500, 500));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder( 0
        , 0, 0, 0) , "", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
        , new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,
         getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
        setLayout(null);

        //---- label1 ----
        label1.setText("Manage Tables");
        add(label1);
        label1.setBounds(15, 10, 130, 30);

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

            //======== deleteButtons ========
            {
                deleteButtons.setLayout(new BoxLayout(deleteButtons, BoxLayout.Y_AXIS));
            }
            scrollPane4.setViewportView(deleteButtons);
        }
        add(scrollPane4);
        scrollPane4.setBounds(340, 70, 100, 265);

        //---- label4 ----
        label4.setText("Table ID");
        add(label4);
        label4.setBounds(15, 50, 90, label4.getPreferredSize().height);

        //---- label5 ----
        label5.setText("Seats");
        add(label5);
        label5.setBounds(125, 50, 75, label5.getPreferredSize().height);

        //---- label6 ----
        label6.setText("Status");
        add(label6);
        label6.setBounds(235, 50, 80, label6.getPreferredSize().height);

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
                populate(); //acts as a refresh

                
            }
        });

    }

    public void populate() {
        DefaultListModel<Integer> ids = new DefaultListModel<>();
        DefaultListModel<Integer> seats = new DefaultListModel<>();
        DefaultListModel<String> availability = new DefaultListModel<>();

        deleteButtons.removeAll();

        for(Table t : controller.getList()) {
            ids.addElement(t.getId());
            seats.addElement(t.getSeats());
            availability.addElement(t.isAvailable() ? "Available" : "Not Available");

            JButton button = new JButton("Delete");
            button.addActionListener(e -> {
                controller.delete(t.getId());
                JButton b = (JButton) e.getSource();
                deleteButtons.remove(b);
                populate();
            });

            deleteButtons.add(button);
        }
        idList.setModel(ids);
        seatsList.setModel(seats);
        availableList.setModel(availability);
        deleteButtons.revalidate();
        deleteButtons.repaint();

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
    private JPanel deleteButtons;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
