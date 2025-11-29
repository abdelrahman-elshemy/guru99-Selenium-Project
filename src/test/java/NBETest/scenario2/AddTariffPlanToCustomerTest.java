package NBETest.scenario2;

import NBEPages.scenario2.AddTariffPlanToCustomer;
import NBETest.TestBase;
import NBETest.scenario1.AddCustomerTest;
import org.testng.annotations.Test;

public class AddTariffPlanToCustomerTest extends TestBase {

    AddTariffPlanToCustomer tariffPage;

    @Test(description = "Assign Tariff Plan to Customer Successfully", dependsOnMethods = {"NBETest.scenario1.AddCustomerTest.addCustomerTest"})
    public void assignTariffPlan() throws InterruptedException {

        // Initialize page object
        tariffPage = new AddTariffPlanToCustomer(driver);

        // Get Customer ID generated from previous test
        String customerId = AddCustomerTest.generatedCustomerId;

        // Add tariff plan to customer
        tariffPage.add(customerId);

        System.out.println("Tariff plan assigned successfully to Customer ID: " + customerId);
    }
}
