import java.util.Date;

public class Payment {


    private Date dueDate;
    private Date actualDate;
    private int numberOfPayments;
    private double expectedAmount;
    private double actualAmount;


    public Payment(int expectedAmount, int numberOfPayments){
        this.expectedAmount = expectedAmount;
        this.numberOfPayments = numberOfPayments;
    }


}
