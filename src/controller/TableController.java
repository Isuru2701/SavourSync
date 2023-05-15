package controller;

import view.TableForm;
import model.Table;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TableController {

    private TableForm view;
    private Table model;

    private List<Integer> available = new ArrayList<Integer>();


    public TableController(TableForm view){
        this.view = view;
    }

    public void add(int seats){
        model = new Table(seats);

            model.save();
            JOptionPane.showMessageDialog(null, "Table added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void getList(){
        available = Table.getAvailable();
    }

}
