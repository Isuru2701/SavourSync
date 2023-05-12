package view;

import controller.NavBarController;
import model.Navigation;

import javax.swing.*;

public class NavBarView extends AbstractView{

    public NavBarView() {
        setController(new NavBarController());
    }

    @Override
    public void initComponents() {

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        JButton settingsButton = new JButton("Dashboard");
        settingsButton.addActionListener(e -> {
            Navigation.navigate(new DashboardView());
        });
        add(settingsButton);

        JButton reportButton = new JButton("Report");
        reportButton.addActionListener(e -> {
            Navigation.navigate(new ReportView());
        });
        add(reportButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            System.exit(0);
        });
        add(logoutButton);

    }
}
