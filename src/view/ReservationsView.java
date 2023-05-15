/*
 * Created by JFormDesigner on Mon May 15 15:36:58 IST 2023
 */

package view;

import controller.TimelineController;
import model.Restaurant;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 * @author ASUS
 */
public class ReservationsView extends AbstractView {

    TimelineController controller;
    public ReservationsView() {

        controller = new TimelineController(this);
        initComponents();
        displayClock();
        populate();

    }

    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - isuru Yahampath
        panel1 = new JPanel();
        dateLabel = new JLabel();
        hSpacer1 = new JPanel(null);
        hSpacer2 = new JPanel(null);
        clockLabel = new JLabel();
        titleLabel = new JLabel();
        scrollPane1 = new JScrollPane();
        reservations = new JTable();
        panel3 = new JPanel();
        viewToggle = new JToggleButton();
        deleteButton = new JButton();

        //======== this ========
        setPreferredSize(new Dimension(500, 800));
        setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 20));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
        swing. border. EmptyBorder( 0, 0, 0, 0) , "", javax. swing. border
        . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069al\u006fg"
        ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder
        ( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
        .beans .PropertyChangeEvent e) {if ("\u0062or\u0064er" .equals (e .getPropertyName () )) throw new RuntimeException
        ( ); }} );
        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {400, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 50, 0, 100, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0E-4};

        //======== panel1 ========
        {
            panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));

            //---- dateLabel ----
            dateLabel.setFont(new Font("Segoe UI Light", Font.BOLD, 28));
            panel1.add(dateLabel);
            panel1.add(hSpacer1);
            panel1.add(hSpacer2);

            //---- clockLabel ----
            clockLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
            panel1.add(clockLabel);
        }
        add(panel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- titleLabel ----
        titleLabel.setText("Today's Reservations");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        add(titleLabel, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 0, 0), 0, 0));

        //======== scrollPane1 ========
        {

            //---- reservations ----
            reservations.setPreferredSize(new Dimension(300, 800));
            scrollPane1.setViewportView(reservations);
        }
        add(scrollPane1, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //======== panel3 ========
        {
            panel3.setLayout(new FlowLayout(FlowLayout.LEFT));

            //---- viewToggle ----
            viewToggle.setText("All reservations");
            panel3.add(viewToggle);

            //---- deleteButton ----
            deleteButton.setText("Cancel Reservation");
            panel3.add(deleteButton);
        }
        add(panel3, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 0, 0), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on


        //delete selected reservation
        deleteButton.addActionListener(e -> {
            int row = reservations.getSelectedRow();
            if (row == -1) {
                displayError("Please select a row to delete");
            } else {
                try {

                    int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this reservation?", "Cancel Reservation", JOptionPane.YES_NO_OPTION);
                    if(reply == 0) {
                        int id = Integer.parseInt((String) reservations.getValueAt(row, 0));
                        controller.deleteReservation(id);
                        displaySuccess("Reservation canceled successfully");
                        populate();
                    }
                }
                catch (Exception ex) {
                    displayError(ex.getMessage());
                }
            }
        });

        //toggle between all and today's reservations
        viewToggle.addActionListener(e-> {
            if(viewToggle.isSelected()) {
                viewToggle.setText("Today's reservations");
                titleLabel.setText("All Reservations");
                DefaultTableModel model = controller.fetchAll();
                if(model != null) {
                    reservations.setModel(model);
                }
            }
            else {
                viewToggle.setText("All reservations");
                titleLabel.setText("Today's Reservations");
                DefaultTableModel model = controller.fetch();
                if(model != null) {
                    reservations.setModel(model);
                }
            }
            resizeTable(reservations);
        });

    }

    //resize table columns to fit the data
    public void resizeTable(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width +1 , width);
            }
            if(width > 300)
                width=300;
            columnModel.getColumn(column).setPreferredWidth(width);
        }
        table.setRowHeight(30);


    }

    public void displayClock() {


        // Create a Timer to update the clock every second
        Timer timer = new Timer(1000, e -> {
            // Get the current time
            long currentTimeMillis = System.currentTimeMillis();
            java.util.Date date = new java.util.Date(currentTimeMillis);

            // Format the time as HH:mm:ss
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss");
            String formattedTime = sdf.format(date);

            // Update the clock label
            clockLabel.setText(formattedTime);

            dateLabel.setText(new SimpleDateFormat("dd MMMM yyyy").format(new Date()) + "  |  ");
        });
        timer.start();
        reservations.setSize(1000, 700);
    }

    public void populate() {

        DefaultTableModel model = controller.fetch();

        if(model != null) {
            reservations.setModel(model);
            reservations.getColumnModel().getColumn(6).setPreferredWidth(200);
            reservations.getColumnModel().getColumn(5).setPreferredWidth(250);
            reservations.getColumnModel().getColumn(1).setPreferredWidth(250);

            reservations.getColumnModel().getColumn(6).setResizable(true);
        }
        else {
            model = new DefaultTableModel();
            model.addRow(new Object[]{"No reservations found"});
            reservations.setModel(new DefaultTableModel());

        }

        Restaurant.init();

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - isuru Yahampath
    private JPanel panel1;
    private JLabel dateLabel;
    private JPanel hSpacer1;
    private JPanel hSpacer2;
    private JLabel clockLabel;
    private JLabel titleLabel;
    private JScrollPane scrollPane1;
    private JTable reservations;
    private JPanel panel3;
    private JToggleButton viewToggle;
    private JButton deleteButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
