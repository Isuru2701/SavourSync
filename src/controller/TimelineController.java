package controller;

import model.DBConn;
import model.Reservation;
import view.ReservationsView;

import javax.swing.table.DefaultTableModel;
import java.io.SyncFailedException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;


/**
 * handles fetching aggregate data from the db to fill the table in ReservationsView
 */
public class TimelineController extends AbstractController{

    ReservationsView view;
    Reservation model;

    public TimelineController(ReservationsView view) {
        this.view = view;
        this.model = new Reservation();
    }

    public void deleteReservation(int id) {
        model.deleteReservation(id);
    }

    public DefaultTableModel fetch() {
        return model.getTableData();
    }

    public DefaultTableModel fetchAll(){
        return model.getAll();
    }
}
