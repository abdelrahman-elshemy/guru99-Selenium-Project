package NBEPages.scenario1;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class addCustomer {

    public WebDriver driver;

    // constructor
    public addCustomer(WebDriver driver){
        this.driver = driver;
    }

    // locators
    private final By Drawablefield = By.xpath("//nav[@class='left']//a[@href='#menu']");
    private final By AddCustomerfield = By.xpath("//ul[@class='links']//li//a[@href='addcustomer.php'][normalize-space()='Add Customer']");
    private final By DoneRadioBtn = By.xpath("//label[normalize-space()='Done']");
    private final By firstNameField = By.xpath("//input[@id='fname']");
    private final By lastNameField = By.xpath("//input[@id='lname']");
    private final By emailField = By.xpath("//input[@id='email']");
    private final By addressField = By.xpath("//textarea[@id='message']");
    private final By MobileNumberField = By.xpath("//input[@id='telephoneno']");
    private final By submitField = By.xpath("//input[@name='submit']");

    // method for add Customer
    public String addCustomer() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 1- Open Left menu
        driver.findElement(Drawablefield).click();

        // 2- Click "Add Customer"
        driver.findElement(AddCustomerfield).click();

        // 3- Click "Done" radio button
        wait.until(ExpectedConditions.elementToBeClickable(DoneRadioBtn)).click();

        // 4- Fill fields with static data
        driver.findElement(firstNameField).sendKeys("Abdelrahman");
        driver.findElement(lastNameField).sendKeys("Elshemy");
        driver.findElement(emailField).sendKeys("abdelrahman@test.com");
        driver.findElement(addressField).sendKeys("Zahraa Nasr City Cairo Egypt");
        driver.findElement(MobileNumberField).sendKeys("01094802083");

        // 5- Click Submit
        driver.findElement(submitField).click();

        // 6- Capture Customer ID
        WebElement custID = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//td[normalize-space()='Customer ID']/following-sibling::td/h3")
        ));

        String customerIdValue = custID.getText();
        System.out.println("Generated Customer ID: " + customerIdValue);

        // 7- Validate Customer ID
        Assert.assertFalse("Customer ID was not generated!", customerIdValue.isEmpty());

        return customerIdValue;
    }
}
