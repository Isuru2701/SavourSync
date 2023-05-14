
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class dates {

    public static void main(String[] args) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            df.setLenient(false);
            Date d = df.parse("2020-02-29 12:12");
            System.out.println("valid date");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
