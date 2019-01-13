import java.util.Date;
import java.util.List;

public class Payment {

    private Date dueDate;
<<<<<<< HEAD
    private List<Installment> listOfInstallments;
    private Installment installment;
    private double expectedTotalAmount;
    private double actualTotalAmount;

    public Payment(Date dueDate, List<Installment> listOfInstallments) {
        this.dueDate = dueDate;
        this.listOfInstallments = listOfInstallments;
    }
=======
    private Date actualDate;
    private double expectedAmount;
    private double actualAmount;
    private String status;
>>>>>>> 1f556428250419addefbb82e149787f760301508

    //should has this method some parameters?
    public double getExpectedTotalAmount() {
      for (Installment e : listOfInstallments) {
          expectedTotalAmount += e.getExpectedAmount();
      }
      return expectedTotalAmount;
    }

<<<<<<< HEAD
    public double getActualTotalAmount() {
        for (Installment e : listOfInstallments) {
            actualTotalAmount += e.getActualAmount();
        }
        return actualTotalAmount;
=======
    public Payment(int expectedAmount, int numberOfPayments) {
        this.expectedAmount = expectedAmount;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
>>>>>>> 1f556428250419addefbb82e149787f760301508
    }


    public String checkPaymentStatus() {
        if (expectedAmount > actualAmount && (actualDate.after(dueDate))) {
            return status = "LATE";
        } else if (expectedAmount <= actualAmount && ((actualDate.before(dueDate)) || ((actualDate.equals(dueDate))) {
            return status = "ON TIME";
        }
    }
}
