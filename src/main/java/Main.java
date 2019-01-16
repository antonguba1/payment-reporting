import com.model.User;
import com.service.CreateScheduleService;
import com.service.ExcelService;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {



        CreateScheduleService createScheduleService = new CreateScheduleService();

        User user = createScheduleService.createSchedule();

        ExcelService test = new ExcelService();

        test.saveUserToExcel(user);


    }
}