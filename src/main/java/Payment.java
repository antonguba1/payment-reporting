import java.util.Date;
import java.util.List;

public class Payment {

    private Date dueDate;
    private List<Installment> listOfInstallments;
    private Installment installment;
    private double expectedTotalAmount;
    private double actualTotalAmount;

    public Payment(Date dueDate, List<Installment> listOfInstallments) {
        this.dueDate = dueDate;
        this.listOfInstallments = listOfInstallments;
    }

    //should has this method some parameters?
    public double getExpectedTotalAmount() {
        for (Installment e : listOfInstallments) {
            expectedTotalAmount += e.getExpectedAmount();
        }
        return expectedTotalAmount;
    }

    public double getActualTotalAmount() {
        for (Installment e : listOfInstallments) {
            actualTotalAmount += e.getActualAmount();
        }
        return actualTotalAmount;
    }


}
