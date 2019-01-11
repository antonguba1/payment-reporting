import java.util.Date;

public class Payment {

    private Date dueDate;
    private Date actualDate;
    private double expectedAmount;
    private double actualAmount;
    private String status;


    public Payment(int expectedAmount, int numberOfPayments) {
        this.expectedAmount = expectedAmount;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }


    public String checkPaymentStatus() {
        if (expectedAmount > actualAmount && (actualDate.after(dueDate))) {
            return status = "LATE";
        } else if (expectedAmount <= actualAmount && ((actualDate.before(dueDate)) || ((actualDate.equals(dueDate))) {
            return status = "ON TIME";
        }
    }
}
