package view;
import controller.DashboardController;
import model.Navigation;

import javax.swing.*;

public class DashboardView extends AbstractView {


    private DashboardController controller;
    public DashboardView() {
        controller = new DashboardController();
        initComponents();

    }

    @Override
    public void initComponents() {
        add(new NavBarView());
    }


}
