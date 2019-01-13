<<<<<<< HEAD
=======
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int numberOfUsers=0;
    private List<User> listOfUsers;


    public void addUser(String name, String email) {
        User user = new User(name, email);
        listOfUsers.add(user);
        numberOfUsers++;
    }

    public boolean checkIfUserExist(String email) {
        if (listOfUsers != null) {

            for (User u : listOfUsers) {
                if (u.getEmail().contains(email)) {
                    Loger.printInfo("This email " + email + " is busy.");
                    return true;
                }
            }
        }return false;
    }
>>>>>>> 1f556428250419addefbb82e149787f760301508


public class Main {


    public static void main(String[] args) {

<<<<<<< HEAD
=======
        Loger.printInfo("Write your email.");
        Scanner input = new Scanner(System.in);

>>>>>>> 1f556428250419addefbb82e149787f760301508


    }
}
