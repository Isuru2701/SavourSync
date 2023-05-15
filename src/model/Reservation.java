package model;


import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Reservation
 * <br>
 * This class is used to represent a reservation
 */
public class Reservation {

    private int clientId, tableId;
    private String requests,datetime, status;

    public Reservation(){

    }

    public Reservation(int clientId, int tableId, String datetime, String requests) {
        this.clientId = clientId;
        this.tableId = tableId;
        this.datetime = datetime;
        this.requests = requests;
        this.status = "pending";
    }

    /**
     * converts the string to LocalDateTime first
     * @return LocalDateTime
     */
    public LocalDateTime getDateTime() {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
            return LocalDateTime.parse(datetime, formatter);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    public String getRequests() {
        return requests;
    }

    public void save() throws RuntimeException{
        try {
            DBConn db = new DBConn();
            String query = "INSERT INTO reservation (client_id, table_id, start_datetime, requests, status) VALUES (?, ?, ?, ?, ?)";
            db.write(query, clientId, tableId, datetime, requests, status);
            db.kill();


        }
        catch(RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public static boolean checkIfBooked(Integer no, String datetime) {
        try{
            DBConn db = new DBConn();
            String query = "SELECT * FROM reservation WHERE table_id = ? AND start_datetime = ?";
            ResultSet reply = db.query(query, no, datetime);
            if(reply.next()) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return false;
    }

    /**
     * GETS ALL THE RESERVATIONS FOR TODAY
     * @return DefaultTableModel
     */
    public DefaultTableModel getTableData() {

        try{

            DefaultTableModel model = new DefaultTableModel() {
                @Override//cells cant be edited
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            String[] columns = {"ID","Date", "Time", "Client", "Table", "Status", "Requests"};
            model.setColumnIdentifiers(columns);

            DBConn db = new DBConn();

            String query = "SELECT reservation.id, start_datetime, requests, status, client.name AS name,  `table`.id AS tableId FROM reservation\n" +
                    "                    INNER JOIN client ON reservation.client_id = client.id\n" +
                    "                    INNER JOIN `table`\n" +
                    "                    ON reservation.table_id = `table`.id\n" +
                    "                    WHERE DATE(start_datetime) = CURDATE()" +
                    "                    ORDER BY start_datetime ASC;";

            //gets: start_datetime, requests, status, name, tableId for TODAY

            ResultSet reply = db.query(query);
            if(reply == null) return null;



            //yyyy-MM-dd HH:mm:ss
            return getDefaultTableModel(model, reply);
        }
        catch(Exception e){
            throw new RuntimeException();
        }
    }

    public void deleteReservation(int id) {
        try {

            DBConn db = new DBConn();

            //add this reservation to canceled first.
            String query = "INSERT INTO canceled (client_id, table_id, start_datetime) SELECT client_id, table_id, start_datetime FROM reservation WHERE id = ?;";
            db.write(query, id);

            query = "DELETE FROM reservation WHERE id = ?;";
            db.write(query, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    public DefaultTableModel getAll(){
        try{

            String[] columns = {"ID","Date", "Time", "Client", "Table", "Status", "Requests"};

            DefaultTableModel model = new DefaultTableModel() {
                @Override//cells cant be edited
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
                DBConn db = new DBConn();
            String query = "SELECT reservation.id, start_datetime, requests, status, client.name AS name,  `table`.id AS tableId FROM reservation\n" +
                    "                    INNER JOIN client ON reservation.client_id = client.id\n" +
                    "                    INNER JOIN `table`\n" +
                    "                    ON reservation.table_id = `table`.id" +
                    "                    ORDER BY start_datetime ";

            ResultSet reply = db.query(query);
            if(reply == null) return null;
            model.setColumnIdentifiers(columns);

            //yyyy-MM-dd HH:mm:ss
            return getDefaultTableModel(model, reply);

        }
        catch (Exception e){
            throw new RuntimeException();
        }
    }

    private DefaultTableModel getDefaultTableModel(DefaultTableModel model, ResultSet reply) throws SQLException {
        while(reply.next()) {
            String[] row = new String[7];
            row[0] = reply.getString("id");
            row[1] = reply.getString("start_datetime").substring(0, 11);
            row[2] = reply.getString("start_datetime").substring(11,16);
            row[3] = reply.getString("name");
            row[4] = reply.getString("tableId");
            row[5] = reply.getString("status");
            row[6] = reply.getString("requests");
            model.addRow(row);
        }
        return model;
    }

    public static List<Reservation> getResultSet(){
        try{
            List<Reservation> reservations = new ArrayList<>();
            DBConn db = new DBConn();
            String query = "SELECT * FROM reservation;";
            ResultSet reply =  db.query(query);
            while(reply.next()){
                reservations.add(new Reservation(reply.getInt("client_id"), reply.getInt("table_id"), reply.getString("start_datetime"), reply.getString("requests")));
            }

            return reservations;
        }
        catch(Exception e){
            throw new RuntimeException();
        }

    }

    public void setFulFilled(int id) {
        try {
            DBConn db = new DBConn();
            String query = "UPDATE reservation SET status = 'FULFILLED' WHERE id = ?";
            status = "FULFILLED";
            db.write(query, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }


}
