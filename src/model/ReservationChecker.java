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
            if(t.getDateTime().isBefore(LocalDateTime.now())){
                // Update reservation state
                // Notify the user or update UI
                t.setFulFilled();
                Table.setOccupied(t.getTableId());
            }

            //if an hour has passed
            if(t.getDateTime().plusHours(1).isBefore(LocalDateTime.now())){
                //set the table to available
                Table.setAvailable(t.getTableId());
            }
        }
    }
}
