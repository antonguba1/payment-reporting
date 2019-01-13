import java.io.PrintWriter;
import java.util.Scanner;

public class CreateScheduleServis {


    EmailValidation emailValidation = new EmailValidation();
    private PrintWriter print = new PrintWriter(System.out, true);
    User user = new User(null, null, null);




    public User CreateSchedule() {


        emailValidation.validateEmail(getEmail());


        return null;
    }



    private String getEmail() {

        Scanner scanner = new Scanner(System.in);

        print.println("Enter your email:");
        String email = scanner.nextLine();

        return email;
    }

    private String getDatas() {

        //Getting datas: name, number of installments, installment amount, first installment date.

        Scanner scName = new Scanner(System.in);
        Scanner scNumbInst = new Scanner(System.in);
        Scanner scInstAmo = new Scanner(System.in);
        Scanner scFirstInstDat = new Scanner(System.in);

        print.println("Enter your followind datas:");
        print.println("Name: " + scName.nextLine() );
        print.println("Number of installments: " + scNumbInst.nextInt());
        print.println("Installment amount: " + scInstAmo.nextDouble());
        //print.println("Date of first installment: " + scFirstInstDat.);


        return null;
    }
}
