import java.util.ArrayList;
import java.util.List;

public class GeneralOperations {

    List<User> listOfUsers = new ArrayList<>();

    public void addUser(User user) {
        listOfUsers.add(user);
    }

    public boolean checkUserEmail(String email) {
        for (User u : listOfUsers
        ) {
            if (u.email.contains(email)) {
                return true;
            }
        }
        InformationServis.printGeneralInfo("This email not exist add new user");
        return false;
    }

}
