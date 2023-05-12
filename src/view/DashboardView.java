package view;
import java.awt.*;
import controller.DashboardController;

import javax.swing.*;

public class DashboardView extends AbstractView {


    private DashboardController controller;

    public DashboardView() {
        controller = new DashboardController();
        initComponents();

    }


     public void initComponents() {
        add(new NavBarView());
        add(new DashboardContentView());
    }


}
