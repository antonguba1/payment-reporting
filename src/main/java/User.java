import java.util.ArrayList;
import java.util.List;

public class User {

    String name;
    String email;
    List<Payment> userPayments;


    public User(String name, String email) {
        this.name = name;
        this.email = email;
        userPayments = new ArrayList<>();
    }


    public void addPayment(Payment payment) {
        userPayments.add(payment);
    }

}