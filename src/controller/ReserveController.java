package controller;

import model.Reservation;
import model.Table;
import view.ReserveView;
import model.Client;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;

/**
 * Controller for ReserveView
 * <br>
 * interaction logic with view and model for reservations
 *
 */
public class ReserveController extends AbstractController{

    ReserveView view;
    Reservation model;

    public ReserveController(ReserveView view) {
        this.view = view;
    }

    public void determineClient(String name, String email, String contact) {
        Client client = new Client(name, email, contact);

    }
    public void determineTable(int id) {
        Table table = new Table(id);
    }

    /**
     * validates the reservation form
     * @param name client name
     * @param email client email
     * @param contact client contact number
     * @param seats number of seats on the table
     * @param tableNo table number
     * @param date date of reservation
     * @param time time for reservation
     */
    public void validate(String name, String email, String contact, int seats, int tableNo, LocalDate date, LocalTime time) {
        if(name.isEmpty() || email.isEmpty() || contact.isEmpty() || seats == 0 || tableNo == 0 || date == null || time == null) {
            view.displayError("Please fill in all fields");
        }
        else if(name.matches(".*\\d.*")){ //regex checks if name contains numbers
            view.displayError("Name cannot contain numbers");
        }
        else if(!email.contains("@")) {
            view.displayError("Invalid email");
        }
        else if(contact.length() != 10) {
            view.displayError("Invalid contact number");
        }
        else if(seats > 10) {
            view.displayError("Maximum number of seats is 10");
        }
        else if(tableNo > 10) {
            view.displayError("Maximum table number is 10");
        }
        else if(date.isBefore(LocalDate.now())) {
            view.displayError("Invalid date");
        }
    }

    private boolean isAvailable() {

        return false;
    }

    public void save() {
        //model = new Reservation(new Client(name, email, contact), new Table(seats, tableNo), date, time);
        model.save();
        view.displaySuccess("Reservation made successfully");

    }



}
