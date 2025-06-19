selenium-testng-framework
---

---
A sample framework based on Page Object Model, Selenium, TestNG using Java.

This framework is based in **Page Object Model (POM).**

The framework uses:

1. Java
2. Selenium
3. TestNG
4. ExtentReport
5. Log4j


Steps to create test cases:
----


1.Create SalaryInsightPage in **pages** package.  
  A page class typically should contain all the elements that are present on the page and corresponding action methods.
  Also the common methods that can be resued
  
  ```
  public class SalaryInsightPage extends BasePage {

	public SalaryInsightPage(WebDriver driver) {
		super(driver);
	}
	
	public By Insight_Tool_Section = By.xpath("//div//h2[contains(text(),'Salary Insights Tool')]");
	public By Role_Button = By.xpath("//input[contains(@name,'role')]");
	public By Country_Value = By.xpath("//input[contains(@name,'country')]");
	public By Role_TextBox = By.xpath(".//*[@placeholder='Select a role']");
	public By RoleNameList = By.xpath(".//*[@role='listbox']//li");
	public By RequestDemoBtn = By.xpath("//button[contains(@id,'request-a-demo')]");
	

}
```
2.Create the test class which class the methods of SalaryInsightPage
Use TestNG annotations for setting priority, description, groups, etc  

```
public class SalaryInsightTests extends BaseTest {


	// Test Case 1: Accountant in Brazil
    @Test(priority = 1, description = "Validate salary insights for Accountant in Brazil")
    public void testAccountantInBrazil() throws Exception {
        validateSalaryInsights(properties.getProperty("Role_1"), properties.getProperty("Country_1"));
    }
    
}
```
3.Add the test class in testng.xml file under the folder `src/test/resources/suites/`

```
<suite name="Deel Automation Suite">
	<listeners>
	 </listeners>
	<test thread-count="5" name="Test" parallel="classes">
		<classes>
			<class name="deel_automation.tests.SalaryInsightTests" />
		</classes>
	</test> <!-- Test -->
</suite> <!-- Suite -->

```

4. TEST EXECUTION

Prerequisites:
Maven installed (if using Maven project)
Java installed
TestNG added to classpath

Running in Eclipse

Method 1: 
Using TestNG Plugin
Right-click on your testng.xml file
Select "Run As" > "TestNG Suite"
View results in the TestNG tab in Eclipse

Method 2: 
Running Individual Test Classes
Right-click on any test class (e.g., SalaryInsightTests.java)
Select "Run As" > "TestNG Test"
Results will appear in the TestNG tab


Method 3:
Running the Runner Class
Right-click on TestRunner.java (src/test/java/deel_automation/tests/TestRunner.java)
Select "Run As" > "Java Application"
View console output for results

---

Reporting
---
The framework gives report in three ways,

1. Log - In file `logfile.log`.
2. A html report - Which is generated using extent reports, under the folder `ExtentReports`.
3. A mail report - For which the toggle `mail.sendmail` in `test.properties` should be set `true`. And all the properties such as `smtp host, port, proxy details, etc.,` should be provided correctly.

---

Key Points:
---

1. The class `WebDriverContext` is responsible for maintaining the same WebDriver instance throughout the test. So whenever you require a webdriver instance which has been using for current test (In current thread) always call `WebDriverContext.getDriver()`.

---

>For any query or suggestions please do comment or mail 
