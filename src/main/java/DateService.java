import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateService {
    //String string = "January 1, 2019";
    public static Date convertDateType(String string) throws ParseException {
        DateFormat format = new SimpleDateFormat("dd, MM, yyyy", Locale.ENGLISH);
        Date date = format.parse(string);
        return date;
    }
}
