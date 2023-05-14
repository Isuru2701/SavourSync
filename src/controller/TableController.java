package controller;

import view.TableForm;
import model.Table;

import javax.swing.*;

public class TableController {

    private TableForm view;
    private Table model;

    public TableController(TableForm view){
        this.view = view;
    }

    public void add(int seats){
        model = new Table(seats);

            model.save();
            JOptionPane.showMessageDialog(null, "Table added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

}
