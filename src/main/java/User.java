import java.util.ArrayList;
import java.util.List;

public class User {

    String name;
    String email;
    List<Payment> userPayments;


    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }


    public void addPayment(Payment payment) {
        if (userPayments == null) {
            userPayments = new ArrayList<>();
        }
        userPayments.add(payment);
    }

}