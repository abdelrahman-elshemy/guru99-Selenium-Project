package NBEPages.scenario2;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddTariffPlanToCustomer {

    public WebDriver driver;

    public AddTariffPlanToCustomer(WebDriver driver){
        this.driver = driver;
    }

    private final By Drawablefield = By.xpath("//nav[@class='left']//a[@href='#menu']");
    private final By AddTariffPlanToCustomerfield = By.xpath("//ul[@class='links']//li//a[@href='assigntariffplantocustomer.php'][normalize-space()='Add Tariff Plan to Customer']");
    private final By CustomerIdfield = By.id("customer_id");
    private final By SubmitField = By.name("submit");
  //  private final By RadioBtnInput = By.cssSelector("label[for='sele']");
    private final By Submit2field = By.name("submit");
    private final By CongratulateText = By.xpath("//h2[normalize-space()='Congratulation Tariff Plan assigned']");

    public AddTariffPlanToCustomer add(String customerId) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // increased wait

        // 1- Open Left side menu (Drawable)
        wait.until(ExpectedConditions.elementToBeClickable(Drawablefield)).click();

        // 2- Click “Add Tariff Plan to Customer”
        wait.until(ExpectedConditions.elementToBeClickable(AddTariffPlanToCustomerfield)).click();

        // 3- Enter the Customer ID
        WebElement custID = wait.until(ExpectedConditions.visibilityOfElementLocated(CustomerIdfield));
        custID.clear();
        custID.sendKeys(customerId);

        // 4- First Submit
        wait.until(ExpectedConditions.elementToBeClickable(SubmitField)).click();

        // 5- Scroll and click tariff plan radio button
        WebElement label = driver.findElement(By.cssSelector("label[for='sele']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", label); //forces the browser to click the element regardless of Selenium’s rules.

        // 6- Second Submit
        wait.until(ExpectedConditions.elementToBeClickable(Submit2field)).click();

        // 7- Validate success message
        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(CongratulateText));
        Assert.assertTrue("Tariff plan was NOT assigned!", successMsg.isDisplayed());

        return this;
    }
}
