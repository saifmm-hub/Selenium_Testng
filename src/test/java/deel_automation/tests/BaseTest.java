package deel_automation.tests;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import deel_automation.context.WebDriverContext;
import deel_automation.factory.PageinstancesFactory;
import deel_automation.listeners.LogListener;
import deel_automation.listeners.ReportListener;
import deel_automation.pages.SalaryInsightPage;
import deel_automation.util.LoggerUtil;
import deel_automation.util.TestProperties;
import io.github.bonigarcia.wdm.WebDriverManager;


@Listeners({ ReportListener.class, LogListener.class })
public class BaseTest {

	/** The driver. */
	protected WebDriver driver;
    protected SalaryInsightPage insightPage;
    protected Properties properties;

	/**
	 * Global setup.
	 */
	@BeforeSuite(alwaysRun = true)
	public void globalSetup() {
		LoggerUtil.log("************************** Test Execution Started ************************************");
		TestProperties.loadAllPropertie();
	}

	/**
	 * Wrap all up.
	 *
	 */
	@AfterSuite(alwaysRun = true)
	public void wrapAllUp(ITestContext context) {
		int total = context.getAllTestMethods().length;
		int passed = context.getPassedTests().size();
		int failed = context.getFailedTests().size();
		int skipped = context.getSkippedTests().size();
		LoggerUtil.log("Total number of testcases : " + total);
		LoggerUtil.log("Number of testcases Passed : " + passed);
		LoggerUtil.log("Number of testcases Failed : " + failed);
		LoggerUtil.log("Number of testcases Skipped  : " + skipped);
		LoggerUtil.log("************************** Test Execution Finished ************************************");
	}

	/**
	 * Setup.
	 */
	@BeforeClass
	protected void setup() throws IOException {
//		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("disable-infobars");
		driver = new ChromeDriver(ops);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverContext.setDriver(driver);
	       insightPage = PageinstancesFactory.getInstance(SalaryInsightPage.class);
	        
	        // Load test data from properties file
	        properties = new Properties();
	        try (InputStream input = getClass().getClassLoader()
	                .getResourceAsStream("config/test.properties")) {
	            if (input == null) throw new IOException("test.properties not found!");
	            properties.load(input);
	        }
	        
	        // Navigate to the application URL once
	        driver.get("https://growth.deel.training/dev/salary-insights");

	}

	/**
	 * Wrap up.
	 */
	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}
}
