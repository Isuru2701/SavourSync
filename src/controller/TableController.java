package controller;

import view.TableForm;
import model.Table;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TableController {

    private TableForm view;
    private Table model;

    private List<Table> available = new ArrayList<Table>();


    public TableController(TableForm view){
        this.view = view;
    }

    public void add(int seats){
        model = new Table(seats);

            model.save();
            JOptionPane.showMessageDialog(null, "Table added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public List<Table> getList(){
        available = Table.getAll();
        return available;
    }

    public void delete(int id){
        try {
            Table.delete(id);
            view.displaySuccess("Table deleted successfully");
        }
        catch(Exception e) {
            view.displayError("Deletion failed. Is there a reservation for this table?");
        }
    }

}
