package controller;

import model.DBConn;
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

    public TimelineController(ReservationsView view) {
        this.view = view;
    }
    public DefaultTableModel getTableData() {

        try{

            DefaultTableModel model = new DefaultTableModel() {
                @Override//cells cant be edited
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            String[] columns = {"ID", "Time", "Client", "Table", "Status", "Requests"};
            model.setColumnIdentifiers(columns);

            DBConn db = new DBConn();

            String query = "SELECT reservation.id, start_datetime, requests, status, client.name AS name,  `table`.id AS tableId FROM reservation\n" +
                    "                    INNER JOIN client ON reservation.client_id = client.id\n" +
                    "                    INNER JOIN `table`\n" +
                    "                    ON reservation.table_id = `table`.id\n" +
                    "                    WHERE DATE(start_datetime) = CURDATE();";

            //gets: start_datetime, requests, status, name, tableId for TODAY

            ResultSet reply = db.query(query);
            if(reply == null) return null;



            //yyyy-MM-dd HH:mm:ss
            while(reply.next()) {
                String[] row = new String[6];
                row[0] = reply.getString("id");
                row[1] = reply.getString("start_datetime").substring(11,16);
                row[2] = reply.getString("name");
                row[3] = reply.getString("tableId");
                row[4] = reply.getString("status");
                row[5] = reply.getString("requests");
                model.addRow(row);
            }
            return model;
        }
        catch(Exception e){
            view.displayError(e.getMessage());
        }
        return null;
    }

    public void deleteReservation(int id) {
        try {
            DBConn db = new DBConn();
            String query = "UPDATE reservation SET status = 'CANCELED' WHERE id = ?;";
            db.write(query);
        } catch (Exception e) {
            view.displayError("Failed to connect to the database");
        }
    }
}
