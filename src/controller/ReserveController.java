package controller;

import model.Reservation;
import model.Table;
import view.ReserveView;

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


    public void validate(String name, String email, String contact, int seats, int tableNo, Date date, LocalTime time) {

    }


}
