package controller;
import view.AbstractView;
import view.App;
import view.DashboardView;

import javax.swing.*;

public class NavBarController extends AbstractController{

    public void navigate(AbstractView currentView, AbstractView nextView) {
        App app = (App) SwingUtilities.getRoot(currentView);
        app.setView(nextView);

    }
    public void kill() {
        System.exit(0);
    }
}
