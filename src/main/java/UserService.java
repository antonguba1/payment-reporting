
import com.model.Installment;
import com.model.PaymentSchedule;
import com.model.PaymentScheduleInfo;
import com.model.User;
import com.service.ReadUserService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class UserService {
    public void show() throws IOException, InvalidFormatException {

        ReadUserService readUserService = new ReadUserService();

        //User user = readUserService.createUser();

        Workbook workbook = WorkbookFactory.create(new File(ExcelReader.SAMPLE_XLSX_FILE_PATH));

        Sheet sheet = workbook.getSheetAt(0);

        List<User> users = new ArrayList<>();


        /*INSERTING PAYMENTS
        Scanner insert = new Scanner(System.in);

        double payment = insert.nextDouble();
*/


        DataFormatter dataFormatter = new DataFormatter();

        sheet.forEach(row -> {
            row.forEach(cell -> {
                String cellValue = dataFormatter.formatCellValue(cell);
                System.out.print(cellValue + "\t");
            });
            System.out.println();
        });

        System.out.println("\n\nAll Students Data\n");


        for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
            User user = new User();
            PaymentSchedule paymentSchedule = new PaymentSchedule();
            PaymentScheduleInfo paymentScheduleInfo = new PaymentScheduleInfo();
            Row row = sheet.getRow(i);
            for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                if (j == 0) {
                    user.setName(cell.getStringCellValue());
                }
                if (j == 1) {
                    user.setEmail(cell.getStringCellValue());
                }
                if (j == 2) {
                    paymentSchedule.setActualTotalAmount(cell.getNumericCellValue());
                }
                if (j == 3) {
                    paymentSchedule.setExpectedTotalAmount(cell.getNumericCellValue());
                }
                if (j == 4) {
                    paymentScheduleInfo.setNumberOfInstallments((int) cell.getNumericCellValue());
                }
                if (j == 5) {
                    paymentScheduleInfo.setFirstDueDate(cell.getDateCellValue());
                }
                if (j == 6) {
                    paymentScheduleInfo.setInstallmentAmount(cell.getNumericCellValue());
                }
            }
                int k = 5;
                while (k < 5 + 3 * row.getCell(4).getNumericCellValue()) {
                    Installment installment = new Installment();
                    installment.setDueDate(row.getCell(k).getDateCellValue());
                    installment.setExpectedAmount(row.getCell(k + 1).getNumericCellValue());
                    installment.setActualDate(row.getCell(k + 2).getDateCellValue());
                    installment.setActualAmount(row.getCell(k + 3).getNumericCellValue());
                    k += 4;
                    paymentSchedule.getInstallmentList().add(installment);
                }

            paymentSchedule.setPaymentScheduleInfo(paymentScheduleInfo);
            user.setPaymentSchedule(paymentSchedule);
            users.add(user);

        }
        for (User user : users) {
            System.out.println("\nName : " + user.getName() + "\nEmail : " + user.getEmail() +
                    "\n\nPayment Schedule : " + "\nActual Total Amount : " + user.getPaymentSchedule().getActualTotalAmount() + "\nExpected Total Amount : " + user.getPaymentSchedule().getExpectedTotalAmount() + "\n\nInstallment List : \n" + user.getPaymentSchedule().getInstallmentList().get(0) + "\n" + user.getPaymentSchedule().getInstallmentList().get(1) + "\n" + user.getPaymentSchedule().getInstallmentList().get(2) +
                    "\n\nPayment Schedule Info : " + "\nFirst Due Date : "  + user.getPaymentSchedule().getPaymentScheduleInfo().getFirstDueDate() + "\nInstallment Amount : "  + user.getPaymentSchedule().getPaymentScheduleInfo().getInstallmentAmount() + "\nNumber Of Installments : "  + user.getPaymentSchedule().getPaymentScheduleInfo().getNumberOfInstallments());
        }

        workbook.close();
    }

    public void verifyEmail(String email) {

    }

    public void addPayment() {

    }

    /*
    private static void printCellValue(Cell cell) {
        switch (cell.getCellTypeEnum()) {
            case BOOLEAN:
                System.out.print(cell.getBooleanCellValue());
                break;
            case STRING:
                System.out.print(cell.getRichStringCellValue().getString());
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    System.out.print(cell.getDateCellValue());
                } else {
                    System.out.print(cell.getNumericCellValue());
                }
                break;
            case FORMULA:
                System.out.print(cell.getCellFormula());
                break;
            case BLANK:
                System.out.print("");
                break;
            default:
                System.out.print("");
        }

        System.out.print("\t");
    }

    */

}

