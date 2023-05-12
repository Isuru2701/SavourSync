package view;

import controller.NavBarController;

import javax.swing.*;

public class NavBarView extends AbstractView{

    private NavBarController controller;
    public NavBarView() {
        setController(new NavBarController());
        initComponents();
    }

    @Override
    public void initComponents() {

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        JButton dashboardButton = new JButton("Dashboard");
        dashboardButton.addActionListener(e -> {
            controller.navigate(this, new DashboardView());
        });
        add(dashboardButton);

        JButton reportButton = new JButton("Report");
        reportButton.addActionListener(e -> {

        });
        add(reportButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            controller.kill();
        });
        add(logoutButton);

    }
}