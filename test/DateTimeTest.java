import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeTest {

    public static void main(String[] args) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-M-dd HH:m");

        LocalDateTime date = LocalDateTime.from(dtf.parse("2023-5-16 15:0"));
        LocalDateTime res = LocalDateTime.from(dtf.parse("2023-05-16 15:20"));
        //datetime equal, if above, check after, if below, check before
        if(res.equals(date) ||
                (date.plusHours(1).isAfter(res) && date.plusHours(1).isBefore(res.plusHours(1))) ||
                (res.isAfter(date)) && res.isBefore(date.plusHours(1))) {
            System.out.println("overlapp");
        }
        else {
            System.out.println("no overlap");
        }
    }
}
