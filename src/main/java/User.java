import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String email;
    private Payment payment;
    private List<Payment> listOfPayments;


    public User(String name, String email) {
        this.name = name;
        this.email = email;
        listOfPayments = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public String getName(){
        return  name;
    }

    public void addPayment(int amount, int numberOfRates) {

    }



    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
