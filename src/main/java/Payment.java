
public class Payment {

    int numberOfPayments;
    String dueDate;
    String actualDate;
    double expectedAmount;
    double actualAmount;


    public Payment(int expectedAmount, int numberOfPayments){
        this.expectedAmount = expectedAmount;
        this.numberOfPayments = numberOfPayments;
    }


}
