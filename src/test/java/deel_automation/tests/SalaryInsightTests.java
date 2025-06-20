package deel_automation.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import deel_automation.methods.SalaryInsightMethod;
import deel_automation.pages.SalaryInsightPage;


public class SalaryInsightTests extends BaseTest {
	
	SalaryInsightMethod sim;
	SalaryInsightPage insightPage;
	
	
	@BeforeMethod
	public void setupmethods()
	{
		insightPage = new SalaryInsightPage(driver);
		sim = new SalaryInsightMethod(driver, insightPage);
		
	}


	// Test Case 1: Accountant in Brazil
    @Test(priority = 1, description = "Validate salary insights for Accountant in Brazil")
    public void testAccountantInBrazil() throws Exception {
        sim.validateSalaryInsights(properties.getProperty("Role_1"), properties.getProperty("Country_1"));
    }
    

    // Test Case 2: QA Engineer in Canada
    @Test(priority = 2, description = "Validate salary insights for QA Engineer in Canada")
    public void testEngineerInCanada() throws Exception {
    	sim.validateSalaryInsights(properties.getProperty("Role_2"), properties.getProperty("Country_2"));
    }
    
    

    // Test Case 3: Software Engineer in Japan
    @Test(priority = 3, description = "Validate salary insights for Software Engineer in Japan")
    public void testSoftwareEngineerInJapan() throws Exception {
    	sim.validateSalaryInsights(properties.getProperty("Role_3"), properties.getProperty("Country_3"));
    }
    
    
    @Test(priority = 4, description = "Validate dropdown")
    public void validatedropdown() throws Exception {
  //  	sim.Dropdowntest(properties.getProperty("Role_3"), properties.getProperty("Country_3"));
    	int index = 121;
		sim.RandomDroptest(properties.getProperty("Role_3"), index);
    }
    
    
    @Test(priority = 5, description = "Verify Filters", enabled = false)
    public void validatefilter() throws Exception {
 
		sim.validatefilter(properties.getProperty("Role_4"));
    }
    
    
    




        
     

}
