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

    private JPanel navbar, content;
    public App() {
        super("SavourSync");
        setSize(1400, 1000);
        setResizable(false);

        //setting up ui themes
        UIManager.put("ButtonUI", "components.ButtonModernDark");

        setLocation(0, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //universal navbar. will not be changed.
        navbar = new JPanel();
        navbar.setBounds(0, 0, 1400, 50);
        navbar.setLayout(null);
        navbar.add(new NavBarView());


        add(navbar);

        //content panel, updated by the setView method to switch between pages.
        content = new JPanel();
        content.setBounds(0, 50, 1400, 950);
        add(content);

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
