import com.model.Installment;
import com.model.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ExcelWriter {
    private static String[] columns = {"Due Date 1", "Expected Payment 1", "Actual Date 1", "Actual Payment 1", "Expected Payment 1", "Due Date 2", "Expected Payment 2", "Actual Date 2", "Actual Payment 2"};
    private static List<Installment> installments =  new ArrayList<>();

    static {
        Calendar dueDate1 = Calendar.getInstance();
        dueDate1.set(2019, 2, 1);

        Calendar actualDate1 = Calendar.getInstance();
        actualDate1.set(2019, 1, 17);

        installments.add(new Installment(dueDate1.getTime(), 600, actualDate1.getTime(), 600));

        Calendar dueDate2 = Calendar.getInstance();
        dueDate2.set(2019, 2, 1);

        Calendar actualDate2 = Calendar.getInstance();
        actualDate2.set(2019, 2, 2);

        installments.add(new Installment(dueDate2.getTime(), 600, actualDate2.getTime(), 600));

    }
}
