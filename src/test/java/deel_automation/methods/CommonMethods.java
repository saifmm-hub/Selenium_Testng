package deel_automation.methods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;




public class CommonMethods {


	
	public static void clickElement(WebDriver driver, By locator, int Timeout) throws InterruptedException {
		if (verifyElementDisplayed(driver, locator, Timeout)) {

			try {
				waitUntilElementIsClickableByXpath(driver, locator, Timeout);
				driver.findElement((locator)).click();
			} catch (Exception e) {
				Assert.assertTrue(false, "Element is not displayed with xpath " + locator);
			}
		} else
			Assert.assertTrue( false, "Element is not displayed with xpath " + locator);
	}

	public static boolean verifyElementDisplayed(WebDriver driver, By locator, int Timeout)
			throws InterruptedException {
		boolean status = false;
		try {
			waitUntilVisibilityOfElementByXpath(driver, locator, Timeout);
			if (driver.findElement((locator)).isDisplayed())
				status = true;
		} catch (Exception e) {
			status = false;
		}
		return status;
	}
	
	public static void driverWait(WebDriver driver, int waitTime) {
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
	}

	public static void waitForpageLoad(WebDriver driver, int waitTime) {
		driver.manage().timeouts().pageLoadTimeout(waitTime, TimeUnit.SECONDS);
	}

	public static void waitUntilVisibilityOfElementByXpath(WebDriver driver, By locator, int Timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated((locator)));
	}

	public static void waitUntilElementIsClickableByXpath(WebDriver driver, By locator, int Timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Timeout);
		wait.until(ExpectedConditions.elementToBeClickable((locator)));
	}

	public static void waitUntilInVisibilityOfElementByXpath(WebDriver driver, By locator, int Timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Timeout);
		wait.until(ExpectedConditions.invisibilityOfElementLocated((locator)));
	}
	
	public static void scrollToElement(WebDriver driver, By locator, String pixelValue) throws Exception {

		CommonMethods.waitUntilVisibilityOfElementByXpath(driver, locator, 10);
		WebElement QtyPlusButton = driver.findElement((locator));


			Actions actions = new Actions(driver);
			actions.moveToElement(QtyPlusButton);
			actions.build().perform();
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0," + pixelValue + ")", "");
		Thread.sleep(500);
	}
	
	public static void sendKeysElement(WebDriver driver, By locator, String InputValue, int Timeout)
			throws InterruptedException {
		String Value = driver.findElement((locator)).getAttribute("value");
		if (!Value.isEmpty()) {
			driver.findElement((locator)).click();
			driver.findElement((locator)).clear();
		}
		driver.findElement((locator)).sendKeys(InputValue);
	}
	
	public static void clearText(WebDriver driver, By locator, int Timeout) throws Exception {
		try {
			Assert.assertTrue(verifyElementDisplayed(driver, locator, Timeout), "Element is not displayed");
			WebElement element = driver.findElement(locator);
			
			String os = System.getProperty("os.name").toLowerCase();
			Keys cmdKey = os.contains("mac") ? Keys.COMMAND : Keys.CONTROL;

	        
	        // Focus and select all text
	        element.click();
	        element.sendKeys(cmdKey + "a");
	        element.sendKeys(Keys.DELETE);
	        
	        // Verify empty
//	        if (!element.getAttribute("value").isEmpty()) {
//	            element.clear();
//	        }
	        
	    } catch (Exception e) {
	        System.err.println("Clear text failed for: " + locator);
	        throw e;
	    }
	}
	



}
