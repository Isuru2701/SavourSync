package view;

import controller.*;
import javax.swing.*;

public abstract class AbstractView extends JPanel {

    private AbstractController controller;
    public void setController(AbstractController controller){
        this.controller = controller;
    }
}
