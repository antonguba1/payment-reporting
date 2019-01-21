import com.model.User;
import com.service.CreateScheduleService;
import com.service.WriteScheduleToExcel;
import com.service.WriteUserToExcelService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException, InvalidFormatException {


        CreateScheduleService createScheduleService = new CreateScheduleService();

        User user = createScheduleService.createSchedule();

        WriteScheduleToExcel test = new WriteScheduleToExcel();

        WriteUserToExcelService t = new WriteUserToExcelService();
        t.saveUserToExcel(user);




        }

    }