import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;

public class UserService {
    public static void show() throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(new File(ExcelReader.SAMPLE_XLSX_FILE_PATH));
        workbook.getSheetAt(0);
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets.");

        System.out.println("\nRetrieving Sheets using Java 8 forEach with lambda");
        workbook.forEach(sheet -> {
            System.out.println(">>> " + sheet.getSheetName());


        });

        Sheet sheet = workbook.getSheetAt(0);

        DataFormatter dataFormatter = new DataFormatter();

        System.out.println("\n\nAll Students Data\n");
        sheet.forEach(row -> {
            row.forEach(cell -> {
                String cellValue = dataFormatter.formatCellValue(cell);
                System.out.print(cellValue + "\t");
            });
            System.out.println();
        });

        // Closing the workbook
        workbook.close();
    }

    public static void verifyEmail() {

    }
}
