import java.util.ArrayList;
import java.util.List;

public class GeneralOperations {

    List<User> listOfUsers = new ArrayList<>();

    // parametrami powinny chyba być dane wpisane z konsoli String name, String email
    public void addUser(User user) {
        listOfUsers.add(user);
    }

    public List<User> getListOfUsers() {
        return listOfUsers;
    }



    /* public  whichStudent() {
        return user;
    }

    public printScheduleOfPayments(){
        return scheduleOfPayments;
    }
    */
}
