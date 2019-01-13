
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
