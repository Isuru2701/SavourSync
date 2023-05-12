package view;

import controller.NavBarController;

import javax.swing.*;

/**
 * class for the navigation bar that displays at the top of every view
 */
public class NavBarView extends AbstractView{

    private NavBarController controller;
    public NavBarView() {
        controller = new NavBarController();
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
            controller.navigate(this, new ReportView());
        });
        add(reportButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            controller.kill();
        });
        add(logoutButton);

    }
}
