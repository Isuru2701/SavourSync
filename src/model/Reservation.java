package model;


import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Class Reservation
 * <br>
 * This class is used to represent a reservation
 */
public class Reservation {

    private int id, clientId, tableId;
    private String requests,datetime, status;

    public Reservation(){

    }

    public Reservation(int clientId, int tableId, String datetime, String requests) {
        this.clientId = clientId;
        this.tableId = tableId;
        this.datetime = datetime;
        this.requests = requests;
        this.status = "PENDING";
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

    /**
     * check if there is a reservation for this table at the given time, AND for an hour after
     * @param no table number
     * @param datetime datetime as a STRING
     * @return boolean
     */
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

    private static boolean hasOverlap(Integer no, String datetime) {
        List<Reservation> rList = getResultSet();
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-M-dd HH:m");
        try {
             date = LocalDateTime.from(dtf.parse(datetime));
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        for(Reservation res : rList) {
            if(res.tableId == no) {
                System.out.println(res.clientId + " " + res.tableId);
                //for the same table,
                //if the datetime is the same, or if the datetime is within an hour of the reservation
                //an overlap is occurring
                //TODO

                System.out.println(datetime);
                //yyyy-MM-dd HH:mm
                //datetime equal, if above, check after, if below, check before
                if(res.getDateTime().equals(LocalDateTime.parse(datetime)) ||
                        (date.plusHours(1).isAfter(res.getDateTime()) && date.plusHours(1).isBefore(res.getDateTime().plusHours(1))) ||
                        (res.getDateTime().isAfter(date)) && res.getDateTime().isBefore(date.plusHours(1))) {
                    return true;
                }
            }
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

    public String getStatus() {
        return status;
    }

    public void deleteReservation(int id) {
        try {

            DBConn db = new DBConn();

                //add this reservation to canceled first.
                String query = "INSERT INTO canceled (client_id, table_id, start_datetime) SELECT client_id, table_id, start_datetime FROM reservation WHERE id = ?;";
                db.write(query, id);

                query = "DELETE FROM reservation WHERE id = ? ;";
                status = "CANCELED";
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

    public int getTableId(){
        return tableId;
    }



    public void setFulFilled() {
        try {
            DBConn db = new DBConn();
            String query = "UPDATE reservation SET status = 'FULFILLED' WHERE client_id = ? AND table_id= ? AND start_datetime = ?;";
            status = "FULFILLED";
            db.write(query, clientId, tableId, getDateTime().toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }


}
