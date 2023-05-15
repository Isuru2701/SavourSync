package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 *
 * used to hold data related to the restaurant currently.
 * Similar to a session.
 * Mostly static.
 * <br>
 * useful for calculating capacity, etc.
 */
public class Restaurant {

    private static ResultSet reservationSet;
    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
    public static int capacity,occupancy;
    public static void init(){
        reservationSet = new Reservation().getResultSet();
        setCapacity();
        setOccupancy();
    }

    //gets all the reservations for the day
    //every time a reservation's time approaches, if the status is pending, it will be set to 'fulfilled'.
    //update the table under the reservation's available to false. Reset this after 1 hour has passed.

    public void setTimers(){
        while(true) {
            try {
                if (!reservationSet.next()) break;
                else {
                    //yyyy-mm-dd HH:mm
                    //long time = Long.parseLong(reservationSet.getString("start_datetime").substring());
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }


        //get all reservations
        //for each reservation, set a timer for 1 hour
        //when the timer is up, set the table to available
        //if the reservation is not fulfilled, set it to fulfilled

    }



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
        ResultSet reply =  db.query("Select seats from `table` where available = 0");
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
