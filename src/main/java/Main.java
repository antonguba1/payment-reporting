import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        ObjectToJson obj = new ObjectToJson();
        GeneralOperations generalOperations = new GeneralOperations();

        InformationServis.printGeneralInfo("Select one of the following options by entering the appropiate number: ");
        InformationServis.printGeneralInfo("1. Create schedule of next payment");

        Integer option = input.nextInt();

        if(option == 1){
            InformationServis.printGeneralInfo("Write email: ");
            String email = input.next();
            if(generalOperations.checkUserEmail(email)){
                obj.readJsonFile(email);
            }else{
                InformationServis.printGeneralInfo("Write name: ");
                String name = input.next();
                User u = new User(name,email);
                generalOperations.addUser(u);
                //stosuje json jako backup
                obj.addUserObjectToJson(name,email);
                // dodać payment dla użytkownika
                InformationServis.printGeneralInfo("Write due date: ");
                String dueDate = input.next();
                InformationServis.printGeneralInfo("Write expected amount: ");
                int expectedAmount = input.nextInt();
                InformationServis.printGeneralInfo("Write payment: ");
                int payme = input.nextInt();
                InformationServis.printGeneralInfo("Write number of payments: ");
                int numberOfPayments = input.nextInt();
                Payment payment = new Payment(dueDate,expectedAmount,payme,numberOfPayments);
                u.addPayment(payment);
                obj.addPaymentObjectToJson(email,dueDate,expectedAmount,payment.getActualDate(),payment.getActualAmount(payme),numberOfPayments);
            }

        }else{
            InformationServis.printGeneralInfo("Choose another option: ");
        }
    }
}