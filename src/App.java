
import view.*;

import javax.swing.*;

public class App extends JFrame {

    public App() {
        super("SavourSync");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        //home page
        setContentPane(new DashboardView());
    }

    public void setView(AbstractView view) {
        setContentPane(view);
        revalidate();
        repaint();
    }
}
