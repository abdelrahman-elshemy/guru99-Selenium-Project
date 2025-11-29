package NBETest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.time.Duration;

public class TestBase {

    public WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    public void setup(@Optional("chrome") String browsername) {

        // Initialize browser
        if (browsername.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browsername.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }

        // Maximize and implicit wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Navigate to URL
        driver.get("https://demo.guru99.com/telecom");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Test Failed: " + result.getName());
            System.out.println("Capturing Screenshot...");
            Helper.capturescreenshot(driver, result.getName());
        }
    }
}
