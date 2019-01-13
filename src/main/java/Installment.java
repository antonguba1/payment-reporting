import java.util.Date;

public class Installment {

    private Date dueDate;
    private double expectedAmount;
    private double actualAmount;

    public Installment(Date dueDate, double expectedAmount) {
        this.dueDate = dueDate;
        this.expectedAmount = expectedAmount;
        this.actualAmount = 0;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public double getActualAmount() {
        return actualAmount;
    }

    public double getExpectedAmount() {
        return expectedAmount;
    }

    public void setActualAmount(double actualAmount) {
        this.actualAmount = actualAmount;
    }

}
