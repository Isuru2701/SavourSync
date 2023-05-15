package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * used to hold data related to the restaurant currently.
 * Similar to a session.
 * Mostly static.
 * <br>
 * useful for calculating capacity, etc.
 */
public class Restaurant {

    public static int capacity,occupancy;

    public static void setCapacity() {
        DBConn db = new DBConn();
        ResultSet reply =  db.query("Select seats from `table`");
        try{
            while(reply.next()){
                Restaurant.capacity += reply.getInt("seats");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static int getCapacity() {
        setCapacity();
        return capacity;
    }

    public static void setOccupancy() {
        DBConn db = new DBConn();
        ResultSet reply =  db.query("Select seats from `table` where available = 1");
        try{
            while(reply.next()){
                Restaurant.occupancy += reply.getInt("seats");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getOccupancy() {
        setOccupancy();
        return occupancy;
    }

}
