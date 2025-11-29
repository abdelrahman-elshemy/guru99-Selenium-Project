package utilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helper {

    //create method to take screenshot while test case fail
    public static  void capturescreenshot(WebDriver driver, String screenshotname) {

        Path des = Paths.get("./Screenshotss",screenshotname+".png");
        try {
            Files.createDirectories(des.getParent());
            FileOutputStream out = new FileOutputStream(des.toString());
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (Exception e) {
            System.out.println("Exception while take screenshot"+e.getMessage());
        }

    }


}
