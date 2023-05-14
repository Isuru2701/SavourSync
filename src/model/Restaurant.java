package model;

/**
 *
 * used to hold data related to the restaurant currently.
 * Similar to a session.
 * Mostly static.
 * <br>
 * useful for calculating capacity, etc.
 */
public class Restaurant {

    public static int getCapacity() {
        return capacity;
    }

    public static void setCapacity(int capacity) {
        Restaurant.capacity = capacity;
    }

    public static int getOccupancy() {
        return occupancy;
    }

    public static void setOccupancy(int occupancy) {
        Restaurant.occupancy = occupancy;
    }

    public static int capacity,occupancy;
}
