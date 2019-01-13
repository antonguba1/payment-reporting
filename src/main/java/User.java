<<<<<<< HEAD

=======
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
>>>>>>> 1f556428250419addefbb82e149787f760301508

public class User {

    private String name;
    private String email;
<<<<<<< HEAD
    private Payment payment;
=======
    private List<Payment> listOfPayments;
>>>>>>> 1f556428250419addefbb82e149787f760301508



    public User(String name, String email, Payment payment) {
        this.name = name;
        this.email = email;
        this.payment = payment;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

<<<<<<< HEAD
=======
 /*   public void addPayment(int amount, int numberOfRates) {
      for(int i=0; i<=numberOfRates;i++) {
          listOfPayments.add
      }
    }*/

    public void setDueDate(Date dueDate){
        for (Payment payment : listOfPayments){
            payment.setDueDate(dueDate);
        }
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
>>>>>>> 1f556428250419addefbb82e149787f760301508
}
