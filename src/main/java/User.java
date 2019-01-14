

public class User {

    private String name;
    private String email;
    private int payment;
    String dueDate1;
    double exPam1;
    String actDate1;
    double actAm1;
    String dueDate2;
    double exPam2;
    String actDate2;
    double actAm2;

    public User(String name, String email, int payment, String dueDate1, double exPam1, String actDate1, double actAm1, String dueDate2, double exPam2, String actDate2, double actAm2) {
        this.name = name;
        this.email = email;
        this.payment = payment;
        this.dueDate1 = dueDate1;
        this.exPam1 = exPam1;
        this.actDate1 = actDate1;
        this.actAm1 = actAm1;
        this.dueDate2 = dueDate2;
        this.exPam2 = exPam2;
        this.actDate2 = actDate2;
        this.actAm2 = actAm2;
    }
}
