package view;

import javax.swing.*;

/**
 * This class is the main view of the application.
 * It is responsible for displaying the navigation bar and the current view.
 * It is also responsible for switching between views.
 * contains some minimal functionality for the window.
 */
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
