package NBETest.scenario1;

import NBEPages.scenario1.addCustomer;
import NBETest.TestBase;
import org.testng.annotations.Test;

public class AddCustomerTest extends TestBase {

    public static String generatedCustomerId; // static to share across tests
    addCustomer addCustomerPage;

    @Test(description = "Add Customer and get ID")
    public void addCustomerTest() {
        addCustomerPage = new addCustomer(driver);

        // Generate customer and capture ID
        generatedCustomerId = addCustomerPage.addCustomer();

        System.out.println("Generated Customer ID: " + generatedCustomerId);
    }
}
