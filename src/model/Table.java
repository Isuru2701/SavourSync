package model;

import java.sql.ResultSet;

/**
 * Class Table
 * <br>
 * Holds information related to the table, such as the number, capacity,
 */
public class Table {

    //seats = number of seats
    //floor = location within the restaurant, useful for determining accessibility(such as via wheelchair) and view
    private int seats, floorNo, id;
    private boolean available;

    public Table(int id) {
        this.id = id;
    }

    public Table(int seats, int floorNo) {
        this.seats = seats;
        this.floorNo = floorNo;
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

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void save() throws RuntimeException {
        try{
            DBConn db = new DBConn();
            String query = "INSERT INTO table (seats, available) VALUES (?, false)";
            db.write(query, seats);

        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void load() throws RuntimeException {
        try{
            DBConn db = new DBConn();
            String query = "SELECT * FROM table WHERE id = ?";
            ResultSet reply = db.query(query, id);
            if(reply.next()) {
                this.seats = reply.getInt("seats");
                this.floorNo = reply.getInt("floor_no");
                this.available = reply.getBoolean("available");
            }
            else {
                throw new RuntimeException("Table not found");
            }

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
                this.floorNo = reply.getInt("floorNo");
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

}
