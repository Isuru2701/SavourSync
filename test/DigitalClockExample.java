import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class DigitalClockExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Digital Clock");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Create a JLabel to display the time
            JLabel clockLabel = new JLabel();
            frame.add(clockLabel);

            // Create a Timer to update the clock every second
            javax.swing.Timer timer = new javax.swing.Timer(1000, e -> {
                // Get the current time
                long currentTimeMillis = System.currentTimeMillis();
                java.util.Date date = new java.util.Date(currentTimeMillis);

                // Format the time as HH:mm:ss
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss");
                String formattedTime = sdf.format(date);

                // Update the clock label
                clockLabel.setText(formattedTime);
            });
            timer.start();

            frame.setBounds(100, 100, 200, 100);
            frame.setVisible(true);
        });
    }
}
