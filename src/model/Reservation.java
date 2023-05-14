package model;


import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Class Reservation
 * <br>
 * This class is used to represent a reservation
 */
public class Reservation {


    private Client client;
    private Table table;
    private LocalDate date;
    private LocalTime time;

    public Reservation() {

    }
    public Reservation(Client client, Table table, LocalDate date, LocalTime time) {
        this.client = client;
        this.table = table;
        this.date = date;
        this.time = time;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Table getTable() {
        return table;
    }

    public void save() {

    }

}
