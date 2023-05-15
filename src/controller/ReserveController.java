package controller;

import model.Reservation;
import model.Table;
import view.ReserveView;
import model.Client;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
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

    /**
     * validates the reservation form
     * @param name client name
     * @param email client email
     * @param contact client contact number
     * @param tableNo table number
     * @param datetime datetime of reservation (yyyy-MM-dd HH:mm)
     */
    public void validate(String name, String email, String contact, String tableNo, String datetime, String requests) {
        //empty check
        if(name.isEmpty() || email.isEmpty() || contact.isEmpty() || tableNo == "" || datetime == null) {
            view.displayError("Please fill in all fields");
        }
        //name has numbers?
        else if(name.matches(".*\\d.*")){ //regex checks if name contains numbers
            view.displayError("Name cannot contain numbers");
        }

        //email w/ email regex
        else if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            view.displayError("Invalid email");
        }
        //contact number, 10 digits, numbers only
        else if(contact.length() != 10 || !contact.matches(".*\\d.*")) {
            view.displayError("Invalid contact number");
        }

        //validate date and time
        else if(!validateDatetime(datetime)) {
            view.displayError("Invalid date and time format");
        }
        //check if the date and time has already passed?
        else if(datePassed(datetime)) {
            view.displayError("Date and time has passed. Please select a valida date and time in the future");
        }

        //check if this timeslot is already booked.
        else if(Reservation.checkIfBooked(Integer.parseInt(tableNo), datetime)) {
            view.displayError("This timeslot is already booked. Please select another timeslot");
        }

        else {
            //save customer details first into client table
            Client client = new Client(name, contact, email);
            client.save();

            client.exists();


            //save reservation details now
            model = new Reservation(client.getId(),Integer.parseInt(tableNo), datetime, requests);
            model.save();
            view.displaySuccess("Reservation saved successfully");
        }

    }

    /**
     * validates the datetime format
     * @param dt datetime (yyyy-MM-dd HH:mm)
     * @return true if valid, false otherwise
     */
    private boolean validateDatetime(String dt){
        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            format.parse(dt);
            return true;
        } catch (ParseException e) {
            return false;
        }

    }

    public boolean datePassed(String dt) {
        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date = format.parse(dt);
            Date now = new Date();
            return date.compareTo(now) < 0;
        } catch (ParseException e) {
            return false;
        }
    }




}
