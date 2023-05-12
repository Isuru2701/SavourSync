package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * This class is the main view of the application.
 * It is responsible for displaying the navigation bar and the current view.
 * It is also responsible for switching between views.
 * contains some minimal functionality for the window.
 */
public class App extends JFrame {

    public App() {
        super("SavourSync");
        setLayout(null);
        setSize(1000, 700);
        setResizable(true);

        //setting up ui themes
        UIManager.put("ButtonUI", "components.ButtonModernDark");

        setLocation(50, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //home page
        setContentPane(new DashboardView());

        setVisible(true);
    }

    public void setView(AbstractView view) {
        setContentPane(view);
        revalidate();
        repaint();
    }
}
