package deel_automation.methods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import deel_automation.util.ReportUtil;
import deel_automation.pages.SalaryInsightPage;

public class SalaryInsightMethod {

	private WebDriver driver;
	private SalaryInsightPage insightPage;

	public SalaryInsightMethod(WebDriver driver, SalaryInsightPage insightPage)
	{
		this.driver = driver;
		this.insightPage=insightPage;
	}

	// Reusable method to validate salary insights
	public void validateSalaryInsights(String role, String country) throws Exception {
		// Scroll and verify tool section


		Assert.assertNotNull(insightPage, "SalaryInsightPage is null");

		Assert.assertNotNull(driver, "WebDriver is null");

		CommonMethods.scrollToElement(driver, insightPage.Insight_Tool_Section, "100");
		Thread.sleep(3000);


		Assert.assertTrue(CommonMethods.verifyElementDisplayed(driver, insightPage.Insight_Tool_Section, 10),"Insight tool section not displayed");

		// Select Role
		CommonMethods.clickElement(driver, insightPage.Role_Button, 20);
		CommonMethods.clickElement(driver, insightPage.Role_TextBox, 20);
		Thread.sleep(3000);
		CommonMethods.clearText(driver, insightPage.Role_Button, 10);
		Thread.sleep(3000);
		CommonMethods.sendKeysElement(driver, insightPage.Role_TextBox, role, 5);
		Thread.sleep(3000);

		selectFromDropdown(insightPage.RoleNameList, role);

		// Takes screenshot
		ReportUtil.addStepScreenshot("Role selected");

		// Select Country
		CommonMethods.clickElement(driver, insightPage.Country_TextBox, 20);
		Thread.sleep(3000);
		CommonMethods.clearText(driver, insightPage.Country_Value, 10);
		Thread.sleep(3000);
		System.out.println("Text box is cleared");
		CommonMethods.sendKeysElement(driver, insightPage.Country_TextBox, country, 5);
		Thread.sleep(3000);

		selectFromDropdown(insightPage.CountryNameList, country);

		// Takes screenshot
		ReportUtil.addStepScreenshot("Country selected");

		// Search and validate
		CommonMethods.clickElement(driver, insightPage.SearchButton, 20);
		CommonMethods.verifyElementDisplayed(driver, insightPage.SalaryTable, 20);
		Thread.sleep(3000);

		CommonMethods.scrollToElement(driver, insightPage.RequestDemoBtn, "100");
		Thread.sleep(3000);

		// Takes screenshot
		ReportUtil.addStepScreenshot("Result Displayed");


		String tableText = driver.findElement(insightPage.SalaryTable).getText();
		String normalizedText = tableText.replaceAll("\\s+", " ").trim();

		Assert.assertTrue(normalizedText.contains(role),
				"Role '" + role + "' not found in table: " + normalizedText);
		Assert.assertTrue(normalizedText.contains(country),
				"Country '" + country + "' not found in table: " + normalizedText);

		System.out.printf("Validation passed for %s in %s! Table displays: %s%n",role,country,normalizedText);
		System.out.println(normalizedText);


	}

	public void selectthirdfromdropdown(By RoleNameList, String role) {


		CommonMethods.waitUntilVisibilityOfElementByXpath(driver, insightPage.RoleNameList, 10);



		List<WebElement> drops = driver.findElements(RoleNameList);
		System.out.println("Number of dropdown items found: " + drops.size());

		for (WebElement item : drops)
		{
			String droptext = item.getText().trim();
			System.out.println("Found dropdown item: " + droptext);
			if (droptext.equals(role))
			{
				System.out.println("Role selected is " + droptext);
				item.click();
				break;
			}
		}


	}


	// Helper method to select from dropdown
	public void selectFromDropdown(By locator, String value) throws InterruptedException {
		List<WebElement> items = driver.findElements(locator);
		for (WebElement item : items) {
			if (item.getText().trim().equals(value)) {
				item.click();
				Thread.sleep(3000);
				break;
			}
		}
	}


	public void Dropdowntest(String role, String country) throws Exception{

		CommonMethods.scrollToElement(driver, insightPage.Insight_Tool_Section, "100");
		CommonMethods.waitUntilVisibilityOfElementByXpath(driver, insightPage.Insight_Tool_Section, 30);

		CommonMethods.clickElement(driver, insightPage.Role_Button, 20);

		selectthirdfromdropdown(insightPage.RoleNameList, role);
		

	}
	


	public void RandomDroptest(String role, int index) throws Exception {
		
		CommonMethods.scrollToElement(driver, insightPage.Insight_Tool_Section, "100");
		CommonMethods.waitUntilVisibilityOfElementByXpath(driver, insightPage.Insight_Tool_Section, 30);

		CommonMethods.clickElement(driver, insightPage.Role_Button, 20);
		CommonMethods.waitUntilVisibilityOfElementByXpath(driver, insightPage.RoleNameList, 10);
		
		String dynamicxpath = ".//*[@role='listbox']//li[" + index + "]";
		WebElement randomelement = driver.findElement(By.xpath(dynamicxpath));
		
		String Rolename = randomelement.getText().trim();
		System.out.println("Element selected is " +Rolename);
		randomelement.click();
		
	}

	public void validatefilter(String role) throws Exception {
		
		CommonMethods.scrollToElement(driver, insightPage.FilterBar, "100");
		CommonMethods.waitUntilVisibilityOfElementByXpath(driver, insightPage.FilterBar, 30);
		
		Thread.sleep(10000);
		
		CommonMethods.waitUntilVisibilityOfElementByXpath(driver, insightPage.FirstFilter, 30);
		CommonMethods.clickElement(driver, insightPage.FirstFilter, 20);
		
		CommonMethods.verifyElementDisplayed(driver, insightPage.FilterHeading, 20);
		
		CommonMethods.clickElement(driver, insightPage.FilterSearchBox, 20);
		
		
//		CommonMethods.clearText(driver, insightPage.FilterSearchBox, 10);
//		
//		CommonMethods.sendKeysElement(driver, insightPage.FilterSearchBox, role, 5);
		
		CommonMethods.verifyElementDisplayed(driver, insightPage.FilterRadioGroup, 20);
		
		List<WebElement> radioitems = driver.findElements(insightPage.FilterRadioList);
		
		for (WebElement item : radioitems)
		{
			if(item.getText().trim().equals(role))
			{
				System.out.println("Selected radio button is " + item);
				item.click();
				break;
			}
		}
		
		CommonMethods.waitUntilVisibilityOfElementByXpath(driver, insightPage.FormHeading, 30);
		
		
		
		
	}



}
