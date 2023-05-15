/*
 * Created by JFormDesigner on Mon May 15 15:36:58 IST 2023
 */

package view;

import controller.TimelineController;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
        scrollPane1 = new JScrollPane();
        reservations = new JTable();
        deleteButton = new JButton();

        //======== this ========
        setPreferredSize(new Dimension(100, 800));
        setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 20));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing.
        border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER
        , javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font
        .BOLD ,12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (
        new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r"
        .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {400, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};

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

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(reservations);
        }
        add(scrollPane1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- deleteButton ----
        deleteButton.setText("Cancel Reservation");
        add(deleteButton, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 0, 0), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on


        deleteButton.addActionListener(e -> {
            int row = reservations.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Please select a row to delete");
            } else {
                int id = (int) reservations.getValueAt(row, 0);
                controller.deleteReservation(id);
            }
        });
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
    }

    public void populate() {

        DefaultTableModel model = controller.getTableData();

        if(model != null) {
            reservations.setModel(model);
        }
        else {
            model = new DefaultTableModel();
            model.addRow(new Object[]{"No reservations found"});
            reservations.setModel(new DefaultTableModel());
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - isuru Yahampath
    private JPanel panel1;
    private JLabel dateLabel;
    private JPanel hSpacer1;
    private JPanel hSpacer2;
    private JLabel clockLabel;
    private JScrollPane scrollPane1;
    private JTable reservations;
    private JButton deleteButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
