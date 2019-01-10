

public class User {

    private String name;
    private String email;
    private Payment payment;



    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void addPayment(int amount, int numberOfRates) {

    }

    public void addUser(String name, String email) {
        User user = new User(name, email);

    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
