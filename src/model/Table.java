package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Table
 * <br>
 * Holds information related to the table, such as the number, capacity,
 */
public class Table {

    //seats = number of seats
    //floor = location within the restaurant, useful for determining accessibility(such as via wheelchair) and view
    private int seats, id;
    private boolean available;

    public Table(int seats) {
        this.seats = seats;

        this.available = true;
    }

    public int getId() {
        return id;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public boolean isAvailable() {
        return available;
    }

    //update db as well
    public void setAvailable(boolean available) {
        this.available = available;
        try{
            DBConn db = new DBConn();
            String query = "UPDATE `table` SET available = ? WHERE id = ?";
            db.write(query, available, id);
            db.kill();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void save() throws RuntimeException {
        try{
            DBConn db = new DBConn();
            String query = "INSERT INTO `table` (seats, available) VALUES (?, ?)";
            db.write(query, seats, available);

        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean exists() throws RuntimeException {
        try {
            DBConn db = new DBConn();
            String query = "SELECT * FROM `Table` WHERE id = ?";
            ResultSet reply = db.query(query,id);
            if(reply.next()) {
                this.seats = reply.getInt("seats");
                this.available = reply.getBoolean("available");
                return true;
            }
            else {
                return false;
            }
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * gets the ids of all available tables (available = true)
     * @return list of available table ids
     * @throws RuntimeException
     */
    public static List<Integer> getAvailable() throws RuntimeException {
        try {
            List<Integer> ids = new ArrayList<Integer>();
            DBConn db = new DBConn();
            String query = "SELECT id FROM `table` where available = True";
            ResultSet reply = db.query(query);
            while(reply.next()) {
                ids.add(reply.getInt(1));
            }

            reply.close();
            return ids;


        }
        catch(Exception e) {
            System.err.println(e.getMessage());
            throw new RuntimeException();
        }
    }

}
