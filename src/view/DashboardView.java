package view;
import controller.DashboardController;

import javax.swing.*;

public class DashboardView extends AbstractView {


    private DashboardController controller;
    public DashboardView() {
        controller = new DashboardController();
        initComponents();

    }

    @Override
    public void initComponents() {
        //add navigation bar
        add(new NavBarView());
    }


}
