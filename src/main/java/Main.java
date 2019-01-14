import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {



        System.out.println("MENU");
        System.out.println("Search email >>> 1");
        System.out.println("Show User >>> 2");
        System.out.println("Edit User >>> 3");
        System.out.println("Delete User >>> 4");
        System.out.println("Exit >>> 5");
        System.out.println();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("Welcome to the application. Choose an option.");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Provide email: ");
                    String email = scanner.next();
                    UserService.verifyEmail();
                    break;
                case 2:
                    UserService.show();
                    break;
                case 3:
                    //something
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
