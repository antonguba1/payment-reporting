import com.model.User;
import com.service.CreateScheduleService;
import com.service.ExcelService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {

        UserService userService = new UserService();

        System.out.println("MENU");
        System.out.println("Generate Schedule >>> 1");
        System.out.println("Show User Statistics >>> 2");
        System.out.println("Insert Payment Info >>> 3");
        System.out.println("Generate Report >>> 4");
        System.out.println("Exit >>> 5");
        System.out.println();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the application. Choose an option.");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    CreateScheduleService createScheduleService = new CreateScheduleService();

                    User user = createScheduleService.createSchedule();

                    ExcelService test = new ExcelService();

                    test.saveUserToExcel(user);
                    break;
                case 2:
                    userService.show();
                    break;
                case 3:
                    userService.addPayment();
                    break;
                case 4:
                    //something
                    break;
                case 5:
                    //something
                    return;
            }
        }


    }
}