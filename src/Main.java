import view.*;
import controller.AppController;
import view.App;

public class Main {

    private static AppController controller;
    private static App app;

    public static void main(String[] args) {
        app = new App();
        controller = new AppController(app);

    }
}
