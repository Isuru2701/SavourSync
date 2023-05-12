package controller;
import view.AbstractView;
import view.App;

import javax.swing.*;
import java.awt.*;

public class NavBarController extends AbstractController{

    private App currentApp;
    public NavBarController(App app) {
        currentApp = app;
    }

    public void navigate(AbstractView nextView) {
        currentApp.setView(nextView);
    }

    public void kill() {
        System.exit(0);
    }
}
