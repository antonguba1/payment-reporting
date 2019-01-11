import java.util.List;

public class Main {

    private List<User> listOfUsers;

    int numberOfRates;



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




    public static void main(String[] args) {






    }
}
