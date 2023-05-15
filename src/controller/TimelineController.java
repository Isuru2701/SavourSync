package controller;

import model.DBConn;
import view.ReservationsView;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;


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

            DefaultTableModel model = new DefaultTableModel();
            String[] columns = {"Date", "Time", "Client", "Table", "Status", "Requests"};
            model.setColumnIdentifiers(columns);

            DBConn db = new DBConn();
            String query = "SELECT start_datetime, requests, status,client.name AS name, `Table`.id AS tableId FROM reservation INNER JOIN client ON reservation.client_id = client.id INNER JOIN `table` ON reservation.table_id = `table`.id;";

            //gets: start_datetime, requests, status, name, tableId

            ResultSet reply = db.query(query);
            while(reply.next()) {
                String[] row = new String[6];
                row[0] = reply.getString("start_datetime");
                row[1] = reply.getString("start_datetime");
                row[2] = reply.getString("name");
                row[3] = reply.getString("tableId");
                row[4] = reply.getString("status");
                row[5] = reply.getString("requests");
                model.addRow(row);
            }
            return model;
        }
        catch(Exception e){
            view.displayError("Failed to connect to the database");
        }
        return null;
    }
}
