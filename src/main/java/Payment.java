import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Payment {

    int numberOfPayments;
    private String actualDate;
    private String dueDate;
    int expectedAmount;
    int actualAmount;


    public Payment(String dueDate, int expectedAmount,int payment, int numberOfPayments){
        this.dueDate = dueDate;
        this.expectedAmount = expectedAmount;
        this.actualDate = getActualDate();
        this.actualAmount = getActualAmount(payment);
        this.numberOfPayments = numberOfPayments;
    }

    public String getActualDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return dateFormat.format(date);
    }
    public int getActualAmount(Integer payment){
        this.actualAmount = this.expectedAmount - payment;
        return  actualAmount;
    }
}