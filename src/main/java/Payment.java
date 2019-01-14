
public class Payment {


    private String dueDate;
    private String actualDate;
    private int numberOfPayments;
    private double expectedAmount;
    private double actualAmount;


    public Payment(int expectedAmount, int numberOfPayments){
        this.expectedAmount = expectedAmount;
        this.numberOfPayments = numberOfPayments;
    }

}