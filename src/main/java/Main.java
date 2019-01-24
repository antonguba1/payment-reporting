
import com.service.CreateFolderService;
import com.service.GeneralMenu;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import java.io.IOException;
import java.nio.file.Path;

public class Main {


    public static void main(String[] args) throws IOException, InvalidFormatException {


        CreateFolderService.createDirectories();
        GeneralMenu.runProgram();






        }

    }