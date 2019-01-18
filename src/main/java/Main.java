import com.model.User;
import com.service.CreateScheduleService;
import com.service.ReadUserService;
import com.service.WriteSchedulesToExcel;


import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {


        CreateScheduleService createScheduleService = new CreateScheduleService();

        User user = createScheduleService.createSchedule();

        WriteSchedulesToExcel test = new WriteSchedulesToExcel();

        test.saveScheduleToExcel(user);




        }

    }