

public class User {

    String name;
    String email;
    Payment payment;



    public User(String name, String email) {
        this.name = name;
        this.email = email;
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
