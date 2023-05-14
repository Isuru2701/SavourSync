package controller;

import model.Reservation;
import model.Table;
import view.ReserveView;
import model.Client;

import java.time.LocalTime;
import java.util.Date;

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
    public void determineTable() {

    }
    public void validate(String name, String email, String contact, int seats, int tableNo, Date date, LocalTime time) {
        if(name.isEmpty() || email.isEmpty() || contact.isEmpty() || seats == 0 || tableNo == 0 || date == null || time == null) {
            view.displayError("Please fill in all fields");
        } else {
            //model = new Reservation(name, email, contact, seats, tableNo, date, time);
            model.save();
            view.displaySuccess("Reservation made successfully");
        }
    }



}
