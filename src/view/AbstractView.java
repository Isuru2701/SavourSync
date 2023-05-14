package view;

import controller.*;
import javax.swing.*;

public abstract class AbstractView extends JPanel {

    private AbstractController controller;
    public void setController(AbstractController controller){
        this.controller = controller;
    }

    /**
     * This method is used to initialize the components of the view.
     */
    protected abstract void initComponents();

    public void displayError(String txt) {
        JOptionPane.showMessageDialog(this, txt, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void displaySuccess(String txt) {
        JOptionPane.showMessageDialog(this, txt, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

}
