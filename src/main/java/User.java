import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {

    private String name;
    private String email;
    private List<Payment> listOfPayments;


    public User(String name, String email) {
        this.name = name;
        this.email = email;
        listOfPayments = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

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
}


//WERSJA DODANA PRZEZ RAFAŁA

/*
public class User {

    private String name;
    private String email;
    private Payment payment;



    public User(String name, String email, Payment payment) {
        this.name = name;
        this.email = email;
        this.payment = payment;
    }

    public String getEmail() {
        return email;
    }

    public String getName(){
        return  name;
    }

}
 */