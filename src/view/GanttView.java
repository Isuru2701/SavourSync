/*
 * Created by JFormDesigner on Sun May 14 17:22:34 IST 2023
 */

package view;

import java.awt.*;
import javax.swing.*;

/**
 * @author ASUS
 */
public class GanttView extends AbstractView {
    public GanttView() {
        initComponents();
    }

    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - isuru Yahampath
        reservationTree = new JPanel();
        dateLabel = new JLabel();
        hourLabel = new JLabel();
        minuteLabel = new JLabel();
        label1 = new JLabel();

        //======== reservationTree ========
        {
            reservationTree.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing
            .border.EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border.TitledBorder
            .CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.
            awt.Font.BOLD,12),java.awt.Color.red),reservationTree. getBorder()))
            ;reservationTree. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
            ){if("bord\u0065r".equals(e.getPropertyName()))throw new RuntimeException();}})
            ;
            reservationTree.setLayout(new BoxLayout(reservationTree, BoxLayout.Y_AXIS));

            //---- dateLabel ----
            dateLabel.setText("Date");
            dateLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
            reservationTree.add(dateLabel);

            //---- hourLabel ----
            hourLabel.setText("Hour");
            hourLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
            reservationTree.add(hourLabel);

            //---- minuteLabel ----
            minuteLabel.setText("Minute");
            minuteLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
            reservationTree.add(minuteLabel);

            //---- label1 ----
            label1.setText("TESTING");
            reservationTree.add(label1);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    
    public void timer() {
        Timer timer = new Timer(1000, e-> {
            long currentTimeMillis = System.currentTimeMillis();
            java.util.Date date = new java.util.Date(currentTimeMillis);
            java.text.SimpleDateFormat timeFormat = new java.text.SimpleDateFormat("HH:mm");
            java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
            String formattedTime = timeFormat.format(date);
            String formattedDate = dateFormat.format(date);
            hourLabel.setText(formattedTime.substring(0, 2));
            minuteLabel.setText(formattedTime.substring(3, 5));
            dateLabel.setText(formattedDate);
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - isuru Yahampath
    private JPanel reservationTree;
    private JLabel dateLabel;
    private JLabel hourLabel;
    private JLabel minuteLabel;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
