import java.io.PrintWriter;
import java.util.Scanner;

public class CreateScheduleServis {


    EmailValidation emailValidation = new EmailValidation();
    private PrintWriter print = new PrintWriter(System.out, true);
    private Scanner scanner = new Scanner(System.in);



    public User CreateSchedule() {

        getEmail();
        emailValidation.validateEmail(getEmail());

    }



    private String getEmail() {

        print.println("Enter your email:");
        String email = scanner.nextLine();

        return email;
    }

    private 
}
