import java.util.Date;
import java.util.List;

public class Payment {

    Date dueDate;
    List<Installment> listOfInstallments;

    public Payment(Date dueDate, List<Installment> listOfInstallments) {
        this.dueDate = dueDate;
        this.listOfInstallments = listOfInstallments;
    }



}
