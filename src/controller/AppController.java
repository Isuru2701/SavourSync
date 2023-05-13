package controller;

import view.AbstractView;
import view.App;
public class AppController {

    private App app;


    public AppController(App app) {
        this.app = app;

    }

    public void setView(AbstractView view) {
        app.getContentPanel().removeAll();
        app.getContentPanel().add(view);
        app.getContentPanel().revalidate();
        app.getContentPanel().repaint();
    }

    public void kill() {
        app.dispose();
        System.exit(0);
    }




}
