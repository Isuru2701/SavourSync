package view;

import controller.NavBarController;
import model.Navigation;

import javax.swing.*;

public class NavBarView extends AbstractView{

    public NavBarView() {
        setController(new NavBarController());
        initComponents();
    }

    @Override
    public void initComponents() {

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        JButton dashboardButton = new JButton("Dashboard");
        dashboardButton.addActionListener(e -> {
            ;
        });
        add(dashboardButton);

        JButton reportButton = new JButton("Report");
        reportButton.addActionListener(e -> {

        });
        add(reportButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            System.exit(0);
        });
        add(logoutButton);

    }
}
