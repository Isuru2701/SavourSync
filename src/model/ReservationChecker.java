package model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.TimerTask;

public class ReservationChecker extends TimerTask {


    List<Reservation> reservationList;
    public ReservationChecker(List<Reservation>  rt) {
        reservationList = rt;
    }

    @Override
    public void run() {

        // Iterate through reservations
        for (Reservation t : reservationList) {
            if(true)  {
                // Update reservation state
                // Notify the user or update UI
            }
        }
    }
}
