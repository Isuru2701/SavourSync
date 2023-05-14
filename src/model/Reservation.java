package model;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Class Reservation
 * <br>
 * This class is used to represent a reservation
 */
public class Reservation {

    private int clientId, tableId;
    private String requests,datetime, status;

    public Reservation(int clientId, int tableId, String datetime, String requests) {
        this.clientId = clientId;
        this.tableId = tableId;
        this.datetime = datetime;
        this.requests = requests;
        this.status = "pending";
    }

    public String getDateTime() {
        return datetime;
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


}
