import com.model.User;
import com.service.CreateScheduleService;
import com.service.GenerateScheduleService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException, InvalidFormatException {


        CreateScheduleService createScheduleService = new CreateScheduleService();

        User user = createScheduleService.createSchedule();

        GenerateScheduleService test = new GenerateScheduleService();

        test.generateSchedule(user);




        }

    }