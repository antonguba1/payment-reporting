import com.model.EmailValidation;
import com.model.User;
import com.service.CreateScheduleService;
import com.service.WriteScheduleToExcel;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    List<User> listOfUsers = new ArrayList<>();

    public static void main(String[] args) throws IOException, InvalidFormatException {

        Main main = new Main();

        CreateScheduleService createScheduleService = new CreateScheduleService();

        User user = createScheduleService.createSchedule();


        WriteScheduleToExcel test = new WriteScheduleToExcel();

        test.generateSchedule(user);






        }

    }