package view;

import controller.NavBarController;
import view.*;

import javax.swing.*;

public class App extends JFrame {

    public App() {
        super("SavourSync");
        setSize(900, 600);
        setResizable(false);
        setVisible(true);
        setLocation(100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //home page
        setContentPane(new DashboardView());
    }

    public void setView(AbstractView view) {
        setContentPane(view);
        revalidate();
        repaint();
    }
}
