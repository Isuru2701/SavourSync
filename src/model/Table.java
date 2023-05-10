package model;

/**
 * Class Table
 * <br>
 * Holds information related to the table, such as the number, capacity,
 */
public class Table {

    //seats = number of seats
    //floor = location within the restaurant, useful for determining accessibility(such as via wheelchair) and view
    private int seats, floorNo;
    private boolean available;

    public Table(int seats, int floorNo) {
        this.seats = seats;
        this.floorNo = floorNo;
        this.available = true;
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
}
